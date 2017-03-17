/**
 */
package dk.dtu.compute.mbse.yawl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.compute.mbse.yawl.Transition#getNeweclass5 <em>Neweclass5</em>}</li>
 * </ul>
 *
 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends org.pnml.tools.epnk.pnmlcoremodel.Transition {
	/**
	 * Returns the value of the '<em><b>Neweclass5</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Neweclass5</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Neweclass5</em>' containment reference.
	 * @see #setNeweclass5(TransitionType)
	 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTransition_Neweclass5()
	 * @model containment="true"
	 * @generated
	 */
	TransitionType getNeweclass5();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.yawl.Transition#getNeweclass5 <em>Neweclass5</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Neweclass5</em>' containment reference.
	 * @see #getNeweclass5()
	 * @generated
	 */
	void setNeweclass5(TransitionType value);

} // Transition
