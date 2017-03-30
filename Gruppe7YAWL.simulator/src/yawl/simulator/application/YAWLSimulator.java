package yawl.simulator.application;

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
import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition;
import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsFactory;

import dk.dtu.compute.mbse.yawl.functions.YAWLFunctions;
import yawl.Place;
import yawl.Transition;
import yawl.helpers.*;
import yawl.simulator.marking.NetMarking;
import yawl.yawlannotations.Marking;


/**
 * A first simulator application for YAWL nets. 
 * 
 * TODO Note that this simulator does not yet take split and join types
 * into account; neither does it take reset arcs into account. Moreover,
 * the user can not select arcs yet. This needs to be extended!
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
		// manager.addActionHandler(new InvolvedArcHandler(this));
		// manager.addPresentationHandler(new YAWLAnnotationsPresentationHandler());
		
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

	private NetMarking computeInitialMarking() {
		NetMarking marking = new NetMarking();
		for (org.pnml.tools.epnk.pnmlcoremodel.Place place : getFlatAccess().getPlaces()) {
			if (place instanceof Place && YAWLFunctions.getType(place) == PlaceType.START) {
				marking.setMarking((Place) place, 1);
			}
		}
		return marking;
	}
	
	private NetMarking computeMarking() {
		NetMarking marking = new NetMarking();
		for (ObjectAnnotation annotation: this.getNetAnnotations().getCurrent().getObjectAnnotations()) {
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
	
	private NetAnnotation computeAnnotation(NetMarking marking) {
		NetAnnotation annotation = NetannotationsFactory.eINSTANCE.createNetAnnotation();
		annotation.setNet(getPetrinet());
		
		for (Object object: getFlatAccess().getTransitions()) {
			if (object instanceof Transition) {
				Transition transition = (Transition) object;
				if (isEnabled(marking, transition)) {
					EnabledTransition enabledTransition = TechsimannotationsFactory.eINSTANCE.createEnabledTransition();
					enabledTransition.setObject(transition);
					annotation.getObjectAnnotations().add(enabledTransition);
					enabledTransition.setEnabled(true);
					
					for (RefTransition refTransition: getFlatAccess().getRefTransitions(transition)) {
						EnabledTransition enabledTransition2 = TechsimannotationsFactory.eINSTANCE.createEnabledTransition();
						enabledTransition2.setObject(refTransition);
						enabledTransition2.setResolve(enabledTransition);
						enabledTransition2.setEnabled(enabledTransition.isEnabled());
						annotation.getObjectAnnotations().add(enabledTransition2);
					}
				}
			}
		}
		
		for (Place place: marking.getSupport()) {
			
			// TODO create and add the Marking annotations for each place (condition) in the
			//      support of the marking

				// Marking mAnnotation = TechsimannotationsFactory.eINSTANCE.createMarking();
				//  mAnnotation.setObject(...);
				//  mAnnotation.setValue(.annotation.eAdapters().);
				// annotation.getObjectAnnotations().add(mAnnotation);
				
			// TODO also make sure that all reference places referring to the condition
			//      get the respective annotation

		}
		return annotation;
	}
	
	boolean fireTransition(Transition transition) {
		NetMarking marking1 = this.computeMarking();

		if (this.isEnabled(marking1, transition)) {
			NetMarking marking2 = this.fireTransition(marking1, transition);
			NetAnnotation netAnnotation = this.computeAnnotation(marking2);
			netAnnotation.setNet(this.getPetrinet());

			this.deleteNetAnnotationAfterCurrent();
			this.addNetAnnotationAsCurrent(netAnnotation);
			return true;
		}
		return false;
	}

	private NetMarking fireTransition(NetMarking marking1, Transition transition) {
		NetMarking marking2 = new NetMarking(marking1);
		
		// consume tokens from preset
		NetMarking consumes = consumes(transition);
		marking2.subtract(consumes);
				
		// reset places on page connected to reset arc
        // TODO
		
		// produce tokens on postset
		NetMarking produces = produces(transition);
		marking2.add(produces);
		
		return marking2;
	}

	private boolean isEnabled(NetMarking marking, Transition transition) {
		NetMarking consumes = consumes(transition);
		return marking.isGreaterOrEqual(consumes);
	}
	
	private NetMarking consumes(Transition transition) {
		NetMarking consumes = new NetMarking();
		
		for (Arc arc: getFlatAccess().getIn(transition)) {
			
			if (arc instanceof Arc && YAWLFunctions.getType(arc) == ArcType.NORMAL ) {
				
				// TODO compute for each source place the tokens needed (consumed) for firing the transition

			}
		}
		
		return consumes;
	}
	
	private NetMarking produces(Transition transition) {
		NetMarking produces = new NetMarking();
		for (org.pnml.tools.epnk.pnmlcoremodel.Arc arc: getFlatAccess().getOut(transition)) {
			
			// TODO compute for each traget place the tokens produced when firing the transition

		}
		return produces;
	}

	/* (non-Javadoc)
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