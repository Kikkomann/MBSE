/**
 */
package dk.dtu.compute.mbse.yawl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.pnml.tools.epnk.pnmlcoremodel.PnmlcoremodelPackage;

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
 * @see dk.dtu.compute.mbse.yawl.YawlFactory
 * @model kind="package"
 * @generated
 */
public interface YawlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "yawl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.compute.dtu.dk/mbse/yawl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "yawl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	YawlPackage eINSTANCE = dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl.init();

	/**
	 * The meta object id for the '{@link dk.dtu.compute.mbse.yawl.impl.YAWLNetImpl <em>YAWL Net</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.dtu.compute.mbse.yawl.impl.YAWLNetImpl
	 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getYAWLNet()
	 * @generated
	 */
	int YAWL_NET = 0;

	/**
	 * The number of structural features of the '<em>YAWL Net</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YAWL_NET_FEATURE_COUNT = PnmlcoremodelPackage.PETRI_NET_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.dtu.compute.mbse.yawl.impl.PlaceImpl <em>Place</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.dtu.compute.mbse.yawl.impl.PlaceImpl
	 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getPlace()
	 * @generated
	 */
	int PLACE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ID = PnmlcoremodelPackage.PLACE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__NAME = PnmlcoremodelPackage.PLACE__NAME;

	/**
	 * The feature id for the '<em><b>Toolspecific</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__TOOLSPECIFIC = PnmlcoremodelPackage.PLACE__TOOLSPECIFIC;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__GRAPHICS = PnmlcoremodelPackage.PLACE__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__UNKNOWN = PnmlcoremodelPackage.PLACE__UNKNOWN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__OUT = PnmlcoremodelPackage.PLACE__OUT;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__IN = PnmlcoremodelPackage.PLACE__IN;

	/**
	 * The feature id for the '<em><b>Placetype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__PLACETYPE = PnmlcoremodelPackage.PLACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_FEATURE_COUNT = PnmlcoremodelPackage.PLACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.dtu.compute.mbse.yawl.impl.PlaceTypeImpl <em>Place Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.dtu.compute.mbse.yawl.impl.PlaceTypeImpl
	 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getPlaceType()
	 * @generated
	 */
	int PLACE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Toolspecific</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_TYPE__TOOLSPECIFIC = PnmlcoremodelPackage.ATTRIBUTE__TOOLSPECIFIC;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_TYPE__GRAPHICS = PnmlcoremodelPackage.ATTRIBUTE__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_TYPE__UNKNOWN = PnmlcoremodelPackage.ATTRIBUTE__UNKNOWN;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_TYPE__TEXT = PnmlcoremodelPackage.ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Place Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_TYPE_FEATURE_COUNT = PnmlcoremodelPackage.ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.dtu.compute.mbse.yawl.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.dtu.compute.mbse.yawl.impl.TransitionImpl
	 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ID = PnmlcoremodelPackage.TRANSITION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = PnmlcoremodelPackage.TRANSITION__NAME;

	/**
	 * The feature id for the '<em><b>Toolspecific</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TOOLSPECIFIC = PnmlcoremodelPackage.TRANSITION__TOOLSPECIFIC;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GRAPHICS = PnmlcoremodelPackage.TRANSITION__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__UNKNOWN = PnmlcoremodelPackage.TRANSITION__UNKNOWN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__OUT = PnmlcoremodelPackage.TRANSITION__OUT;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__IN = PnmlcoremodelPackage.TRANSITION__IN;

	/**
	 * The feature id for the '<em><b>Neweclass5</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NEWECLASS5 = PnmlcoremodelPackage.TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = PnmlcoremodelPackage.TRANSITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.dtu.compute.mbse.yawl.impl.TransitionTypeImpl <em>Transition Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.dtu.compute.mbse.yawl.impl.TransitionTypeImpl
	 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getTransitionType()
	 * @generated
	 */
	int TRANSITION_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_TYPE__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Transition Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dk.dtu.compute.mbse.yawl.impl.ArcImpl <em>Arc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.dtu.compute.mbse.yawl.impl.ArcImpl
	 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getArc()
	 * @generated
	 */
	int ARC = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__ID = PnmlcoremodelPackage.ARC__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__NAME = PnmlcoremodelPackage.ARC__NAME;

	/**
	 * The feature id for the '<em><b>Toolspecific</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__TOOLSPECIFIC = PnmlcoremodelPackage.ARC__TOOLSPECIFIC;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__GRAPHICS = PnmlcoremodelPackage.ARC__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__UNKNOWN = PnmlcoremodelPackage.ARC__UNKNOWN;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__SOURCE = PnmlcoremodelPackage.ARC__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__TARGET = PnmlcoremodelPackage.ARC__TARGET;

	/**
	 * The number of structural features of the '<em>Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_FEATURE_COUNT = PnmlcoremodelPackage.ARC_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.dtu.compute.mbse.yawl.PType <em>PType</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.dtu.compute.mbse.yawl.PType
	 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getPType()
	 * @generated
	 */
	int PTYPE = 6;

	/**
	 * The meta object id for the '{@link dk.dtu.compute.mbse.yawl.TType <em>TType</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.dtu.compute.mbse.yawl.TType
	 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getTType()
	 * @generated
	 */
	int TTYPE = 7;


	/**
	 * Returns the meta object for class '{@link dk.dtu.compute.mbse.yawl.YAWLNet <em>YAWL Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>YAWL Net</em>'.
	 * @see dk.dtu.compute.mbse.yawl.YAWLNet
	 * @generated
	 */
	EClass getYAWLNet();

	/**
	 * Returns the meta object for class '{@link dk.dtu.compute.mbse.yawl.Place <em>Place</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Place</em>'.
	 * @see dk.dtu.compute.mbse.yawl.Place
	 * @generated
	 */
	EClass getPlace();

	/**
	 * Returns the meta object for the containment reference '{@link dk.dtu.compute.mbse.yawl.Place#getPlacetype <em>Placetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Placetype</em>'.
	 * @see dk.dtu.compute.mbse.yawl.Place#getPlacetype()
	 * @see #getPlace()
	 * @generated
	 */
	EReference getPlace_Placetype();

	/**
	 * Returns the meta object for class '{@link dk.dtu.compute.mbse.yawl.PlaceType <em>Place Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Place Type</em>'.
	 * @see dk.dtu.compute.mbse.yawl.PlaceType
	 * @generated
	 */
	EClass getPlaceType();

	/**
	 * Returns the meta object for the attribute '{@link dk.dtu.compute.mbse.yawl.PlaceType#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see dk.dtu.compute.mbse.yawl.PlaceType#getText()
	 * @see #getPlaceType()
	 * @generated
	 */
	EAttribute getPlaceType_Text();

	/**
	 * Returns the meta object for class '{@link dk.dtu.compute.mbse.yawl.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see dk.dtu.compute.mbse.yawl.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the containment reference '{@link dk.dtu.compute.mbse.yawl.Transition#getNeweclass5 <em>Neweclass5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Neweclass5</em>'.
	 * @see dk.dtu.compute.mbse.yawl.Transition#getNeweclass5()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Neweclass5();

	/**
	 * Returns the meta object for class '{@link dk.dtu.compute.mbse.yawl.TransitionType <em>Transition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Type</em>'.
	 * @see dk.dtu.compute.mbse.yawl.TransitionType
	 * @generated
	 */
	EClass getTransitionType();

	/**
	 * Returns the meta object for the attribute '{@link dk.dtu.compute.mbse.yawl.TransitionType#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see dk.dtu.compute.mbse.yawl.TransitionType#getText()
	 * @see #getTransitionType()
	 * @generated
	 */
	EAttribute getTransitionType_Text();

	/**
	 * Returns the meta object for class '{@link dk.dtu.compute.mbse.yawl.Arc <em>Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arc</em>'.
	 * @see dk.dtu.compute.mbse.yawl.Arc
	 * @generated
	 */
	EClass getArc();

	/**
	 * Returns the meta object for enum '{@link dk.dtu.compute.mbse.yawl.PType <em>PType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>PType</em>'.
	 * @see dk.dtu.compute.mbse.yawl.PType
	 * @generated
	 */
	EEnum getPType();

	/**
	 * Returns the meta object for enum '{@link dk.dtu.compute.mbse.yawl.TType <em>TType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TType</em>'.
	 * @see dk.dtu.compute.mbse.yawl.TType
	 * @generated
	 */
	EEnum getTType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	YawlFactory getYawlFactory();

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
		 * The meta object literal for the '{@link dk.dtu.compute.mbse.yawl.impl.YAWLNetImpl <em>YAWL Net</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.dtu.compute.mbse.yawl.impl.YAWLNetImpl
		 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getYAWLNet()
		 * @generated
		 */
		EClass YAWL_NET = eINSTANCE.getYAWLNet();

		/**
		 * The meta object literal for the '{@link dk.dtu.compute.mbse.yawl.impl.PlaceImpl <em>Place</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.dtu.compute.mbse.yawl.impl.PlaceImpl
		 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getPlace()
		 * @generated
		 */
		EClass PLACE = eINSTANCE.getPlace();

		/**
		 * The meta object literal for the '<em><b>Placetype</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE__PLACETYPE = eINSTANCE.getPlace_Placetype();

		/**
		 * The meta object literal for the '{@link dk.dtu.compute.mbse.yawl.impl.PlaceTypeImpl <em>Place Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.dtu.compute.mbse.yawl.impl.PlaceTypeImpl
		 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getPlaceType()
		 * @generated
		 */
		EClass PLACE_TYPE = eINSTANCE.getPlaceType();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE_TYPE__TEXT = eINSTANCE.getPlaceType_Text();

		/**
		 * The meta object literal for the '{@link dk.dtu.compute.mbse.yawl.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.dtu.compute.mbse.yawl.impl.TransitionImpl
		 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Neweclass5</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__NEWECLASS5 = eINSTANCE.getTransition_Neweclass5();

		/**
		 * The meta object literal for the '{@link dk.dtu.compute.mbse.yawl.impl.TransitionTypeImpl <em>Transition Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.dtu.compute.mbse.yawl.impl.TransitionTypeImpl
		 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getTransitionType()
		 * @generated
		 */
		EClass TRANSITION_TYPE = eINSTANCE.getTransitionType();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_TYPE__TEXT = eINSTANCE.getTransitionType_Text();

		/**
		 * The meta object literal for the '{@link dk.dtu.compute.mbse.yawl.impl.ArcImpl <em>Arc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.dtu.compute.mbse.yawl.impl.ArcImpl
		 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getArc()
		 * @generated
		 */
		EClass ARC = eINSTANCE.getArc();

		/**
		 * The meta object literal for the '{@link dk.dtu.compute.mbse.yawl.PType <em>PType</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.dtu.compute.mbse.yawl.PType
		 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getPType()
		 * @generated
		 */
		EEnum PTYPE = eINSTANCE.getPType();

		/**
		 * The meta object literal for the '{@link dk.dtu.compute.mbse.yawl.TType <em>TType</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.dtu.compute.mbse.yawl.TType
		 * @see dk.dtu.compute.mbse.yawl.impl.YawlPackageImpl#getTType()
		 * @generated
		 */
		EEnum TTYPE = eINSTANCE.getTType();

	}

} //YawlPackage
