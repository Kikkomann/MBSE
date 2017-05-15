package dk.dtu.mbse.group7.yawl.simulator.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetannotationsFactory;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.applications.ui.ApplicationUIManager;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.pnmlcoremodel.Node;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;
import org.pnml.tools.epnk.pnmlcoremodel.PlaceNode;
import org.pnml.tools.epnk.pnmlcoremodel.RefPlace;
import org.pnml.tools.epnk.pnmlcoremodel.RefTransition;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;
import org.pnml.tools.epnk.pnmlcoremodel.Object;

import dk.dtu.mbse.group7.yawl.Arc;
import dk.dtu.mbse.group7.yawl.Transition;
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
 */
public class YAWLSimulator extends ApplicationWithUIManager {

	private FlatAccess flatAccess;
	private NetChangeListener adapter;
	private Set<Transition> enabled = new HashSet<Transition>();
	private List<Object> inArcs = new ArrayList<Object>();
	private List<Object> warningList = new ArrayList<Object>();

	/**
	 * @author Magnus Haakonson
	 */
	public YAWLSimulator(PetriNet petrinet) {
		super(petrinet);

		getNetAnnotations().setName("A simple YAWL simulator from Group 7");
		ApplicationUIManager manager = this.getPresentationManager();
		manager.addActionHandler(new EnabledTransitionHandler(this));
		manager.addActionHandler(new SelectArcHandler(this));
		manager.addPresentationHandler(new YAWLAnnotationsPresentationHandler());

		flatAccess = FlatAccess.getFlatAccess(petrinet);
		adapter = new NetChangeListener(this);
		flatAccess.addInvalidationListener(adapter);
	}

	public FlatAccess getFlatAccess() {
		return flatAccess;
	}

	/**
	 * @author The Magnus Haakonson
	 */
	@Override
	protected void initializeContents() {
		// S�tter start place til at starte med en token
		NetMarking initialMarking = computeInitialMarking();
		// Viser hvilke transition der er enabled og finder, hvor mange tokens
		// der er i de forskellige places.
		NetAnnotation initialAnnotation = computeAnnotation(initialMarking);
		initialAnnotation.setNet(this.getPetrinet());

		this.getNetAnnotations().getNetAnnotations().add(initialAnnotation);
		this.getNetAnnotations().setCurrent(initialAnnotation);
	}

	/**
	 * @author Lukas Nyboe Bek - s153475
	 */
	private NetMarking computeInitialMarking() {
		NetMarking marking = new NetMarking();
		for (org.pnml.tools.epnk.pnmlcoremodel.Place place : flatAccess.getPlaces()) {
			if (place instanceof Place || YAWLFunctions.getType(place) == PlaceType.START) {
				if (YAWLFunctions.getType(place) == PlaceType.START) {
					marking.setMarking((Place) place, 1);
				} else {
					// S�rger for at det kun er start place der har en token
					marking.setMarking((Place) place, 0);
				}
			}
		}
		return marking;
	}

	/**
	 * @author Lukas Nyboe Bek - s153475
	 */
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
	 * @author Rune Hou Thode - s150157
	 */
	public NetAnnotation computeAnnotation(NetMarking marking) {
		NetAnnotation annotation = NetannotationsFactory.eINSTANCE.createNetAnnotation();
		annotation.setNet(getPetrinet());
		Map<Object, Marking> place2MarkingAnnotation = new HashMap<Object, Marking>();
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
			for (RefPlace refPlace : flatAccess.getRefPlaces(place)) {
				Marking markingAnnotation = YawlannotationsFactory.eINSTANCE.createMarking();
				markingAnnotation.setObject(refPlace);
				markingAnnotation.setValue(m);
				annotation.getObjectAnnotations().add(markingAnnotation);
			}

			for (Object object : flatAccess.getTransitions()) {
				if (object instanceof Transition) {
					Transition transition = (Transition) object;
					if (enabled(flatAccess, marking, transition)) {
						
						
//						List<Object> inArcs = new ArrayList<Object>();
//						for (Object obj : flatAccess.getIn(transition)) {
//							if (marking.getMarking((Place) ((Arc) obj).getSource()) < 1) {
//								inArcs.add(((Arc) obj));
//							}
//						}
//						List<Object> list = isWarningArc(inArcs, marking);
						
						
						EnabledTransitions transitionAnnotations = YawlannotationsFactory.eINSTANCE
								.createEnabledTransitions();
						transitionAnnotations.setObject(transition);
						annotation.getObjectAnnotations().add(transitionAnnotations);
						transitionAnnotations.setEnabled(true);
						enabled.add(transition);

						for (RefTransition refTrans : flatAccess.getRefTransitions(transition)) {
							EnabledTransitions refTransitionAnnotations = YawlannotationsFactory.eINSTANCE
									.createEnabledTransitions();
							refTransitionAnnotations.setObject(refTrans);
							annotation.getObjectAnnotations().add(refTransitionAnnotations);
						}

						if (YAWLFunctions.getJoinType(transition).equals(TransitionType.SINGLE)) {
							for (Object in : flatAccess.getIn(transition)) {
								if (in instanceof Arc) {
									Marking sourceMarking = place2MarkingAnnotation.get(((Arc) in).getSource());
									if (marking.getMarking((Place) ((Arc) in).getSource()) > 0) {
										SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArcs();
										arcAnnotation.setObject(((Arc) in));
										arcAnnotation.setSourceMarking(sourceMarking);
										arcAnnotation.setTargetTransition(transitionAnnotations);
										arcAnnotation.setSelected(true);
										annotation.getObjectAnnotations().add(arcAnnotation);
									}
								}
							}
						}

						// Compares the total number of in arcs with the number
						// of arcs with a source place with at least one token
						if (YAWLFunctions.getJoinType(transition).equals(TransitionType.AND)) {
							int inCount = flatAccess.getIn(transition).size();
							int count = 0;
							for (Object in : flatAccess.getIn(transition)) {
								if (in instanceof Arc) {
									if (marking.getMarking((Place) ((Arc) in).getSource()) > 0) {
										count++;
									}
								}
							}
							for (Object in : flatAccess.getIn(transition)) {
								if (in instanceof Arc) {
									Marking sourceMarking = place2MarkingAnnotation.get(((Arc) in).getSource());
									if (count == inCount) {
										SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArcs();
										arcAnnotation.setObject(((Arc) in));
										arcAnnotation.setSourceMarking(sourceMarking);
										arcAnnotation.setTargetTransition(transitionAnnotations);
										annotation.getObjectAnnotations().add(arcAnnotation);
									}
								}
							}
						}

						if (YAWLFunctions.getJoinType(transition).equals(TransitionType.XOR)) {
							boolean firstArc = true;
							List<org.pnml.tools.epnk.pnmlcoremodel.Arc> xorIn = flatAccess.getIn(transition);
							for (Object in : xorIn) {
								if (in instanceof Arc) {
									if (!YAWLFunctions.isResetArc((Arc) in)) {
										Marking sourceMarking = place2MarkingAnnotation.get(((Arc) in).getSource());
										if (sourceMarking != null) {
											SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE
													.createSelectArcs();
											arcAnnotation.setObject(((Arc) in));
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
							for (Object obj : flatAccess.getIn(transition)) {
								if (marking.getMarking((Place) ((Arc) obj).getSource()) < 1) {
									inArcs.add(((Arc) obj));
								}
							}
//							List<Object> list = isWarningArc(inArcs, marking);
							
							for (Object in : flatAccess.getIn(transition)) {
								if (in instanceof Arc) {
									Marking sourceMarking = place2MarkingAnnotation.get(((Arc) in).getSource());
//									if (marking.getMarking((Place) ((Arc) in).getSource()) < 1) {
//										inArcs.add(((Arc) in));
//									}
									if (marking.getMarking((Place) ((Arc) in).getSource()) > 0)  {
										
//										if (!list.contains(in)) {
											SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArcs();
											arcAnnotation.setObject(((Arc) in));
											arcAnnotation.setSourceMarking(sourceMarking);
											arcAnnotation.setTargetTransition(transitionAnnotations);
											arcAnnotation.setSelected(true);
											annotation.getObjectAnnotations().add(arcAnnotation);
//										}
										
									}
								}
							}
							
//							List<Object> list = isWarningArc(inArcs, marking);
//							for (Object o : list) {
//								if (o instanceof Transition) {
//									if (enabled(flatAccess, marking, (Transition) o)) {
//										continue;
//									}
//								} else if (o instanceof Arc) {
//									if (checkArcSelect(o)) {
//										continue;
//									}
//								} else if (o instanceof Place) {
//									if (marking.getMarking((Place) o) > 0) {
//										continue;
//									}
//								}
//								ObjectAnnotation objAnnotation = org.pnml.tools.epnk.annotations.netannotations.NetannotationsFactory.eINSTANCE.createObjectAnnotation();
//								objAnnotation.setObject(o);
//								annotation.getObjectAnnotations().add(objAnnotation);
//							}
//							
							
						}

						// Makes sure outgoing arcs are selected and attached to
						// the
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
									transitionAnnotations.getOutArcs().add(arcAnnotation);
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

						if (YAWLFunctions.getSplitType(transition).equals(TransitionType.SINGLE)) {
							for (Object out : flatAccess.getOut(transition)) {
								if (out instanceof Arc) {
									if (warningList.contains(out)) {
										SelectArcs arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArcs();
										arcAnnotation.setObject(((Arc) out));
										arcAnnotation.setSourceTransition(transitionAnnotations);
										arcAnnotation.setSelected(true);
										annotation.getObjectAnnotations().add(arcAnnotation);
									}
									
								}
							}
						}

						// Compares the total number of in arcs with the number
						// of arcs with a source place with at least one token
						if (YAWLFunctions.getSplitType(transition).equals(TransitionType.AND)) {
							int outCount = flatAccess.getOut(transition).size();
							int count = 0;
							for (Object out : flatAccess.getOut(transition)) {
								if (out instanceof Arc) {
									if (marking.getMarking((Place) ((Arc) out).getTarget()) > 0) {
										count++;
									}
								}
							}
							for (Object out : flatAccess.getIn(transition)) {
								if (out instanceof Arc) {
									if (count == outCount) {
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
				warningList = isWarningArc(inArcs, marking);
				for (Object o : warningList) {
					if (o instanceof Transition) {
						if (enabled(flatAccess, marking, (Transition) o)) {
							continue;
						}
					} else if (o instanceof Arc) {
						if (checkArcSelect(o)) {
							continue;
						}
					} else if (o instanceof Place) {
						if (marking.getMarking((Place) o) > 0) {
							continue;
						}
					}
					ObjectAnnotation objAnnotation = org.pnml.tools.epnk.annotations.netannotations.NetannotationsFactory.eINSTANCE.createObjectAnnotation();
					objAnnotation.setObject(o);
					annotation.getObjectAnnotations().add(objAnnotation);
				}
				warningList.clear();
			}
		}
		return annotation;
	}

	/**
	 * @author Nicki Nylin - s153769
	 */
	boolean fireTransition(Transition transition, Arc inArc, Collection<Arc> outArcs) {
		NetMarking marking1 = this.computeMarking();

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

	/**
	 * @author Nicki Nylin - s153769
	 */
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

		// Reduce token for all outgoing arcs on and and single:
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
	 * @author Rune Hou Thode - s150157
	 */
	public boolean enabled(FlatAccess flatNet, NetMarking marking, Transition transition) {
		TransitionType joinType = YAWLFunctions.getJoinType(transition);
		if (flatNet.getIn(transition).size() < 1 || flatNet.getOut(transition).size() < 1) {
			return false;
		}
		if (joinType.equals(TransitionType.AND) || joinType.equals(TransitionType.SINGLE)) {
			for (Object in : flatNet.getIn(transition)) {
				if (in instanceof Arc) {
					Arc inArc = (Arc) in;
					if (!YAWLFunctions.isResetArc(inArc)) {
						Object source = inArc.getSource();
						if (source instanceof PlaceNode) {
							source = flatNet.resolve((PlaceNode) source);
							if (source instanceof Place) {
								if (marking.getMarking((Place) source) < 1) {
									return false;
								}
							} else {
								// Source skal v�re en place
								return false;
							}
						} else {
							// Kan ikke bruge reset arcs
							return false;
						}
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
			// TODO hvis der kun er reset arcs ind
			return false;
		}
		// Hvis der ikke er nogle in-places med en token.
		return false;
	}

	private List<Object> isWarningArc(List<Object> inArcs, NetMarking marking) {
		List<org.pnml.tools.epnk.pnmlcoremodel.Object> added = inArcs;
		ArrayList<org.pnml.tools.epnk.pnmlcoremodel.Object> backwards = new ArrayList<org.pnml.tools.epnk.pnmlcoremodel.Object>();

		while(!added.isEmpty()){
			org.pnml.tools.epnk.pnmlcoremodel.Object obj = added.get(0);
			added.remove(obj);

			if(!backwards.contains(obj)){
				backwards.add(obj);
				if(obj instanceof Place){
					if(marking.getMarking((Place) obj) == 0){
						if(obj instanceof Node){
							added.addAll(flatAccess.getIn((Node) obj));
						}
					}
				}
				else if(obj instanceof Transition){
					if(!enabled.contains(obj)){
						if(obj instanceof Node){
							added.addAll(flatAccess.getIn((Node) obj));
						}
					}
				}
				else if(obj instanceof Arc){
					if(!YAWLFunctions.getType((Arc) obj).equals(ArcType.RESET)){
						added.add(((Arc) obj).getSource());
					}
				}
			}
		}
		for (org.pnml.tools.epnk.pnmlcoremodel.Object obj : backwards) {
			if(enabled.contains(obj)){
				added.add(obj);
			}
		}
		for (org.pnml.tools.epnk.pnmlcoremodel.Object obj : backwards) {
			if(obj instanceof Place){
				if(marking.getMarking((Place) obj)>0){
					added.add(obj);
				}
			}
		}

		ArrayList<org.pnml.tools.epnk.pnmlcoremodel.Object> forward = new ArrayList<org.pnml.tools.epnk.pnmlcoremodel.Object>();
		while(!added.isEmpty()){
			org.pnml.tools.epnk.pnmlcoremodel.Object obj = added.get(0);
			added.remove(obj);

			if(!forward.contains(obj)){
				forward.add((obj));
				if(obj instanceof Place){
					for (org.pnml.tools.epnk.pnmlcoremodel.Object object : ((Place) obj).getOut()) {
						if(backwards.contains(object)){
							added.add(object);
						}
					}
				}
				else if(obj instanceof Transition){
					for (org.pnml.tools.epnk.pnmlcoremodel.Object object : ((Transition) obj).getOut()) {
						if(backwards.contains(object)){
							added.add(object);
						}
					}
				}
				else if(obj instanceof Arc){
					if(backwards.contains(((Arc) obj))){
						if(!enabled.contains(((Arc) obj).getTarget())){
							added.add(((Arc) obj).getTarget());
						}
					}
				}
			}
		}
		return forward;
	}
	
	/**
	 * @author Sebastian Hoppe
	 */
	private boolean checkArcSelect(org.pnml.tools.epnk.pnmlcoremodel.Object object){
		if(object instanceof Arc){
			Arc obj = (Arc) object;
			if(obj.getSource() instanceof Transition){
				Transition transition = (Transition) obj.getSource();
				if(YAWLFunctions.getSplitType(transition).equals(TransitionType.OR) || YAWLFunctions.getSplitType(transition).equals(TransitionType.XOR)){
					if(enabled.contains(transition)){
						return true;
					}
				}
			}
			if(obj.getTarget() instanceof Transition){
				Transition transition = (Transition) obj.getTarget();
				if(YAWLFunctions.getJoinType(transition).equals(TransitionType.XOR)){
					if(enabled.contains(transition)){
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * @author Sebastian Hoppe
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
