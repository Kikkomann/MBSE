package graphics.figures;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.swt.SWT;
import org.pnml.tools.epnk.gmf.extensions.graphics.decorations.ArrowHeadDecoration;
import org.pnml.tools.epnk.gmf.extensions.graphics.decorations.DoubleArrowHeadDecoration;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.ArcFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Arc;
import org.pnml.tools.epnk.pnmlcoremodel.Node;

import yawl.helpers.ArcType;
import yawl.helpers.YAWLFunctions;

/**
 * The figure defining implementing the graphical appearance of arcs in the
 * Technical Net Type.
 * 
 * @author 
 * 
 */
public class Group7ArcFigure extends ArcFigure {

	private ArcType arcType;
	
	public Group7ArcFigure(Arc arc) {
		super(arc);
		arcType = YAWLFunctions.getType(arc);
		setGraphics();
	}

	@Override
	public void update() {
		ArcType oldArcType = arcType;
		arcType = YAWLFunctions.getType(arc);
		if (arcType != oldArcType) {
			setGraphics();
			// Notify attached target node of the change (which will initiate the update of the
			// corresponding graphical representation if needed).
			Node target = arc.getTarget();
			if (target instanceof InternalEObject) {
				target.eNotify(new ENotificationImpl((InternalEObject) target, Notification.NO_FEATURE_ID, null, null, null));
			}
		}
	}

	private void setGraphics() {
		if (arcType == ArcType.NORMAL) {
			this.setTargetDecoration(new ArrowHeadDecoration());
			this.setSourceDecoration(null);
			this.setLineStyle(SWT.LINE_SOLID);
		} else if (arcType == ArcType.RESET) {
			this.setTargetDecoration(new DoubleArrowHeadDecoration());
			this.setSourceDecoration(null);
			this.setLineStyle(SWT.LINE_DASH);
		}
	}

}
