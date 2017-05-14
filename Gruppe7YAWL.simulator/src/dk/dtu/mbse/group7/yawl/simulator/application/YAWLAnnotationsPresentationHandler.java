package dk.dtu.mbse.group7.yawl.simulator.application;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IPresentationHandler;
import org.pnml.tools.epnk.applications.ui.figures.PolylineOverlay;
import org.pnml.tools.epnk.applications.ui.figures.RectangleOverlay;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import dk.dtu.mbse.group7.yawl.Arc;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs;

public class YAWLAnnotationsPresentationHandler implements IPresentationHandler {

	/**
	 * @author Magnus Haakonsson - s153947
	 */
	@Override
	public IFigure handle(ObjectAnnotation annotation, AbstractGraphicalEditPart editPart) {
		if (annotation instanceof EnabledTransitions) {
			if (editPart instanceof GraphicalEditPart) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) editPart;
				Object modelObject = graphicalEditPart.resolveSemanticElement();
				if (modelObject instanceof TransitionNode) {
					RectangleOverlay overlay = new RectangleOverlay(graphicalEditPart);
					if (((EnabledTransitions) annotation).getEnabled()) {
						overlay.setForegroundColor(ColorConstants.blue);
						overlay.setBackgroundColor(ColorConstants.lightBlue);
					} else {
						overlay.setForegroundColor(ColorConstants.black);
						overlay.setBackgroundColor(ColorConstants.black);
					}
					return overlay;
				}
			}
		} else if (annotation instanceof SelectArcs) {
			SelectArcs selectArc = (SelectArcs) annotation;
			if (editPart instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart connectionEditPart = (ConnectionNodeEditPart) editPart;
				Object modelObject = connectionEditPart.resolveSemanticElement();
				if (modelObject instanceof Arc) {
					PolylineOverlay overlay = new PolylineOverlay(connectionEditPart);
					if (!selectArc.isSelected()) {
						overlay.setForegroundColor(ColorConstants.gray);
						overlay.setBackgroundColor(ColorConstants.gray);
					} else {
						overlay.setForegroundColor(ColorConstants.blue);
						overlay.setBackgroundColor(ColorConstants.blue);
					}
					if (selectArc.isWarning()) {
						overlay.setForegroundColor(ColorConstants.red);
						overlay.setBackgroundColor(ColorConstants.red);
					}
					return overlay;
				}
			}
		} 
//		else if (annotation instanceof ObjectAnnotation) {
//			GraphicalEditPart graphicalEditPart = (GraphicalEditPart) editPart;
//				RectangleOverlay overlay = new RectangleOverlay(graphicalEditPart);
//					overlay.setForegroundColor(ColorConstants.yellow);
//					overlay.setBackgroundColor(ColorConstants.yellow);
//				return overlay;
//		}
		return null;
	}

}
