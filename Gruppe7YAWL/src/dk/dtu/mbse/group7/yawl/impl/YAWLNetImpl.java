/**
 */
package dk.dtu.mbse.group7.yawl.impl;

import dk.dtu.mbse.group7.yawl.YAWLNet;
import dk.dtu.mbse.group7.yawl.YawlPackage;

import org.eclipse.emf.ecore.EClass;

import org.pnml.tools.epnk.pnmlcoremodel.impl.PetriNetTypeImpl;

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
	 * @author Sebastian Hoppe
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

	/**
	 * @generated NOT
	 * @author Sebastian Hoppe
	 */
	@Override
	public String toString() {
		return "http://group7.dtu.dk/mbse/yawl";
	}

} //YAWLNetImpl
