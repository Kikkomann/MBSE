/**
 */
package dk.dtu.mbse.group7.yawl.yawlannotations.util;

import dk.dtu.mbse.group7.yawl.yawlannotations.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.pnml.tools.epnk.annotations.netannotations.Annotation;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.TextualAnnotation;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see dk.dtu.mbse.group7.yawl.yawlannotations.YawlannotationsPackage
 * @generated
 */
public class YawlannotationsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static YawlannotationsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YawlannotationsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = YawlannotationsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected YawlannotationsSwitch modelSwitch =
		new YawlannotationsSwitch() {
			public Object caseMarking(Marking object) {
				return createMarkingAdapter();
			}
			public Object caseEnabledTransitions(EnabledTransitions object) {
				return createEnabledTransitionsAdapter();
			}
			public Object caseSelectArcs(SelectArcs object) {
				return createSelectArcsAdapter();
			}
			public Object caseAnnotation(Annotation object) {
				return createAnnotationAdapter();
			}
			public Object caseObjectAnnotation(ObjectAnnotation object) {
				return createObjectAnnotationAdapter();
			}
			public Object caseTextualAnnotation(TextualAnnotation object) {
				return createTextualAnnotationAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link dk.dtu.mbse.group7.yawl.yawlannotations.Marking <em>Marking</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.dtu.mbse.group7.yawl.yawlannotations.Marking
	 * @generated
	 */
	public Adapter createMarkingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.dtu.mbse.group7.yawl.yawlannotations.EnabledTransitions <em>Enabled Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.dtu.mbse.group7.yawl.yawlannotations.EnabledTransitions
	 * @generated
	 */
	public Adapter createEnabledTransitionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.dtu.mbse.group7.yawl.yawlannotations.SelectArcs <em>Select Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.dtu.mbse.group7.yawl.yawlannotations.SelectArcs
	 * @generated
	 */
	public Adapter createSelectArcsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.pnml.tools.epnk.annotations.netannotations.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.pnml.tools.epnk.annotations.netannotations.Annotation
	 * @generated
	 */
	public Adapter createAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation <em>Object Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation
	 * @generated
	 */
	public Adapter createObjectAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.pnml.tools.epnk.annotations.netannotations.TextualAnnotation <em>Textual Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.pnml.tools.epnk.annotations.netannotations.TextualAnnotation
	 * @generated
	 */
	public Adapter createTextualAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //YawlannotationsAdapterFactory
