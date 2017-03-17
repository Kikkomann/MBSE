/**
 */
package dk.dtu.compute.mbse.yawl.impl;

import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.TransitionType;
import dk.dtu.compute.mbse.yawl.YawlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.compute.mbse.yawl.impl.TransitionImpl#getNeweclass5 <em>Neweclass5</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends org.pnml.tools.epnk.pnmlcoremodel.impl.TransitionImpl implements Transition {
	/**
	 * The cached value of the '{@link #getNeweclass5() <em>Neweclass5</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeweclass5()
	 * @generated
	 * @ordered
	 */
	protected TransitionType neweclass5;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YawlPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionType getNeweclass5() {
		return neweclass5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNeweclass5(TransitionType newNeweclass5, NotificationChain msgs) {
		TransitionType oldNeweclass5 = neweclass5;
		neweclass5 = newNeweclass5;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__NEWECLASS5, oldNeweclass5, newNeweclass5);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeweclass5(TransitionType newNeweclass5) {
		if (newNeweclass5 != neweclass5) {
			NotificationChain msgs = null;
			if (neweclass5 != null)
				msgs = ((InternalEObject)neweclass5).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__NEWECLASS5, null, msgs);
			if (newNeweclass5 != null)
				msgs = ((InternalEObject)newNeweclass5).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__NEWECLASS5, null, msgs);
			msgs = basicSetNeweclass5(newNeweclass5, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__NEWECLASS5, newNeweclass5, newNeweclass5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YawlPackage.TRANSITION__NEWECLASS5:
				return basicSetNeweclass5(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YawlPackage.TRANSITION__NEWECLASS5:
				return getNeweclass5();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case YawlPackage.TRANSITION__NEWECLASS5:
				setNeweclass5((TransitionType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case YawlPackage.TRANSITION__NEWECLASS5:
				setNeweclass5((TransitionType)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case YawlPackage.TRANSITION__NEWECLASS5:
				return neweclass5 != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
