/**
 */
package yawl.yawlannotations;

import org.eclipse.emf.common.util.EList;

import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select Arcs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link yawl.yawlannotations.SelectArcs#getTargetTransition <em>Target Transition</em>}</li>
 *   <li>{@link yawl.yawlannotations.SelectArcs#getSourceTransition <em>Source Transition</em>}</li>
 *   <li>{@link yawl.yawlannotations.SelectArcs#getSourceMarking <em>Source Marking</em>}</li>
 *   <li>{@link yawl.yawlannotations.SelectArcs#isSelected <em>Selected</em>}</li>
 * </ul>
 *
 * @see yawl.yawlannotations.YawlannotationsPackage#getSelectArcs()
 * @model
 * @generated
 */
public interface SelectArcs extends ObjectAnnotation {
	/**
	 * Returns the value of the '<em><b>Target Transition</b></em>' reference list.
	 * The list contents are of type {@link yawl.yawlannotations.EnabledTransitions}.
	 * It is bidirectional and its opposite is '{@link yawl.yawlannotations.EnabledTransitions#getInArc <em>In Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Transition</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Transition</em>' reference list.
	 * @see yawl.yawlannotations.YawlannotationsPackage#getSelectArcs_TargetTransition()
	 * @see yawl.yawlannotations.EnabledTransitions#getInArc
	 * @model opposite="inArc"
	 * @generated
	 */
	EList<EnabledTransitions> getTargetTransition();

	/**
	 * Returns the value of the '<em><b>Source Transition</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link yawl.yawlannotations.EnabledTransitions#getOutArcs <em>Out Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Transition</em>' reference.
	 * @see #setSourceTransition(EnabledTransitions)
	 * @see yawl.yawlannotations.YawlannotationsPackage#getSelectArcs_SourceTransition()
	 * @see yawl.yawlannotations.EnabledTransitions#getOutArcs
	 * @model opposite="outArcs"
	 * @generated
	 */
	EnabledTransitions getSourceTransition();

	/**
	 * Sets the value of the '{@link yawl.yawlannotations.SelectArcs#getSourceTransition <em>Source Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Transition</em>' reference.
	 * @see #getSourceTransition()
	 * @generated
	 */
	void setSourceTransition(EnabledTransitions value);

	/**
	 * Returns the value of the '<em><b>Source Marking</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Marking</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Marking</em>' reference.
	 * @see #setSourceMarking(Marking)
	 * @see yawl.yawlannotations.YawlannotationsPackage#getSelectArcs_SourceMarking()
	 * @model
	 * @generated
	 */
	Marking getSourceMarking();

	/**
	 * Sets the value of the '{@link yawl.yawlannotations.SelectArcs#getSourceMarking <em>Source Marking</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Marking</em>' reference.
	 * @see #getSourceMarking()
	 * @generated
	 */
	void setSourceMarking(Marking value);

	/**
	 * Returns the value of the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected</em>' attribute.
	 * @see #setSelected(boolean)
	 * @see yawl.yawlannotations.YawlannotationsPackage#getSelectArcs_Selected()
	 * @model required="true"
	 * @generated
	 */
	boolean isSelected();

	/**
	 * Sets the value of the '{@link yawl.yawlannotations.SelectArcs#isSelected <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected</em>' attribute.
	 * @see #isSelected()
	 * @generated
	 */
	void setSelected(boolean value);

} // SelectArcs
