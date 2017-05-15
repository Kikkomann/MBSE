/**
 */
package dk.dtu.mbse.group7.yawl.simulator.yawlannotations;

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
 *   <li>{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getTargetTransition <em>Target Transition</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getSourceTransition <em>Source Transition</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getSourceMarking <em>Source Marking</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#isSelected <em>Selected</em>}</li>
 * </ul>
 *
 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsPackage#getSelectArcs()
 * @model
 * @generated
 */
public interface SelectArcs extends ObjectAnnotation {
	/**
	 * Returns the value of the '<em><b>Target Transition</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions#getInArc <em>In Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Transition</em>' reference.
	 * @see #setTargetTransition(EnabledTransitions)
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsPackage#getSelectArcs_TargetTransition()
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions#getInArc
	 * @model opposite="inArc"
	 * @generated
	 */
	EnabledTransitions getTargetTransition();

	/**
	 * Sets the value of the '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getTargetTransition <em>Target Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Transition</em>' reference.
	 * @see #getTargetTransition()
	 * @generated
	 */
	void setTargetTransition(EnabledTransitions value);

	/**
	 * Returns the value of the '<em><b>Source Transition</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions#getOutArcs <em>Out Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Transition</em>' reference.
	 * @see #setSourceTransition(EnabledTransitions)
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsPackage#getSelectArcs_SourceTransition()
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions#getOutArcs
	 * @model opposite="outArcs"
	 * @generated
	 */
	EnabledTransitions getSourceTransition();

	/**
	 * Sets the value of the '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getSourceTransition <em>Source Transition</em>}' reference.
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
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsPackage#getSelectArcs_SourceMarking()
	 * @model
	 * @generated
	 */
	Marking getSourceMarking();

	/**
	 * Sets the value of the '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getSourceMarking <em>Source Marking</em>}' reference.
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
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsPackage#getSelectArcs_Selected()
	 * @model required="true"
	 * @generated
	 */
	boolean isSelected();

	/**
	 * Sets the value of the '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#isSelected <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected</em>' attribute.
	 * @see #isSelected()
	 * @generated
	 */
	void setSelected(boolean value);

} // SelectArcs
