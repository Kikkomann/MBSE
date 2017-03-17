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
 *   <li>{@link dk.dtu.compute.mbse.yawl.Transition#getSplitTransition <em>Split Transition</em>}</li>
 *   <li>{@link dk.dtu.compute.mbse.yawl.Transition#getJoinTransition <em>Join Transition</em>}</li>
 * </ul>
 *
 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends org.pnml.tools.epnk.pnmlcoremodel.Transition {
	/**
	 * Returns the value of the '<em><b>Split Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Split Transition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Split Transition</em>' containment reference.
	 * @see #setSplitTransition(SplitTransition)
	 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTransition_SplitTransition()
	 * @model containment="true"
	 * @generated
	 */
	SplitTransition getSplitTransition();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.yawl.Transition#getSplitTransition <em>Split Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Split Transition</em>' containment reference.
	 * @see #getSplitTransition()
	 * @generated
	 */
	void setSplitTransition(SplitTransition value);

	/**
	 * Returns the value of the '<em><b>Join Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Join Transition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Transition</em>' containment reference.
	 * @see #setJoinTransition(JoinTransition)
	 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTransition_JoinTransition()
	 * @model containment="true"
	 * @generated
	 */
	JoinTransition getJoinTransition();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.yawl.Transition#getJoinTransition <em>Join Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Transition</em>' containment reference.
	 * @see #getJoinTransition()
	 * @generated
	 */
	void setJoinTransition(JoinTransition value);

} // Transition
