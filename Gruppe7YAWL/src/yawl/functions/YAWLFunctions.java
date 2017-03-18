package yawl.functions;

import yawl.AType;
import yawl.Arc;
import yawl.ArcType;
import yawl.PType;
import yawl.Place;
import yawl.PlaceType;

public class YAWLFunctions {

	//TODO Undgå method overloading, så det er nemmere at bruge metoderne?
	
	public static PType getType(org.pnml.tools.epnk.pnmlcoremodel.Place place) {
		//TODO Find ud af om der skal være normal eller ej.
		if (place instanceof Place) {
			Place YAWLplace = (Place) place;
			PlaceType type = YAWLplace.getPlacetype();
			if (type != null) {
				return type.getText();
			} else {
				return PType.NORMAL;
			}
		} else {
			return PType.NORMAL;
		}
	}
	
	public static AType getType(org.pnml.tools.epnk.pnmlcoremodel.Arc arc) {
		if (arc instanceof Arc) {
			Arc YAWLArc = (Arc) arc;
			ArcType type = YAWLArc.getArctype();
			if (type != null) {
				return type.getText();
			} else {
				return AType.NORMAL;
			}
		}
		return AType.NORMAL;
	}
	
	public static boolean isResetArc(org.pnml.tools.epnk.pnmlcoremodel.Arc arc) {
		return getType(arc).equals(AType.RESET);
	}
	
	public static ControlFlowType getJoinType(org.pnml.tools.epnk.pnmlcoremodel.Transition transition) {
		//TODO Tutorial 6b: 4:00
		return null;
	}
	
	//TODO Find ud af, hvilke metoder der mangler
	
}
