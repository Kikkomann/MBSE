package dk.dtu.mbse.group7.yawl.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.pnml.tools.epnk.pnmlcoremodel.Node;

import dk.dtu.mbse.group7.yawl.Arc;

/**
 * @author Lukas Nyboe Bek - s153475
 */
public class NoDuplicateArcs extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		 EObject object = ctx.getTarget();
		 if (object instanceof Arc) {
			 Arc newArc = (Arc) object;
			 Node source = newArc.getSource();
			 Node target = newArc.getTarget();
			 for (org.pnml.tools.epnk.pnmlcoremodel.Arc outArc : source.getOut()) {
				 if (outArc instanceof Arc && outArc != newArc) {
					 Arc oldArc = (Arc) outArc;
					 if (oldArc.getTarget() == target && oldArc.getSource() == source) {
						 return ctx.createFailureStatus(new Object[] { newArc });
					 }
				 }
			 }
		 }
		return ctx.createSuccessStatus();
	}

}
