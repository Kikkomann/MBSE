/**
 */
package dk.dtu.mbse.group7.yawl.simulator.yawlannotations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.pnml.tools.epnk.annotations.netannotations.NetannotationsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsFactory
 * @model kind="package"
 * @generated
 */
public interface YawlannotationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "yawlannotations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://group7.dtu.dk/mbse/yawl/simulator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "yawlanno";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	YawlannotationsPackage eINSTANCE = dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.YawlannotationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.MarkingImpl <em>Marking</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.MarkingImpl
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.YawlannotationsPackageImpl#getMarking()
	 * @generated
	 */
	int MARKING = 0;

	/**
	 * The feature id for the '<em><b>Net Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING__NET_ANNOTATIONS = NetannotationsPackage.OBJECT_ANNOTATION__NET_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING__OBJECT = NetannotationsPackage.OBJECT_ANNOTATION__OBJECT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING__VALUE = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Marking</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING_FEATURE_COUNT = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.EnabledTransitionsImpl <em>Enabled Transitions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.EnabledTransitionsImpl
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.YawlannotationsPackageImpl#getEnabledTransitions()
	 * @generated
	 */
	int ENABLED_TRANSITIONS = 1;

	/**
	 * The feature id for the '<em><b>Net Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITIONS__NET_ANNOTATIONS = NetannotationsPackage.OBJECT_ANNOTATION__NET_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITIONS__OBJECT = NetannotationsPackage.OBJECT_ANNOTATION__OBJECT;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITIONS__RESOLVED = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITIONS__IN_ARC = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Out Arcs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITIONS__OUT_ARCS = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Enabled Transitions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITIONS_FEATURE_COUNT = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.SelectArcsImpl <em>Select Arcs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.SelectArcsImpl
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.YawlannotationsPackageImpl#getSelectArcs()
	 * @generated
	 */
	int SELECT_ARCS = 2;

	/**
	 * The feature id for the '<em><b>Net Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ARCS__NET_ANNOTATIONS = NetannotationsPackage.OBJECT_ANNOTATION__NET_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ARCS__OBJECT = NetannotationsPackage.OBJECT_ANNOTATION__OBJECT;

	/**
	 * The feature id for the '<em><b>Target Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ARCS__TARGET_TRANSITION = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ARCS__SOURCE_TRANSITION = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Marking</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ARCS__SOURCE_MARKING = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ARCS__SELECTED = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Select Arcs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ARCS_FEATURE_COUNT = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.Marking <em>Marking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Marking</em>'.
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.Marking
	 * @generated
	 */
	EClass getMarking();

	/**
	 * Returns the meta object for the attribute '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.Marking#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.Marking#getValue()
	 * @see #getMarking()
	 * @generated
	 */
	EAttribute getMarking_Value();

	/**
	 * Returns the meta object for class '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions <em>Enabled Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enabled Transitions</em>'.
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions
	 * @generated
	 */
	EClass getEnabledTransitions();

	/**
	 * Returns the meta object for the reference '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions#getResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved</em>'.
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions#getResolved()
	 * @see #getEnabledTransitions()
	 * @generated
	 */
	EReference getEnabledTransitions_Resolved();

	/**
	 * Returns the meta object for the reference list '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions#getInArc <em>In Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Arc</em>'.
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions#getInArc()
	 * @see #getEnabledTransitions()
	 * @generated
	 */
	EReference getEnabledTransitions_InArc();

	/**
	 * Returns the meta object for the reference list '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions#getOutArcs <em>Out Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out Arcs</em>'.
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions#getOutArcs()
	 * @see #getEnabledTransitions()
	 * @generated
	 */
	EReference getEnabledTransitions_OutArcs();

	/**
	 * Returns the meta object for class '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs <em>Select Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Arcs</em>'.
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs
	 * @generated
	 */
	EClass getSelectArcs();

	/**
	 * Returns the meta object for the reference '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getTargetTransition <em>Target Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Transition</em>'.
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getTargetTransition()
	 * @see #getSelectArcs()
	 * @generated
	 */
	EReference getSelectArcs_TargetTransition();

	/**
	 * Returns the meta object for the reference '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getSourceTransition <em>Source Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Transition</em>'.
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getSourceTransition()
	 * @see #getSelectArcs()
	 * @generated
	 */
	EReference getSelectArcs_SourceTransition();

	/**
	 * Returns the meta object for the reference '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getSourceMarking <em>Source Marking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Marking</em>'.
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#getSourceMarking()
	 * @see #getSelectArcs()
	 * @generated
	 */
	EReference getSelectArcs_SourceMarking();

	/**
	 * Returns the meta object for the attribute '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#isSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs#isSelected()
	 * @see #getSelectArcs()
	 * @generated
	 */
	EAttribute getSelectArcs_Selected();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	YawlannotationsFactory getYawlannotationsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.MarkingImpl <em>Marking</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.MarkingImpl
		 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.YawlannotationsPackageImpl#getMarking()
		 * @generated
		 */
		EClass MARKING = eINSTANCE.getMarking();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKING__VALUE = eINSTANCE.getMarking_Value();

		/**
		 * The meta object literal for the '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.EnabledTransitionsImpl <em>Enabled Transitions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.EnabledTransitionsImpl
		 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.YawlannotationsPackageImpl#getEnabledTransitions()
		 * @generated
		 */
		EClass ENABLED_TRANSITIONS = eINSTANCE.getEnabledTransitions();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENABLED_TRANSITIONS__RESOLVED = eINSTANCE.getEnabledTransitions_Resolved();

		/**
		 * The meta object literal for the '<em><b>In Arc</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENABLED_TRANSITIONS__IN_ARC = eINSTANCE.getEnabledTransitions_InArc();

		/**
		 * The meta object literal for the '<em><b>Out Arcs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENABLED_TRANSITIONS__OUT_ARCS = eINSTANCE.getEnabledTransitions_OutArcs();

		/**
		 * The meta object literal for the '{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.SelectArcsImpl <em>Select Arcs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.SelectArcsImpl
		 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.YawlannotationsPackageImpl#getSelectArcs()
		 * @generated
		 */
		EClass SELECT_ARCS = eINSTANCE.getSelectArcs();

		/**
		 * The meta object literal for the '<em><b>Target Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_ARCS__TARGET_TRANSITION = eINSTANCE.getSelectArcs_TargetTransition();

		/**
		 * The meta object literal for the '<em><b>Source Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_ARCS__SOURCE_TRANSITION = eINSTANCE.getSelectArcs_SourceTransition();

		/**
		 * The meta object literal for the '<em><b>Source Marking</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_ARCS__SOURCE_MARKING = eINSTANCE.getSelectArcs_SourceMarking();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_ARCS__SELECTED = eINSTANCE.getSelectArcs_Selected();

	}

} //YawlannotationsPackage
