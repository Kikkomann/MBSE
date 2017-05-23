package dk.dtu.mbse.group7.yawl.simulator.application;

import org.eclipse.draw2d.MouseEvent;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IActionHandler;

import dk.dtu.mbse.group7.yawl.Transition;
import dk.dtu.mbse.group7.yawl.helpers.TransitionType;
import dk.dtu.mbse.group7.yawl.helpers.YAWLFunctions;
import dk.dtu.mbse.group7.yawl.simulator.exceptions.WrongTypeException;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.Marking;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs;


/**
 * @author Lukas Nyboe Bek - s153475
 */

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
			//One of these should be true (Der er enten en sourceTrans eller targetTrans)
			EnabledTransitions targetTransition = selectArcs.getTargetTransition();
			EnabledTransitions sourceTransition = selectArcs.getSourceTransition();
			Marking sourceMarking = selectArcs.getSourceMarking();

			if (targetTransition != null) {
				try {
					if (!selectArcs.isSelected() && sourceMarking != null  && sourceMarking.getValue() > 0) {
						Transition transition = targetTransition.getTransition();
						if (YAWLFunctions.getJoinType(transition).equals(TransitionType.XOR)) {
							for (SelectArcs s_arc : targetTransition.getInArc()) {
								s_arc.setSelected(false);
							}
							selectArcs.setSelected(true);
							application.update();
							return true;
						}
					}
				} catch (WrongTypeException e) {
					e.printStackTrace();
				}
			} else if (sourceTransition != null) {
				try {
					Transition transition = sourceTransition.getTransition();
					TransitionType tType = YAWLFunctions.getSplitType(transition);
					if (tType.equals(TransitionType.XOR)) {
						for (SelectArcs s_arc : sourceTransition.getOutArcs()) {
							s_arc.setSelected(false);
						}
						selectArcs.setSelected(true);
						application.update();
						return true;
					} else if (tType.equals(TransitionType.OR)) {
						selectArcs.setSelected(!selectArcs.isSelected());
						boolean notEmpty = false;
						for (SelectArcs s_arc : sourceTransition.getOutArcs()) {
							if (s_arc.isSelected()) {
								notEmpty = true;
								break;
							}
						}
						if (!notEmpty) {
							for (SelectArcs s_arc : sourceTransition.getOutArcs()) {
								if (s_arc != selectArcs) {
									s_arc.setSelected(true);
									break;
								}
							}
						}
						application.update();
						return true;
					}
				} catch (WrongTypeException e) {
					e.printStackTrace();
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
