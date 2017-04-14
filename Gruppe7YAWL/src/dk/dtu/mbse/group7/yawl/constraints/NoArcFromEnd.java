package dk.dtu.mbse.group7.yawl.constraints;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;

import dk.dtu.mbse.group7.yawl.Place;
import dk.dtu.mbse.group7.yawl.YAWLNet;
import dk.dtu.mbse.group7.yawl.helpers.PlaceType;
import dk.dtu.mbse.group7.yawl.helpers.YAWLFunctions;

/**
 * 
 * @author Magnus & Nicki
 *
 */
public class NoArcFromEnd extends AbstractModelConstraint {

	public IStatus validate(IValidationContext ctx) {
		EObject object = ctx.getTarget();

		if (object instanceof YAWLNet) {
			EObject container = object.eContainer();
			if (container instanceof PetriNet) {
				Iterator<EObject> iterator = container.eAllContents();
				while (iterator.hasNext()) {
					EObject content = iterator.next();
					if (content instanceof Place) {
						Place place = (Place) content;
						if (YAWLFunctions.getType(place).equals(PlaceType.END)){
							if (place.getOut().size() != 0) {
								return ctx.createFailureStatus(new Object[] { container });
							}
						}
					}
				}
			}

		}
		// otherwise return a success status
		return ctx.createSuccessStatus();
	}
}
