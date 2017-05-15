package dk.dtu.mbse.group7.yawl.constraints;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.helpers.NetFunctions;

import dk.dtu.mbse.group7.yawl.Transition;

/**
 * @author Sebastian Hoppe
 */

public class NoTransitionWithoutArcs extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject object = ctx.getTarget();
		if (object instanceof Transition) {
			Transition place = (Transition) object;
				FlatAccess flat = FlatAccess.getFlatAccess(NetFunctions.getPetriNet(place));
				if (flat.getIn(place).size() < 1 || flat.getOut(place).size() < 1) {
					return ctx.createFailureStatus(new Object[] { place });
			}
		}
		return ctx.createSuccessStatus();
	}
}
