package dk.dtu.mbse.group7.yawl.helpers;

import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.helpers.NetFunctions;

import dk.dtu.mbse.group7.yawl.AType;
import dk.dtu.mbse.group7.yawl.Arc;
import dk.dtu.mbse.group7.yawl.ArcType;
import dk.dtu.mbse.group7.yawl.JoinTransition;
import dk.dtu.mbse.group7.yawl.PType;
import dk.dtu.mbse.group7.yawl.Place;
import dk.dtu.mbse.group7.yawl.PlaceType;
import dk.dtu.mbse.group7.yawl.SplitTransition;
import dk.dtu.mbse.group7.yawl.TType;
import dk.dtu.mbse.group7.yawl.Transition;

/**
 * @author Rune Hou Thode - s150157
 */
public class YAWLFunctions {

	public static dk.dtu.mbse.group7.yawl.helpers.PlaceType getType(org.pnml.tools.epnk.pnmlcoremodel.Place place) {
		if (place instanceof Place) {
			Place YAWLplace = (Place) place;
			PlaceType type = YAWLplace.getPlaceType();
			if (type != null) {
				if (type.getText().equals(PType.START)) {
					return dk.dtu.mbse.group7.yawl.helpers.PlaceType.START;
				} else if (type.getText().equals(PType.END)) {
					return dk.dtu.mbse.group7.yawl.helpers.PlaceType.END;
				}
			} else {
				return dk.dtu.mbse.group7.yawl.helpers.PlaceType.NORMAL;
			}
		}
		return dk.dtu.mbse.group7.yawl.helpers.PlaceType.NORMAL;
	}

	public static dk.dtu.mbse.group7.yawl.helpers.ArcType getType(org.pnml.tools.epnk.pnmlcoremodel.Arc arc) {
		if (arc instanceof Arc) {
			Arc YAWLArc = (Arc) arc;
			ArcType type = YAWLArc.getArcType();
			if (type != null) {
				if (type.getText().equals(AType.RESET)) {
					return dk.dtu.mbse.group7.yawl.helpers.ArcType.RESET;
				}
			} else {
				return dk.dtu.mbse.group7.yawl.helpers.ArcType.NORMAL;
			}
		}
		return dk.dtu.mbse.group7.yawl.helpers.ArcType.NORMAL;
	}

	public static boolean isResetArc(org.pnml.tools.epnk.pnmlcoremodel.Arc arc) {
		return getType(arc).equals(dk.dtu.mbse.group7.yawl.helpers.ArcType.RESET);
	}

	public static TransitionType getJoinType(org.pnml.tools.epnk.pnmlcoremodel.Transition transition) {
		FlatAccess flat = FlatAccess.getFlatAccess(NetFunctions.getPetriNet(transition));
		if (transition instanceof Transition) {
			Transition YAWLTransition = (Transition) transition;
			int count = 0;
			for (org.pnml.tools.epnk.pnmlcoremodel.Arc a : flat.getIn(YAWLTransition)) {
				if (a instanceof Arc) {
					Arc arc = (Arc) a;
					if (arc.getArcType() == null
							|| arc.getArcType().equals(dk.dtu.mbse.group7.yawl.helpers.ArcType.NORMAL)) {
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
					if (arc.getArcType() == null
							|| arc.getArcType().equals(dk.dtu.mbse.group7.yawl.helpers.ArcType.NORMAL)) {
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
}
