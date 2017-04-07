/**
 */
package dk.dtu.mbse.group7.yawl.impl;

import org.eclipse.emf.ecore.EClass;

import org.pnml.tools.epnk.pnmlcoremodel.impl.PetriNetTypeImpl;

import dk.dtu.mbse.group7.yawl.YAWLNet;
import dk.dtu.mbse.group7.yawl.YawlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>YAWL Net</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class YAWLNetImpl extends PetriNetTypeImpl implements YAWLNet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * put author tag if generated NOT is set
	 */
	public YAWLNetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YawlPackage.Literals.YAWL_NET;
	}

	@Override
	public String toString() {
		//TODO gamle URI: return "http://se.compute.dtu.dk/mbse/yawl";
		return "http://group7.dtu.dk/mbse/yawl";
	}

} //YAWLNetImpl
