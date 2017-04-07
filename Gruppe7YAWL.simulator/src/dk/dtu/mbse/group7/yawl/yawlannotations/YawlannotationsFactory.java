/**
 */
package dk.dtu.mbse.group7.yawl.yawlannotations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dk.dtu.mbse.group7.yawl.yawlannotations.YawlannotationsPackage
 * @generated
 */
public interface YawlannotationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	YawlannotationsFactory eINSTANCE = dk.dtu.mbse.group7.yawl.yawlannotations.impl.YawlannotationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Marking</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Marking</em>'.
	 * @generated
	 */
	Marking createMarking();

	/**
	 * Returns a new object of class '<em>Enabled Transitions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enabled Transitions</em>'.
	 * @generated
	 */
	EnabledTransitions createEnabledTransitions();

	/**
	 * Returns a new object of class '<em>Select Arcs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Arcs</em>'.
	 * @generated
	 */
	SelectArcs createSelectArcs();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	YawlannotationsPackage getYawlannotationsPackage();

} //YawlannotationsFactory
