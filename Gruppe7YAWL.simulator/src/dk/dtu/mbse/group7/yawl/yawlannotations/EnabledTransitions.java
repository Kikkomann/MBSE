/**
 */
package dk.dtu.mbse.group7.yawl.yawlannotations;

import org.eclipse.emf.common.util.EList;

import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enabled Transitions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.mbse.group7.yawl.yawlannotations.EnabledTransitions#getResolved <em>Resolved</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.yawlannotations.EnabledTransitions#getInArc <em>In Arc</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.yawlannotations.EnabledTransitions#getOutArcs <em>Out Arcs</em>}</li>
 * </ul>
 *
 * @see dk.dtu.mbse.group7.yawl.yawlannotations.YawlannotationsPackage#getEnabledTransitions()
 * @model
 * @generated
 */
public interface EnabledTransitions extends ObjectAnnotation {
	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' reference.
	 * @see #setResolved(EnabledTransitions)
	 * @see dk.dtu.mbse.group7.yawl.yawlannotations.YawlannotationsPackage#getEnabledTransitions_Resolved()
	 * @model
	 * @generated
	 */
	EnabledTransitions getResolved();

	/**
	 * Sets the value of the '{@link dk.dtu.mbse.group7.yawl.yawlannotations.EnabledTransitions#getResolved <em>Resolved</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved</em>' reference.
	 * @see #getResolved()
	 * @generated
	 */
	void setResolved(EnabledTransitions value);

	/**
	 * Returns the value of the '<em><b>In Arc</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link dk.dtu.mbse.group7.yawl.yawlannotations.SelectArcs#getTargetTransition <em>Target Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Arc</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Arc</em>' reference.
	 * @see #setInArc(SelectArcs)
	 * @see dk.dtu.mbse.group7.yawl.yawlannotations.YawlannotationsPackage#getEnabledTransitions_InArc()
	 * @see dk.dtu.mbse.group7.yawl.yawlannotations.SelectArcs#getTargetTransition
	 * @model opposite="targetTransition"
	 * @generated
	 */
	SelectArcs getInArc();

	/**
	 * Sets the value of the '{@link dk.dtu.mbse.group7.yawl.yawlannotations.EnabledTransitions#getInArc <em>In Arc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Arc</em>' reference.
	 * @see #getInArc()
	 * @generated
	 */
	void setInArc(SelectArcs value);

	/**
	 * Returns the value of the '<em><b>Out Arcs</b></em>' reference list.
	 * The list contents are of type {@link dk.dtu.mbse.group7.yawl.yawlannotations.SelectArcs}.
	 * It is bidirectional and its opposite is '{@link dk.dtu.mbse.group7.yawl.yawlannotations.SelectArcs#getSourceTransition <em>Source Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Arcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Arcs</em>' reference list.
	 * @see dk.dtu.mbse.group7.yawl.yawlannotations.YawlannotationsPackage#getEnabledTransitions_OutArcs()
	 * @see dk.dtu.mbse.group7.yawl.yawlannotations.SelectArcs#getSourceTransition
	 * @model type="dk.dtu.mbse.group7.yawl.yawlannotations.SelectArcs" opposite="sourceTransition"
	 * @generated
	 */
	EList getOutArcs();

} // EnabledTransitions
