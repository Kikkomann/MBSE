/**
 */
package yawl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link yawl.Transition#getSplitType <em>Split Type</em>}</li>
 *   <li>{@link yawl.Transition#getJoinType <em>Join Type</em>}</li>
 * </ul>
 *
 * @see yawl.YawlPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends org.pnml.tools.epnk.pnmlcoremodel.Transition {
	/**
	 * Returns the value of the '<em><b>Split Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Split Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Split Type</em>' containment reference.
	 * @see #setSplitType(SplitTransition)
	 * @see yawl.YawlPackage#getTransition_SplitType()
	 * @model containment="true"
	 * @generated
	 */
	SplitTransition getSplitType();

	/**
	 * Sets the value of the '{@link yawl.Transition#getSplitType <em>Split Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Split Type</em>' containment reference.
	 * @see #getSplitType()
	 * @generated
	 */
	void setSplitType(SplitTransition value);

	/**
	 * Returns the value of the '<em><b>Join Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Join Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Type</em>' containment reference.
	 * @see #setJoinType(JoinTransition)
	 * @see yawl.YawlPackage#getTransition_JoinType()
	 * @model containment="true"
	 * @generated
	 */
	JoinTransition getJoinType();

	/**
	 * Sets the value of the '{@link yawl.Transition#getJoinType <em>Join Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Type</em>' containment reference.
	 * @see #getJoinType()
	 * @generated
	 */
	void setJoinType(JoinTransition value);

} // Transition
