package dk.dtu.mbse.group7.yawl.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.pnml.tools.epnk.pnmlcoremodel.Node;

import dk.dtu.mbse.group7.yawl.Arc;

public class NoDuplicateArcs extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		 EObject object = ctx.getTarget();
		 if (object instanceof Arc) {
			 Arc arc = (Arc) object;
			 Node source = arc.getSource();
			 Node target = arc.getTarget();
			 for (org.pnml.tools.epnk.pnmlcoremodel.Arc outArc : source.getOut()) {
				 if (outArc.getTarget() == target && outArc.getSource() == source) {
					 return ctx.createFailureStatus(new Object[] { arc });
				 }
			 }
		 }
		return ctx.createSuccessStatus();
	}

}
