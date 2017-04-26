package graphics.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.TransitionFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;

import dk.dtu.mbse.group7.yawl.helpers.TransitionType;
import dk.dtu.mbse.group7.yawl.helpers.YAWLFunctions;


/**
 * @author Lukas Nyboe Bek - s153475
 */
public class Group7TransitionFigure extends TransitionFigure {

	private TransitionType joinType;
	private TransitionType splitType;

	public Group7TransitionFigure(Transition transition) {
		super(transition);
		joinType = YAWLFunctions.getJoinType(transition);
		splitType = YAWLFunctions.getSplitType(transition);
	}

	@Override
	public void update() {
		TransitionType oldJoinType = joinType;
		TransitionType oldSplitType = splitType;
		joinType = YAWLFunctions.getJoinType(transition);
		splitType = YAWLFunctions.getSplitType(transition);
		if (oldJoinType != joinType || oldSplitType != splitType) {
			this.repaint();
		}
	}

	@Override
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);

		Rectangle rect = this.getClientArea();
		int thirds = rect.width / 3;
		int halves = rect.height / 2;

		int x1, x2, x3, x4, y1, y2, y3, y4;

		if (joinType.equals(TransitionType.AND)) {
			// in order to make sure that the changes made to the drawing style
			// have an effect within the scope of this method only, the state
			// of the graphics object is pushed here. Note that the state needs
			// to be popped from the stack again before finishing this method
			// (see below).
			graphics.pushState();
			graphics.setLineWidth(1);

			x1 = rect.x;
			y1 = rect.y + rect.height;
			x2 = rect.x + thirds;
			y2 = rect.y + halves;
			x3 = x1;
			y3 = rect.y;
			int points[] = { x1, y1, x2, y2, x3, y3 };
			// graphics.fillPolygon(points);
			graphics.drawLine((rect.x + thirds), (rect.y + rect.height), (rect.x + thirds), rect.y);
			graphics.drawPolygon(points);

			graphics.popState();
		} else if (joinType.equals(TransitionType.OR)) {
			graphics.pushState();
			graphics.setLineWidth(1);

			x1 = rect.x + thirds / 2;
			y1 = rect.y + rect.height;
			x2 = rect.x + thirds;
			y2 = rect.y + halves;
			x3 = x1;
			y3 = rect.y;
			x4 = rect.x;
			y4 = y2;
			int points[] = { x1, y1, x2, y2, x3, y3, x4, y4 };
			// graphics.fillPolygon(points);
			graphics.drawLine((rect.x + thirds), (rect.y + rect.height), (rect.x + thirds), rect.y);
			graphics.drawPolygon(points);

			graphics.popState();
		} else if (joinType.equals(TransitionType.XOR)) {
			graphics.pushState();
			graphics.setLineWidth(1);

			x1 = rect.x + thirds;
			y1 = rect.y + rect.height;
			x2 = x1;
			y2 = rect.y;
			x3 = rect.x;
			y3 = rect.y + halves;
			int points[] = { x1, y1, x2, y2, x3, y3 };
			graphics.fillPolygon(points);
			graphics.drawPolygon(points);

			graphics.popState();
		}

		if (splitType.equals(TransitionType.AND)) {
			// in order to make sure that the changes made to the drawing style
			// have an effect within the scope of this method only, the state
			// of the graphics object is pushed here. Note that the state needs
			// to be popped from the stack again before finishing this method
			// (see below).
			graphics.pushState();
			graphics.setLineWidth(1);

			x1 = rect.x + rect.width;
			y1 = rect.y + rect.height;
			x2 = x1;
			y2 = rect.y;
			x3 = x1 - thirds;
			y3 = rect.y + halves;
			int points[] = { x1, y1, x2, y2, x3, y3 };
			// graphics.fillPolygon(points);
			graphics.drawLine((rect.x + rect.width - thirds), (rect.y + rect.height), (rect.x + rect.width - thirds),
					rect.y);
			graphics.drawPolygon(points);

			graphics.popState();
		} else if (splitType.equals(TransitionType.OR)) {
			graphics.pushState();
			graphics.setLineWidth(1);

			x1 = rect.x + rect.width - thirds / 2;
			y1 = rect.y + rect.height;
			x2 = rect.x + rect.width;
			y2 = rect.y + halves;
			x3 = x1;
			y3 = rect.y;
			x4 = rect.x + rect.width - thirds;
			y4 = y2;
			int points[] = { x1, y1, x2, y2, x3, y3, x4, y4 };
			// graphics.fillPolygon(points);
			graphics.drawLine((rect.x + rect.width - thirds), (rect.y + rect.height), (rect.x + rect.width - thirds),
					rect.y);
			graphics.drawPolygon(points);

			graphics.popState();
		} else if (splitType.equals(TransitionType.XOR)) {
			graphics.pushState();
			graphics.setLineWidth(1);

			x1 = rect.x + rect.width - thirds;
			y1 = rect.y + rect.height;
			x2 = rect.x + rect.width;
			y2 = rect.y + halves;
			x3 = x1;
			y3 = rect.y;
			int points[] = { x1, y1, x2, y2, x3, y3 };
			graphics.fillPolygon(points);
			graphics.drawPolygon(points);

			graphics.popState();
		}
	}
}
