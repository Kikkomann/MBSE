package graphics.factory;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.pnml.tools.epnk.gmf.extensions.graphics.GraphicalExtension;
import org.pnml.tools.epnk.gmf.extensions.graphics.IArcFigure;
import org.pnml.tools.epnk.gmf.extensions.graphics.IUpdateableFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Arc;
import org.pnml.tools.epnk.pnmlcoremodel.Place;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;

import dk.dtu.mbse.group7.yawl.YawlPackage;
import graphics.figures.Group7ArcFigure;
import graphics.figures.Group7PlaceFigure;
import graphics.figures.Group7TransitionFigure;

/**
 * The graphical extension the the Technical Net extension. This is
 * the class plugged in to the ePNK  (see plugin.xml).
 * 
 * @author ekki@dtu.dk
 *
 */
public class YAWLGraphics extends GraphicalExtension {

	
	public YAWLGraphics() {
		super();
	}

	@Override
	public List<EClass> getExtendedNetTypes() {
		ArrayList<EClass> results = new ArrayList<EClass>();
		results.add(YawlPackage.eINSTANCE.getYAWLNet());
		return results;
	}

	@Override
	public List<EClass> getExtendedNetObjects(EClass netType) {
		ArrayList<EClass> results = new ArrayList<EClass>();
		if (netType.equals(YawlPackage.eINSTANCE.getYAWLNet())) {
			results.add(YawlPackage.eINSTANCE.getArc());
			results.add(YawlPackage.eINSTANCE.getPlace());
			results.add(YawlPackage.eINSTANCE.getTransition());
		}
		return results;
	}

	@Override
	public IArcFigure createArcFigure(Arc arc) {
		if (arc instanceof dk.dtu.mbse.group7.yawl.Arc) {
			return new Group7ArcFigure(arc);
		}
		return null;
	}

	@Override
	public IUpdateableFigure createPlaceFigure(Place place) {
		if (place instanceof dk.dtu.mbse.group7.yawl.Place) {
			return new Group7PlaceFigure(place);
		}
		return null;
	}
	

	@Override
	public IUpdateableFigure createTransitionFigure(Transition transition) {
		if (transition instanceof dk.dtu.mbse.group7.yawl.Transition) {
			return new Group7TransitionFigure(transition);
		}
		return null;
	}
}
