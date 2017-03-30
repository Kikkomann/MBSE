package yawl.helpers;

import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.helpers.NetFunctions;

import yawl.AType;
import yawl.Arc;
import yawl.ArcType;
import yawl.JoinTransition;
import yawl.PType;
import yawl.Place;
import yawl.PlaceType;
import yawl.SplitTransition;
import yawl.TType;
import yawl.Transition;

public class YAWLFunctions {

	// TODO Undgå method overloading, så det er nemmere at bruge metoderne?

	public static yawl.helpers.PlaceType getType(org.pnml.tools.epnk.pnmlcoremodel.Place place) {
		if (place instanceof Place) {
			Place YAWLplace = (Place) place;
			PlaceType type = YAWLplace.getPlaceType();
			if (type != null) {
				if (type.getText().equals(PType.START)) {
					return yawl.helpers.PlaceType.START;
				} else if (type.getText().equals(PType.END)) {
					return yawl.helpers.PlaceType.END;
				}
			} else {
				return yawl.helpers.PlaceType.NORMAL;
			}
		}
		return yawl.helpers.PlaceType.NORMAL;
	}

	public static yawl.helpers.ArcType getType(org.pnml.tools.epnk.pnmlcoremodel.Arc arc) {
		if (arc instanceof Arc) {
			Arc YAWLArc = (Arc) arc;
			ArcType type = YAWLArc.getArcType();
			if (type != null) {
				if (type.getText().equals(AType.RESET)) {
					return yawl.helpers.ArcType.RESET;
				}
			} else {
				return yawl.helpers.ArcType.NORMAL;
			}
		}
		return yawl.helpers.ArcType.NORMAL;
	}

	public static boolean isResetArc(org.pnml.tools.epnk.pnmlcoremodel.Arc arc) {
		return getType(arc).equals(yawl.helpers.ArcType.RESET);
	}

	public static TransitionType getJoinType(org.pnml.tools.epnk.pnmlcoremodel.Transition transition) {
		FlatAccess flat = FlatAccess.getFlatAccess(NetFunctions.getPetriNet(transition));
		if (transition instanceof Transition) {
			Transition YAWLTransition = (Transition) transition;
			int count = 0;
			for (org.pnml.tools.epnk.pnmlcoremodel.Arc a : flat.getIn(YAWLTransition)) {
				if (a instanceof Arc) {
					Arc arc = (Arc) a;
					if (arc.getArcType() == null || arc.getArcType().equals(yawl.helpers.ArcType.NORMAL)) {
						count++;
					}
				}
			}
			if (count == 1) {
				return TransitionType.SINGLE;
			} else if (count > 1) {
				JoinTransition joinTrans = YAWLTransition.getJoinType();
				if (joinTrans != null) {
					if (joinTrans.getText().equals(TType.OR)) {
						return TransitionType.OR;
					} else if (joinTrans.getText().equals(TType.XOR)) {
						return TransitionType.XOR;
					} else {
						return TransitionType.AND;
					}
				}
				return TransitionType.AND;
			}
		}
		return TransitionType.SINGLE;
	}

	public static TransitionType getSplitType(org.pnml.tools.epnk.pnmlcoremodel.Transition transition) {
		FlatAccess flat = FlatAccess.getFlatAccess(NetFunctions.getPetriNet(transition));
		if (transition instanceof Transition) {
			Transition YAWLTransition = (Transition) transition;
			int count = 0;
			for (org.pnml.tools.epnk.pnmlcoremodel.Arc a : flat.getOut(YAWLTransition)) {
				if (a instanceof Arc) {
					Arc arc = (Arc) a;
					if (arc.getArcType() == null || arc.getArcType().equals(yawl.helpers.ArcType.NORMAL)) {
						count++;
					}
				}
			}
			if (count == 1) {
				return TransitionType.SINGLE;
			} else if (count > 1) {
				SplitTransition splitTrans = YAWLTransition.getSplitType();
				if (splitTrans != null) {
					if (splitTrans.getText().equals(TType.OR)) {
						return TransitionType.OR;
					} else if (splitTrans.getText().equals(TType.XOR)) {
						return TransitionType.XOR;
					} else {
						return TransitionType.AND;
					}
				}
				return TransitionType.AND;
			}
		}
		return TransitionType.SINGLE;
	}

	// TODO Find ud af, hvilke metoder der mangler

}
