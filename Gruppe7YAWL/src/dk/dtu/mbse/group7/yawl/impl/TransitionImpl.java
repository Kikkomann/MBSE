/**
 */
package dk.dtu.mbse.group7.yawl.impl;

import dk.dtu.mbse.group7.yawl.JoinTransition;
import dk.dtu.mbse.group7.yawl.SplitTransition;
import dk.dtu.mbse.group7.yawl.Transition;
import dk.dtu.mbse.group7.yawl.YawlPackage;

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
 *   <li>{@link dk.dtu.mbse.group7.yawl.impl.TransitionImpl#getSplitType <em>Split Type</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.impl.TransitionImpl#getJoinType <em>Join Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends org.pnml.tools.epnk.pnmlcoremodel.impl.TransitionImpl implements Transition {
	/**
	 * The cached value of the '{@link #getSplitType() <em>Split Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplitType()
	 * @generated
	 * @ordered
	 */
	protected SplitTransition splitType;

	/**
	 * The cached value of the '{@link #getJoinType() <em>Join Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinType()
	 * @generated
	 * @ordered
	 */
	protected JoinTransition joinType;

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
	public SplitTransition getSplitType() {
		return splitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSplitType(SplitTransition newSplitType, NotificationChain msgs) {
		SplitTransition oldSplitType = splitType;
		splitType = newSplitType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__SPLIT_TYPE, oldSplitType, newSplitType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSplitType(SplitTransition newSplitType) {
		if (newSplitType != splitType) {
			NotificationChain msgs = null;
			if (splitType != null)
				msgs = ((InternalEObject)splitType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__SPLIT_TYPE, null, msgs);
			if (newSplitType != null)
				msgs = ((InternalEObject)newSplitType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__SPLIT_TYPE, null, msgs);
			msgs = basicSetSplitType(newSplitType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__SPLIT_TYPE, newSplitType, newSplitType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinTransition getJoinType() {
		return joinType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJoinType(JoinTransition newJoinType, NotificationChain msgs) {
		JoinTransition oldJoinType = joinType;
		joinType = newJoinType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__JOIN_TYPE, oldJoinType, newJoinType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJoinType(JoinTransition newJoinType) {
		if (newJoinType != joinType) {
			NotificationChain msgs = null;
			if (joinType != null)
				msgs = ((InternalEObject)joinType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__JOIN_TYPE, null, msgs);
			if (newJoinType != null)
				msgs = ((InternalEObject)newJoinType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__JOIN_TYPE, null, msgs);
			msgs = basicSetJoinType(newJoinType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__JOIN_TYPE, newJoinType, newJoinType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YawlPackage.TRANSITION__SPLIT_TYPE:
				return basicSetSplitType(null, msgs);
			case YawlPackage.TRANSITION__JOIN_TYPE:
				return basicSetJoinType(null, msgs);
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
			case YawlPackage.TRANSITION__SPLIT_TYPE:
				return getSplitType();
			case YawlPackage.TRANSITION__JOIN_TYPE:
				return getJoinType();
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
			case YawlPackage.TRANSITION__SPLIT_TYPE:
				setSplitType((SplitTransition)newValue);
				return;
			case YawlPackage.TRANSITION__JOIN_TYPE:
				setJoinType((JoinTransition)newValue);
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
			case YawlPackage.TRANSITION__SPLIT_TYPE:
				setSplitType((SplitTransition)null);
				return;
			case YawlPackage.TRANSITION__JOIN_TYPE:
				setJoinType((JoinTransition)null);
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
			case YawlPackage.TRANSITION__SPLIT_TYPE:
				return splitType != null;
			case YawlPackage.TRANSITION__JOIN_TYPE:
				return joinType != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
