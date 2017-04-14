package dk.dtu.mbse.group7.yawl.simulator.application;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetannotationsFactory;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.applications.ui.ApplicationUIManager;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.pnmlcoremodel.Node;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;
//import org.pnml.tools.epnk.pnmlcoremodel.Place;
import org.pnml.tools.epnk.pnmlcoremodel.PlaceNode;
import org.pnml.tools.epnk.pnmlcoremodel.RefPlace;
import org.pnml.tools.epnk.pnmlcoremodel.RefTransition;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import dk.dtu.mbse.group7.yawl.AType;
import dk.dtu.mbse.group7.yawl.Arc;
import dk.dtu.mbse.group7.yawl.Transition;
import dk.dtu.mbse.group7.yawl.PType;
import dk.dtu.mbse.group7.yawl.helpers.ArcType;
import dk.dtu.mbse.group7.yawl.helpers.PlaceType;
import dk.dtu.mbse.group7.yawl.helpers.TransitionType;
import dk.dtu.mbse.group7.yawl.helpers.YAWLFunctions;
import dk.dtu.mbse.group7.yawl.simulator.marking.NetMarking;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.Marking;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsFactory;
import dk.dtu.mbse.group7.yawl.Place;

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
		flatAccess = FlatAccess.getFlatAccess(this.getPetrinet());

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
		// Sætter start place til at starte med en token
		NetMarking initialMarking = computeInitialMarking();
		// Viser hvilke transition der er enabled og finder, hvor mange tokens
		// der er i de forskellige places.
		NetAnnotation initialAnnotation = computeAnnotation(initialMarking);

		this.getNetAnnotations().getNetAnnotations().add(initialAnnotation);
		this.getNetAnnotations().setCurrent(initialAnnotation);
	}

	/**
	 * @author RuneHou
	 */
	// TODO: Lavet selv, men præcis det samme som Ekkart's (bortset fra else'en)
	private NetMarking computeInitialMarking() {
		NetMarking marking = new NetMarking();
		for (org.pnml.tools.epnk.pnmlcoremodel.Place place : this.getFlatAccess().getPlaces()) {
			if (place instanceof Place) {
				if (YAWLFunctions.getType(place) == PlaceType.START) {
					marking.setMarking((Place) place, 1);
				} else {
					marking.setMarking((Place) place, 0);
				}
			}
		}
		return marking;
	}

	// TODO Kopieret Ekkart's
	public NetMarking computeMarking() {
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

	/**
	 * @author RuneHou
	 */
	public NetAnnotation computeAnnotation(NetMarking marking) {
		NetAnnotation annotation = NetannotationsFactory.eINSTANCE.createNetAnnotation();
		annotation.setNet(getPetrinet());
		Map<Object, Marking> place2MarkingAnnotation = new HashMap<Object, Marking>();
		for (Object object : getFlatAccess().getTransitions()) {
			if (object instanceof Transition) {
				Transition transition = (Transition) object;
				// TODO Skal den rykkes længere ned? Skal dette ske lige meget
				// om enabled eller ej?
				if (enabled(flatAccess, marking, transition)) {
					EnabledTransitions enabledTransition = YawlannotationsFactory.eINSTANCE.createEnabledTransitions();
					enabledTransition.setObject(transition);
					annotation.getObjectAnnotations().add(enabledTransition);
					enabledTransition.setEnabled(true);

					for (RefTransition refTransition : getFlatAccess().getRefTransitions(transition)) {
						EnabledTransitions enabledTransition2 = YawlannotationsFactory.eINSTANCE
								.createEnabledTransitions();
						enabledTransition2.setObject(refTransition);
						enabledTransition2.setResolved(enabledTransition);
						enabledTransition2.setEnabled(enabledTransition.isEnabled());
						annotation.getObjectAnnotations().add(enabledTransition2);
					}
				}
			}
		}

		// For hvert place der har en marking > 0, laves der en annotation
		// marking
		for (Place place : marking.getSupport()) {
			int m = marking.getMarking(place);
			if (m > 0) {
				Marking markingAnnotation = YawlannotationsFactory.eINSTANCE.createMarking();
				markingAnnotation.setObject(place);
				markingAnnotation.setValue(m);
				annotation.getObjectAnnotations().add(markingAnnotation);
				place2MarkingAnnotation.put(place, markingAnnotation);
			}
			for (RefPlace refPlace : getFlatAccess().getRefPlaces(place)) {
				Marking markingAnnotation = YawlannotationsFactory.eINSTANCE.createMarking();
				markingAnnotation.setObject(refPlace);
				markingAnnotation.setValue(m);
				annotation.getObjectAnnotations().add(markingAnnotation);
			}
		}

		for (Object object : flatAccess.getTransitions()) {
			if (object instanceof Transition) {
				Transition transition = (Transition) object;
				if (enabled(flatAccess, marking, (Transition) transition)) {
					EnabledTransitions transitionAnnotations = YawlannotationsFactory.eINSTANCE
							.createEnabledTransitions();
					transitionAnnotations.setObject(transition);
					annotation.getObjectAnnotations().add(transitionAnnotations);
					// TODO Skal denne linje være her?
					transitionAnnotations.setEnabled(true);
					// TODO Skal jeg have disse? Mikkel har dem (flere steder)
					// enabledTransition.getOutArcs().add(arcAnnotation);

					for (RefTransition refTrans : getFlatAccess().getRefTransitions(transition)) {
						EnabledTransitions refTransitionAnnotations = YawlannotationsFactory.eINSTANCE
								.createEnabledTransitions();
						transitionAnnotations.setObject(refTrans);
						annotation.getObjectAnnotations().add(refTransitionAnnotations);
					}

					if (YAWLFunctions.getJoinType(transition).equals(TransitionType.XOR)) {
						boolean firstArc = true;
						for (Object in : flatAccess.getIn(transition)) {
							if (in instanceof Arc) {
								Arc inArc = (Arc) in;
								if (!YAWLFunctions.isResetArc(inArc)) {
									Marking sourceMarking = place2MarkingAnnotation.get(((Arc) inArc).getSource());
									if (sourceMarking != null) {
										SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArcs();
										arcAnnotation.setObject(((Arc) inArc));
										arcAnnotation.setSourceMarking(sourceMarking);
										arcAnnotation.setTargetTransition(transitionAnnotations);
										if (firstArc) {
											arcAnnotation.setSelected(true);
											firstArc = false;
										} else {
											arcAnnotation.setSelected(false);
										}
										annotation.getObjectAnnotations().add(arcAnnotation);
									}
								}
							}
						}
					}

					if (YAWLFunctions.getJoinType(transition).equals(TransitionType.OR)) {
						for (Object in : flatAccess.getIn(transition)) {
							if (in instanceof Arc) {
								Arc inArc = (Arc) in;
								if (!YAWLFunctions.isResetArc(inArc)) {
									Marking sourceMarking = place2MarkingAnnotation.get(((Arc) inArc).getSource());
									if (sourceMarking != null) {
										SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArcs();
										arcAnnotation.setObject(((Arc) inArc));
										arcAnnotation.setSourceMarking(sourceMarking);
										arcAnnotation.setTargetTransition(transitionAnnotations);
										arcAnnotation.setSelected(true);
										annotation.getObjectAnnotations().add(arcAnnotation);
									}
								}
							}
						}
					}

					// Makes sure outgoing arcs are selected and attached to the
					// corresponding Transition:
					if (YAWLFunctions.getSplitType(transition).equals(TransitionType.XOR)) {
						boolean first = true;
						for (Object out : flatAccess.getOut(transition)) {
							if (out instanceof Arc) {
								SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArcs();
								arcAnnotation.setObject(((Arc) out));
								arcAnnotation.setSourceTransition(transitionAnnotations);
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
					if (YAWLFunctions.getSplitType(transition).equals(TransitionType.OR)) {
						for (Object out : flatAccess.getOut(transition)) {
							if (out instanceof Arc) {
								SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArcs();
								arcAnnotation.setObject(((Arc) out));
								arcAnnotation.setSourceTransition(transitionAnnotations);
								arcAnnotation.setSelected(true);
								annotation.getObjectAnnotations().add(arcAnnotation);
							}
						}
					}
				}
			}
		}
		return annotation;
	}

	boolean fireTransition(Transition transition, Arc inArc, Collection<Arc> outArcs) {
		NetMarking marking1 = this.computeMarking();
		FlatAccess flatAccess = getFlatAccess();

		if (this.enabled(flatAccess, marking1, transition)) {
			NetMarking marking2 = this.fireTransition(flatAccess, marking1, inArc, transition, outArcs);
			NetAnnotation netAnnotation = this.computeAnnotation(marking2);
			netAnnotation.setNet(this.getPetrinet());

			this.deleteNetAnnotationAfterCurrent();
			this.addNetAnnotationAsCurrent(netAnnotation);
			return true;
		}
		return false;
	}

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

	/**
	 * @author RuneHou
	 */
	boolean enabled(FlatAccess flatNet, NetMarking marking, Transition transition) {
		TransitionType joinType = YAWLFunctions.getJoinType(transition);
		if (joinType.equals(TransitionType.AND) || joinType.equals(TransitionType.SINGLE)) {
			for (Object in : flatNet.getIn(transition)) {
				if (in instanceof Arc) {
					Arc inArc = (Arc) in;
					if (!YAWLFunctions.isResetArc(inArc)) {
						Node source = inArc.getSource();
						if (source instanceof PlaceNode) {
							source = flatNet.resolve((PlaceNode) source);
							if (source instanceof Place || (marking.getMarking((Place) source) < 1)) {
								return false;
							}
						} else {
							// Source skal være en place
							return false;
						}
					} else {
						// Kan ikke bruge reset arcs
						return false;
					}
				}

			}
			return true;
		} else if (joinType.equals(TransitionType.OR) || joinType.equals(TransitionType.XOR)) {
			for (Object in : flatNet.getIn(transition)) {
				if (in instanceof Arc) {
					Arc inArc = (Arc) in;
					if (!YAWLFunctions.isResetArc(inArc)) {
						Node source = inArc.getSource();
						if (source instanceof PlaceNode) {
							source = flatNet.resolve((PlaceNode) source);
							if (source instanceof Place) {
								if (marking.getMarking((Place) source) > 0) {
									return true;
								}
							}
						}
					}
				}

			}
			// Hvis der ikke er nogle in-places med en token.
			return false;
		}
		return false;
	}

	// TODO Fjern, hvis simulator fungerer uden
	// /**
	// * @author RuneHou
	// */
	// private NetMarking consumes(Transition transition) {
	// NetMarking consumes = new NetMarking();
	//
	// for (Arc arc : getFlatAccess().getIn(transition)) {
	//
	// if (arc instanceof Arc && YAWLFunctions.getType(arc) == ArcType.NORMAL) {
	// Node source = arc.getSource();
	// // TODO Havde ikke selv fundet ud af det.
	// if (source instanceof PlaceNode) {
	// source = getFlatAccess().resolve((PlaceNode) source);
	// if (source instanceof Place) {
	// consumes.incrementMarkingBy((Place) source, 1);
	// }
	// }
	//
	// // TODO compute for each source place the tokens needed
	// // (consumed) for firing the transition
	//
	// // TODO account for reset arcs
	//
	// }
	// }
	//
	// return consumes;
	// }
	//
	// /**
	// * @author RuneHou
	// */
	// private NetMarking produces(Transition transition) {
	// NetMarking produces = new NetMarking();
	// for (org.pnml.tools.epnk.pnmlcoremodel.Arc arc :
	// getFlatAccess().getOut(transition)) {
	// if (arc instanceof Arc && YAWLFunctions.getType(arc) == ArcType.NORMAL) {
	// Node target = arc.getTarget();
	// if (target instanceof PlaceNode) {
	// target = getFlatAccess().resolve((PlaceNode) target);
	// if (target instanceof Place) {
	// produces.incrementMarkingBy((Place) target, 1);
	// }
	// }
	// // TODO account for reset arcs
	// }
	//
	// }
	// return produces;
	// }

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