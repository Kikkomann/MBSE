package yawl.simulator.application;

import org.eclipse.draw2d.MouseEvent;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IActionHandler;

import yawl.Transition;
import yawl.helpers.TransitionType;
import yawl.helpers.YAWLFunctions;
import yawl.yawlannotations.EnabledTransitions;
import yawl.yawlannotations.Marking;
import yawl.yawlannotations.SelectArcs;

public class SelectArcHandler implements IActionHandler {

	private YAWLSimulator application;

	public SelectArcHandler(YAWLSimulator application) {
		super();
		this.application = application;
	}

	@Override
	public boolean mouseDoubleClicked(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}

	@Override
	public boolean mousePressed(MouseEvent arg0, ObjectAnnotation annotation) {
		if (annotation instanceof SelectArcs) {
			SelectArcs selectArcs = (SelectArcs) annotation;
			EnabledTransitions targetAction = selectArcs.getTargetTransition();
			EnabledTransitions sourceAction = selectArcs.getSourceTransition();
			Marking sourceMarking = selectArcs.getSourceMarking();

			if (targetAction != null) {
				if (!selectArcs.isSelected() && sourceMarking != null && sourceMarking.getValue() > 0) {
					Transition transition = targetAction.getTransition();
					if (YAWLFunctions.getJoinType(transition).equals(TransitionType.XOR)) {
						for (SelectArcs s_arc : targetAction.getInArc()) {
							s_arc.setSelected(false);
						}
						selectArcs.setSelected(true);
						application.update();
						return true;
					}
				}
			} else if (sourceAction != null) {
				Transition transition = sourceAction.getTransition();
				TransitionType tType = YAWLFunctions.getSplitType(transition);
				if (tType.equals(TransitionType.XOR)) {
					for (SelectArcs s_arc : sourceAction.getOutArcs()) {
						s_arc.setSelected(false);
					}
					selectArcs.setSelected(true);
					application.update();
					return true;
				} else if (tType.equals(TransitionType.OR)) {
					selectArcs.setSelected(!selectArcs.isSelected());
					boolean notEmpty = false;
					for (SelectArcs s_arc : sourceAction.getOutArcs()) {
						if (s_arc.isSelected()) {
							notEmpty = true;
							break;
						}
					}
					if (!notEmpty) {
						for (SelectArcs s_arc : sourceAction.getOutArcs()) {
							if (s_arc != selectArcs) {
								s_arc.setSelected(true);
								break;
							}
						}
					}
					application.update();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean mouseReleased(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}
}
