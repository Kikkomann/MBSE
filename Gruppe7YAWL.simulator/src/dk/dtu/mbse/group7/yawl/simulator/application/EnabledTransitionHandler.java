package dk.dtu.mbse.group7.yawl.simulator.application;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.draw2d.MouseEvent;
import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetAnnotations;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IActionHandler;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import dk.dtu.mbse.group7.yawl.Arc;
import dk.dtu.mbse.group7.yawl.Transition;
import dk.dtu.mbse.group7.yawl.simulator.marking.NetMarking;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs;

/**
 * Action handler dealing with mouse clicks on EnableTransition annotations.
 * It will fire the transition, if it is enabled.
 */
public class EnabledTransitionHandler implements IActionHandler {

	private YAWLSimulator application;

	public EnabledTransitionHandler(YAWLSimulator application) {
		super();
		this.application = application;	
	}

	/**
	 * @author Magnus Haakonsson - s153947
	 */
	@Override
	public boolean mouseDoubleClicked(MouseEvent arg0, ObjectAnnotation annotation) {
		NetAnnotations netAnnotations = application.getNetAnnotations();
		NetAnnotation current = netAnnotations.getCurrent();
		
		FlatAccess flatNet = application.getFlatAccess();
		if (current.getObjectAnnotations().contains(annotation)) {
			Object object = annotation.getObject();
			if (object instanceof TransitionNode) {
				object = flatNet.resolve((TransitionNode) object);
			}
			if (object instanceof Transition && annotation instanceof EnabledTransitions) {
				Transition transition = (Transition) object;
				NetMarking marking1 = application.computeMarking();
				if (application.enabled(flatNet, marking1, transition)) {
					NetMarking marking2 = application.fireTransition(flatNet, marking1, (Arc) selectedInArc((EnabledTransitions) annotation), transition, selectedOutArcs((EnabledTransitions) annotation));
					NetAnnotation netAnnotation = application.computeAnnotation(marking2);
					netAnnotation.setNet(application.getPetrinet());
					
					application.deleteNetAnnotationAfterCurrent();
					application.addNetAnnotationAsCurrent(netAnnotation);
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean mousePressed(MouseEvent arg0, ObjectAnnotation annotation) {
		return false; 
	}

	@Override
	public boolean mouseReleased(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}
	
	/**
	 * @author Sebastian Hoppe - s154306
	 */
	private Arc selectedInArc(EnabledTransitions enabledTransitions) {
		EnabledTransitions resolved = enabledTransitions.getResolved();
		if (resolved == null) {
			resolved = enabledTransitions;
		}
		for (SelectArcs selectArc : resolved.getInArc()) {
			if (selectArc.isSelected()) {
				Object result = selectArc.getObject();
				if (result instanceof Arc) {
					return (Arc) result;
				}
			}
		}
		return null;
	}
	
	/**
	 * @author Sebastian Hoppe - s154306
	 */
	private Collection<Arc> selectedOutArcs(EnabledTransitions enabledTransitions) {
		EnabledTransitions resolved = enabledTransitions.getResolved();
		if (resolved == null) {
			resolved = enabledTransitions;
		}
		Collection<Arc> result = new ArrayList<Arc>();
		for (SelectArcs selectArc : resolved.getOutArcs()) {
			if (selectArc.isSelected()) {
				Object arc = selectArc.getObject();
				if (arc instanceof Arc) {
					result.add((Arc) arc);
				}
			}
		}
		return result;
	}

}
