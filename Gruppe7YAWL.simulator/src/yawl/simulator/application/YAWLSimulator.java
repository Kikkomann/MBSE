package yawl.simulator.application;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetannotationsFactory;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.applications.ui.ApplicationUIManager;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.pnmlcoremodel.Arc;
import org.pnml.tools.epnk.pnmlcoremodel.Node;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;
import org.pnml.tools.epnk.pnmlcoremodel.PlaceNode;
import org.pnml.tools.epnk.pnmlcoremodel.RefPlace;
import org.pnml.tools.epnk.pnmlcoremodel.RefTransition;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import yawl.helpers.YAWLFunctions;
import yawl.Place;
import yawl.Transition;
import yawl.helpers.*;
import yawl.simulator.marking.NetMarking;
import yawl.yawlannotations.EnabledTransitions;
import yawl.yawlannotations.Marking;
import yawl.yawlannotations.SelectArcs;
import yawl.yawlannotations.YawlannotationsFactory;

/**
 * A first simulator application for YAWL nets.
 * 
 * TODO Note that this simulator does not yet take split and join types into
 * account; neither does it take reset arcs into account. Moreover, the user can
 * not select arcs yet. This needs to be extended!
 * 
 * @author ekki@dtu.dk
 *
 */
public class YAWLSimulator extends ApplicationWithUIManager {

	private FlatAccess flatAccess;
	private NetChangeListener adapter;

	public YAWLSimulator(PetriNet petrinet) {
		super(petrinet);
		flatAccess = FlatAccess.getFlatAccess(petrinet);

		getNetAnnotations().setName("A simple YAWL simulator from Group 7");
		ApplicationUIManager manager = this.getPresentationManager();
		manager.addActionHandler(new EnabledTransitionHandler(this));
		manager.addActionHandler(new SelectArcHandler(this));
		manager.addPresentationHandler(new YAWLAnnotationsPresentationHandler());

		adapter = new NetChangeListener(this);
		flatAccess.addInvalidationListener(adapter);
	}

	public FlatAccess getFlatAccess() {
		return flatAccess;
	}

	@Override
	protected void initializeContents() {
		NetMarking initialMarking = computeInitialMarking();
		NetAnnotation initialAnnotation = computeAnnotation(initialMarking);

		this.getNetAnnotations().getNetAnnotations().add(initialAnnotation);
		this.getNetAnnotations().setCurrent(initialAnnotation);
	}

	 NetMarking computeInitialMarking() {
		NetMarking marking = new NetMarking();
		for (org.pnml.tools.epnk.pnmlcoremodel.Place place : getFlatAccess().getPlaces()) {
			if (place instanceof Place && YAWLFunctions.getType(place) == PlaceType.START) {
				marking.setMarking((Place) place, 1);
			}
		}
		return marking;
	}

	NetMarking computeMarking() {
		NetMarking marking = new NetMarking();
		for (ObjectAnnotation annotation : this.getNetAnnotations().getCurrent().getObjectAnnotations()) {
			if (annotation instanceof Marking) {
				Marking markingAnnotation = (Marking) annotation;
				Object object = markingAnnotation.getObject();
				int value = markingAnnotation.getValue();
				if (object instanceof Place && value > 0) {
					Place place = (Place) object;
					marking.setMarking(place, value);
				}
			}
		}
		return marking;
	}

	NetAnnotation computeAnnotation(NetMarking marking) {
		FlatAccess flatAccess = getFlatAccess();
		NetAnnotation annotation = NetannotationsFactory.eINSTANCE.createNetAnnotation();
		annotation.setNet(getPetrinet());
		Map<Object, Marking> place2MarkingAnnotation = new HashMap<Object, Marking>();
		for (Place place : marking.getSupport()) {
			int value = marking.getMarking(place);
			if (value > 0) {
				Marking markingAnnotation = YawlannotationsFactory.eINSTANCE.createMarking();
				markingAnnotation.setValue(value);
				markingAnnotation.setObject(place);
				annotation.getObjectAnnotations().add(markingAnnotation);
				place2MarkingAnnotation.put(place, markingAnnotation);

				// TODO also annotate reference places with the current marking
				// of the place

			}
		}

		Set<Transition> enabled = new HashSet<Transition>();

		for (org.pnml.tools.epnk.pnmlcoremodel.Transition trans : flatAccess.getTransitions()) {
			if (trans instanceof Transition) {
				if (enabled(flatAccess, marking, (Transition) trans)) {
					enabled.add((Transition) trans);

					EnabledTransitions transitionAnnotation = YawlannotationsFactory.eINSTANCE
							.createEnabledTransitions();
					transitionAnnotation.setObject(trans);
					annotation.getObjectAnnotations().add(transitionAnnotation);

					// TODO also annotate reference places with the current
					// marking of the place

					if (YAWLFunctions.getJoinType(trans).equals(TransitionType.XOR)) {
						boolean first = true;
						for (Object in : flatAccess.getIn(trans)) {
							if (in instanceof Arc) {
								if (!YAWLFunctions.isResetArc((Arc) in)) {
									Marking sourceMarking = place2MarkingAnnotation.get(((Arc) in).getSource());
									if (sourceMarking != null) {
										SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArcs();
										arcAnnotation.setObject(((Arc) in));
										arcAnnotation.setSourceMarking(sourceMarking);
										arcAnnotation.setTargetTransition(transitionAnnotation);
										if (first) {
											arcAnnotation.setSelected(true);
											first = false;
										} else {
											arcAnnotation.setSelected(false);
										}
										annotation.getObjectAnnotations().add(arcAnnotation);
									}
								}
							}
						}
					}

					// Makes sure outgoing arcs are selected and attached to the
					// corresponding Transition:
					if (YAWLFunctions.getSplitType(trans).equals(TransitionType.XOR)) {
						boolean first = true;
						for (Object out : flatAccess.getOut(trans)) {
							if (out instanceof Arc) {
								SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArcs();
								arcAnnotation.setObject(((Arc) out));
								arcAnnotation.setSourceTransition(transitionAnnotation);
								if (first) {
									arcAnnotation.setSelected(true);
									first = false;
								} else {
									arcAnnotation.setSelected(false);
								}
								annotation.getObjectAnnotations().add(arcAnnotation);
							}
						}
					}

					// Same as above, but here more arcs can be selected:
					if (YAWLFunctions.getSplitType(trans).equals(TransitionType.OR)) {
						for (Object out : flatAccess.getOut(trans)) {
							if (out instanceof Arc) {
								SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArcs();
								arcAnnotation.setObject(((Arc) out));
								arcAnnotation.setSourceTransition(transitionAnnotation);
								arcAnnotation.setSelected(true);
								annotation.getObjectAnnotations().add(arcAnnotation);
							}
						}
					}

				}
			}
		}
	}

	// private NetAnnotation computeAnnotation(NetMarking marking) {
	// NetAnnotation annotation =
	// NetannotationsFactory.eINSTANCE.createNetAnnotation();
	// annotation.setNet(getPetrinet());
	//
	// for (Object object: getFlatAccess().getTransitions()) {
	// if (object instanceof Transition) {
	// Transition transition = (Transition) object;
	// if (isEnabled(marking, transition)) {
	// EnabledTransitions enabledTransition =
	// YawlannotationsFactory.eINSTANCE.createEnabledTransitions();
	// enabledTransition.setObject(transition);
	// annotation.getObjectAnnotations().add(enabledTransition);
	// enabledTransition.setEnabled(true);
	//
	// for (RefTransition refTransition:
	// getFlatAccess().getRefTransitions(transition)) {
	// EnabledTransitions enabledTransition2 =
	// YawlannotationsFactory.eINSTANCE.createEnabledTransitions();
	// enabledTransition2.setObject(refTransition);
	// enabledTransition2.setResolved(enabledTransition);
	// enabledTransition2.setEnabled(enabledTransition.isEnabled());
	// annotation.getObjectAnnotations().add(enabledTransition2);
	// }
	// }
	// }
	// }
	//
	// for (Place place: marking.getSupport()) {
	// int mark = marking.getMarking(place);
	//
	// // TODO create and add the Marking annotations for each place (condition)
	// in the
	// // support of the marking
	// if (mark > 0) {
	// Marking mAnnotation = YawlannotationsFactory.eINSTANCE.createMarking();
	// mAnnotation.setObject(place);
	// mAnnotation.setValue(mark);
	// annotation.getObjectAnnotations().add(mAnnotation);
	//
	// // TODO also make sure that all reference places referring to the
	// condition
	// // get the respective annotation
	// for (RefPlace refPlace : getFlatAccess().getRefPlaces(place)) {
	// Marking mAnnotation2 = YawlannotationsFactory.eINSTANCE.createMarking();
	// mAnnotation2.setObject(refPlace);
	// mAnnotation2.setValue(mark);
	// annotation.getObjectAnnotations().add(mAnnotation2);
	// }
	// }
	// }
	// return annotation;
	// }

	// boolean fireTransition(Transition transition) {
	// NetMarking marking1 = this.computeMarking();
	//
	// if (this.isEnabled(marking1, transition)) {
	// NetMarking marking2 = this.fireTransition(marking1, transition);
	// NetAnnotation netAnnotation = this.computeAnnotation(marking2);
	// netAnnotation.setNet(this.getPetrinet());
	//
	// this.deleteNetAnnotationAfterCurrent();
	// this.addNetAnnotationAsCurrent(netAnnotation);
	// return true;
	// }
	// return false;
	// }

	// TODO Kan være jeg skal ændre implementationerne, da Ekkart's
	// specifikations kan være anderledes end vores.

	NetMarking fireTransition(FlatAccess flatNet, NetMarking marking1, Arc selectedInArc, Transition transition,
			Collection<Arc> selectedOutArcs) {
		NetMarking marking2 = new NetMarking(marking1);

		TransitionType joinType = YAWLFunctions.getJoinType(transition);

		if (joinType.equals(TransitionType.AND) || joinType.equals(TransitionType.SINGLE)) {
			for (Object in : flatNet.getIn(transition)) {
				if (in instanceof Arc) {
					Arc inArc = (Arc) in;
					if (!YAWLFunctions.isResetArc(inArc)) {
						Object source = inArc.getSource();
						if (source instanceof PlaceNode) {
							source = flatNet.resolve((PlaceNode) source);
							if (source instanceof Place) {
								marking2.decrementMarkingBy((Place) source, 1);
							}
						}
					}
				}
			}
		} else if (joinType.equals(TransitionType.OR)) {
			for (Object in : flatNet.getIn(transition)) {
				if (in instanceof Arc) {
					Arc inArc = (Arc) in;
					if (!YAWLFunctions.isResetArc(inArc)) {
						Object source = inArc.getSource();
						if (source instanceof PlaceNode) {
							source = flatNet.resolve((PlaceNode) source);
							if (source instanceof Place) {
								if (marking2.getMarking((Place) source) > 0) {
									marking2.decrementMarkingBy((Place) source, 1);
								}
							}
						}
					}
				}
			}
		} else if (joinType.equals(TransitionType.XOR) && selectedInArc != null
				&& !YAWLFunctions.isResetArc(selectedInArc)) {
			Node target = selectedInArc.getTarget();
			if (target instanceof TransitionNode) {
				org.pnml.tools.epnk.pnmlcoremodel.Transition trans = flatNet.resolve((TransitionNode) target);
				if (transition == trans) {
					Object source = selectedInArc.getSource();
					if (source instanceof PlaceNode) {
						source = flatNet.resolve((PlaceNode) source);
						if (source instanceof Place) {
							if (marking2.getMarking((Place) source) > 0) {
								marking2.decrementMarkingBy((Place) source, 1);
							}
						}
					}
				}
			}
		}

		// Iteration over all reset arcs, which will be set to 0
		for (Object in : flatNet.getIn(transition)) {
			if (in instanceof Arc) {
				Arc inArc = (Arc) in;
				if (YAWLFunctions.isResetArc(inArc)) {
					Object source = inArc.getSource();
					if (source instanceof PlaceNode) {
						source = flatNet.resolve((PlaceNode) source);
						if (source instanceof Place) {
							marking2.setMarking((Place) source, 0);
						}
					}
				}
			}
		}

		// Reduce token for all outgoing arcs on and (and single?):
		TransitionType splitType = YAWLFunctions.getSplitType(transition);
		if (splitType.equals(TransitionType.AND) || splitType.equals(TransitionType.SINGLE)) {
			for (Object out : flatNet.getOut(transition)) {
				if (out instanceof Arc) {
					Arc outArc = (Arc) out;
					Object target = outArc.getTarget();
					if (target instanceof PlaceNode) {
						target = flatNet.resolve((PlaceNode) target);
						if (target instanceof Place) {
							marking2.incrementMarkingBy((Place) target, 1);
						}
					}
				}
			}
			// produce token on all target places:
		} else if (splitType.equals(TransitionType.OR)
				|| splitType.equals(TransitionType.XOR) && selectedOutArcs != null) {
			for (Arc outArc : selectedOutArcs) {
				Node source = outArc.getSource();
				if (source instanceof TransitionNode) {
					source = flatNet.resolve((TransitionNode) source);
				}
				if (transition == source) {
					Object target = outArc.getTarget();
					if (target instanceof PlaceNode) {
						target = flatNet.resolve((PlaceNode) target);
						if (target instanceof Place) {
							marking2.incrementMarkingBy((Place) target, 1);
						}
					}
				}
			}
		}
		return marking2;
	}

	// private NetMarking fireTransition(NetMarking marking1, Transition
	// transition) {
	// NetMarking marking2 = new NetMarking(marking1);
	//
	// // consume tokens from preset
	// NetMarking consumes = consumes(transition);
	// marking2.subtract(consumes);
	//
	// // reset places on page connected to reset arc
	// // TODO
	//
	// // produce tokens on postset
	// NetMarking produces = produces(transition);
	// marking2.add(produces);
	//
	// return marking2;
	// }

	boolean isEnabled(NetMarking marking, Transition transition) {
		NetMarking consumes = consumes(transition);
		return marking.isGreaterOrEqual(consumes);
	}

	boolean enabled(FlatAccess flatAccess, NetMarking netMarking, Transition transition) {
		// This does not work if there is more than one arc between the same
		// place and the same transition. This is exluded by constraints anyway
		// TODO make the constraint(if not already made)
		TransitionType joinType = YAWLFunctions.getJoinType(transition);
		if (joinType.equals(TransitionType.AND) || joinType.equals(TransitionType.SINGLE)) {
			for (Object in : flatAccess.getIn(transition)) {
				if (in instanceof Arc) {
					Arc arc = (Arc) in;
					if (!YAWLFunctions.isResetArc(arc)) {
						Object source = arc.getSource();
						if (source instanceof PlaceNode) {
							source = flatAccess.resolve((PlaceNode) source);
							if (source instanceof Place) {
								if (netMarking.getMarking((Place) source) < 1) {
									return false;
								}
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
			}
			return true;
			// Checker om mindst en incoming arc har en token
		} else if (joinType.equals(TransitionType.OR) || joinType.equals(TransitionType.XOR)) {
			for (Object in : flatAccess.getIn(transition)) {
				if (in instanceof Arc) {
					Arc arc = (Arc) in;
					if (!YAWLFunctions.isResetArc(arc)) {
						Object source = arc.getSource();
						if (source instanceof PlaceNode) {
							source = flatAccess.resolve((PlaceNode) source);
							if (source instanceof Place) {
								if (netMarking.getMarking((Place) source) > 0) {
									return true;
								}
							}
						}
					}
				}
			}
			return false;
		}
		return false;
	}

	NetMarking consumes(Transition transition) {
		NetMarking consumes = new NetMarking();

		for (Arc arc : getFlatAccess().getIn(transition)) {

			if (arc instanceof Arc && YAWLFunctions.getType(arc) == ArcType.NORMAL) {
				// TODO compute for each source place the tokens needed
				// (consumed) for firing the transition

				Node source = arc.getSource();
				if (source instanceof PlaceNode) {
					source = getFlatAccess().resolve((PlaceNode) source);
					if (source instanceof Place) {
						consumes.incrementMarkingBy((Place) source, 1);
					}
				}
			}
		}
		return consumes;
	}

	NetMarking produces(Transition transition) {
		NetMarking produces = new NetMarking();
		for (org.pnml.tools.epnk.pnmlcoremodel.Arc arc : getFlatAccess().getOut(transition)) {
			// TODO compute for each target place the tokens produced when
			// firing the transition

			Node target = arc.getTarget();
			if (target instanceof PlaceNode) {
				target = getFlatAccess().resolve((PlaceNode) target);
				if (target instanceof Place) {
					produces.incrementMarkingBy((Place) target, 1);
				}
			}

		}
		return produces;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pnml.tools.epnk.applications.Application#shutDown()
	 */
	@Override
	protected void shutDown() {
		super.shutDown();

		if (flatAccess != null && adapter != null) {
			flatAccess.removeInvalidationListener(adapter);
			adapter = null;
		}
	}

}