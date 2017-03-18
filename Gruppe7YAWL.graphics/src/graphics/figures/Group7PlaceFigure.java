package graphics.figures;

import org.pnml.tools.epnk.gmf.extensions.graphics.figures.PlaceFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Place;

import yawl.PType;
import yawl.functions.YAWLFunctions;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.TransitionFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;

public class Group7PlaceFigure extends PlaceFigure {

	private PType placeType;

	public Group7PlaceFigure(Place place) {
		super(place);
		placeType = YAWLFunctions.getType(place);
	}

	/**
	 * This method is called whenever some attribute of the transition which
	 * might influence the graphical appearance of the transition changes.
	 */
	@Override
	public void update() {
		PType oldType = placeType;
		placeType = YAWLFunctions.getType(place);
		if (oldType != placeType) {
			this.repaint();
		}
	}

	@Override
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);

		Rectangle rect = this.getClientArea();
		int d1 = rect.width / 3;
		int d2 = rect.height / 3;

		if (placeType.equals(PType.START)) {
			// in order to make sure that the changes made to the drawing style
			// have an effect within the scope of this method only, the state
			// of the graphics object is pushed here. Note that the state needs
			// to be popped from the stack again before finishing this method
			// (see below).
			graphics.pushState();
			// F�r default gr�n fra OS, s� vi ikke beh�ver dispose den senere.
			// (n�r man arbejder med GUI i java, skal man selv dispose og kan
			// ikke altid regne med garbage col.)
			Display display = Display.getCurrent();
			Color green = display.getSystemColor(SWT.COLOR_GREEN);
			graphics.setBackgroundColor(green);
			graphics.setLineWidth(1);
			int x1 = rect.x + d1 + 1;
			int y1 = rect.y + d2;
			int x2 = rect.x + 2 * d1 + 2;
			int y2 = rect.y + rect.height / 2;
			int x3 = x1;
			int y3 = rect.y + 2 * d2;
			graphics.fillPolygon(new int[] {x1,y1, x2,y2, x3,y3});
			graphics.drawPolygon(new int[] {x1,y1, x2,y2, x3,y3});
			// Make sure that graphics.pushState(); and graphics.popState();
			// always
			// are called in a balanced way! If push and pop operations are not
			// properly paired, this will result in runtime exceptions and the
			// editor not working properly!
			graphics.popState();
		} else if (placeType.equals(PType.END)) {
			graphics.pushState();

			Display display = Display.getCurrent();
			Color red = display.getSystemColor(SWT.COLOR_RED);
			graphics.setBackgroundColor(red);
			graphics.setLineWidth(1);
			int x1 = rect.x + d1;
			int y1 = rect.y + d2;
//			int x2 = rect.x + 2 * d1;
//			int y2 = y1;
//			int x3 = x2;
//			int y3 = rect.height - d2;
//			int x4 = x1;
//			int y4 = y3;
			graphics.fillRectangle(x1, y1, (d1), d2);
			graphics.drawRectangle(x1, y1, (d1), d2);
			
			graphics.popState();
		}
	}

}
