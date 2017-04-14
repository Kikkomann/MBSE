/**
 */
package dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl;

import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.Marking;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsFactory;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.pnml.tools.epnk.annotations.netannotations.NetannotationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class YawlannotationsPackageImpl extends EPackageImpl implements YawlannotationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass markingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enabledTransitionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectArcsEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private YawlannotationsPackageImpl() {
		super(eNS_URI, YawlannotationsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link YawlannotationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static YawlannotationsPackage init() {
		if (isInited) return (YawlannotationsPackage)EPackage.Registry.INSTANCE.getEPackage(YawlannotationsPackage.eNS_URI);

		// Obtain or create and register package
		YawlannotationsPackageImpl theYawlannotationsPackage = (YawlannotationsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof YawlannotationsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new YawlannotationsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NetannotationsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theYawlannotationsPackage.createPackageContents();

		// Initialize created meta-data
		theYawlannotationsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theYawlannotationsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(YawlannotationsPackage.eNS_URI, theYawlannotationsPackage);
		return theYawlannotationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMarking() {
		return markingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarking_Value() {
		return (EAttribute)markingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnabledTransitions() {
		return enabledTransitionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnabledTransitions_Resolved() {
		return (EReference)enabledTransitionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnabledTransitions_InArc() {
		return (EReference)enabledTransitionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnabledTransitions_OutArcs() {
		return (EReference)enabledTransitionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectArcs() {
		return selectArcsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectArcs_TargetTransition() {
		return (EReference)selectArcsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectArcs_SourceTransition() {
		return (EReference)selectArcsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectArcs_SourceMarking() {
		return (EReference)selectArcsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectArcs_Selected() {
		return (EAttribute)selectArcsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YawlannotationsFactory getYawlannotationsFactory() {
		return (YawlannotationsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		markingEClass = createEClass(MARKING);
		createEAttribute(markingEClass, MARKING__VALUE);

		enabledTransitionsEClass = createEClass(ENABLED_TRANSITIONS);
		createEReference(enabledTransitionsEClass, ENABLED_TRANSITIONS__RESOLVED);
		createEReference(enabledTransitionsEClass, ENABLED_TRANSITIONS__IN_ARC);
		createEReference(enabledTransitionsEClass, ENABLED_TRANSITIONS__OUT_ARCS);

		selectArcsEClass = createEClass(SELECT_ARCS);
		createEReference(selectArcsEClass, SELECT_ARCS__TARGET_TRANSITION);
		createEReference(selectArcsEClass, SELECT_ARCS__SOURCE_TRANSITION);
		createEReference(selectArcsEClass, SELECT_ARCS__SOURCE_MARKING);
		createEAttribute(selectArcsEClass, SELECT_ARCS__SELECTED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		NetannotationsPackage theNetannotationsPackage = (NetannotationsPackage)EPackage.Registry.INSTANCE.getEPackage(NetannotationsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		markingEClass.getESuperTypes().add(theNetannotationsPackage.getObjectAnnotation());
		markingEClass.getESuperTypes().add(theNetannotationsPackage.getTextualAnnotation());
		enabledTransitionsEClass.getESuperTypes().add(theNetannotationsPackage.getObjectAnnotation());
		selectArcsEClass.getESuperTypes().add(theNetannotationsPackage.getObjectAnnotation());

		// Initialize classes and features; add operations and parameters
		initEClass(markingEClass, Marking.class, "Marking", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMarking_Value(), ecorePackage.getEInt(), "value", null, 0, 1, Marking.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enabledTransitionsEClass, EnabledTransitions.class, "EnabledTransitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnabledTransitions_Resolved(), this.getEnabledTransitions(), null, "resolved", null, 0, 1, EnabledTransitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnabledTransitions_InArc(), this.getSelectArcs(), this.getSelectArcs_TargetTransition(), "inArc", null, 0, -1, EnabledTransitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnabledTransitions_OutArcs(), this.getSelectArcs(), this.getSelectArcs_SourceTransition(), "outArcs", null, 0, -1, EnabledTransitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectArcsEClass, SelectArcs.class, "SelectArcs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectArcs_TargetTransition(), this.getEnabledTransitions(), this.getEnabledTransitions_InArc(), "targetTransition", null, 0, 1, SelectArcs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectArcs_SourceTransition(), this.getEnabledTransitions(), this.getEnabledTransitions_OutArcs(), "sourceTransition", null, 0, 1, SelectArcs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectArcs_SourceMarking(), this.getMarking(), null, "sourceMarking", null, 0, 1, SelectArcs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectArcs_Selected(), ecorePackage.getEBoolean(), "selected", null, 1, 1, SelectArcs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //YawlannotationsPackageImpl
