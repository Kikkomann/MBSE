package dk.dtu.mbse.group7.yawl.constraints;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.helpers.NetFunctions;

import dk.dtu.mbse.group7.yawl.Place;
import dk.dtu.mbse.group7.yawl.helpers.PlaceType;
import dk.dtu.mbse.group7.yawl.helpers.YAWLFunctions;

/**
 * @author Nicki Nylin - s153769 
 * @author Magnus Haakonsson - s153947
 */
public class NoArcToStart extends AbstractModelConstraint {
	public IStatus validate(IValidationContext ctx) {
		EObject object = ctx.getTarget();
		if (object instanceof Place) {
			Place place = (Place) object;
			PlaceType pType = YAWLFunctions.getType(place);
			if (pType.equals(PlaceType.START)) {
				FlatAccess flat = FlatAccess.getFlatAccess(NetFunctions.getPetriNet(place));
				if (flat.getIn(place).size() > 0) {
					return ctx.createFailureStatus(new Object[] { place });
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
