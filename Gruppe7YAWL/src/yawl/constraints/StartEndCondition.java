package yawl.constraints;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;

import yawl.Place;
import yawl.YAWLNet;
import yawl.helpers.PlaceType;
import yawl.helpers.YAWLFunctions;

/**
 * This is a constraint saying that a YAWL net should have exactly one start
 * place and one end place.
 *
 * @generated NOT
 */
public class StartEndCondition extends AbstractModelConstraint {

	public IStatus validate(IValidationContext ctx) {
		EObject object = ctx.getTarget();

		if (object instanceof YAWLNet) {
			EObject container = object.eContainer();
			if (container instanceof PetriNet) {
				int startCount = 0;
				int endCount = 0;
				Iterator<EObject> iterator = container.eAllContents();
				while (iterator.hasNext()) {
					EObject content = iterator.next();
					if (content instanceof Place) {
						Place place = (Place) content;
						PlaceType type = YAWLFunctions.getType(place);
						if (type.equals(PlaceType.START)) {
							startCount++;
							if (startCount > 1) {
								break;
							}
						} else if (type.equals(PlaceType.END)) {
							endCount++;
							if (endCount > 1) {
								break;
							}
						}
					}
				}
				if (startCount != 1 || endCount != 1) {
					// if there is not exactly one start place and exactly one
					// end place, return a failure status.
					return ctx.createFailureStatus(new Object[] { container });
				}
			}
		}
		// otherwise return a success status
		return ctx.createSuccessStatus();
	}
}
