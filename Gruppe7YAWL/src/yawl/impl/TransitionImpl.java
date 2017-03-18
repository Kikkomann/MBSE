/**
 */
package yawl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import yawl.JoinTransition;
import yawl.SplitTransition;
import yawl.Transition;
import yawl.YawlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link yawl.impl.TransitionImpl#getSplitTransition <em>Split Transition</em>}</li>
 *   <li>{@link yawl.impl.TransitionImpl#getJoinTransition <em>Join Transition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends org.pnml.tools.epnk.pnmlcoremodel.impl.TransitionImpl implements Transition {
	/**
	 * The cached value of the '{@link #getSplitTransition() <em>Split Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplitTransition()
	 * @generated
	 * @ordered
	 */
	protected SplitTransition splitTransition;
	/**
	 * The cached value of the '{@link #getJoinTransition() <em>Join Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinTransition()
	 * @generated
	 * @ordered
	 */
	protected JoinTransition joinTransition;
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
	public SplitTransition getSplitTransition() {
		return splitTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSplitTransition(SplitTransition newSplitTransition, NotificationChain msgs) {
		SplitTransition oldSplitTransition = splitTransition;
		splitTransition = newSplitTransition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__SPLIT_TRANSITION, oldSplitTransition, newSplitTransition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSplitTransition(SplitTransition newSplitTransition) {
		if (newSplitTransition != splitTransition) {
			NotificationChain msgs = null;
			if (splitTransition != null)
				msgs = ((InternalEObject)splitTransition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__SPLIT_TRANSITION, null, msgs);
			if (newSplitTransition != null)
				msgs = ((InternalEObject)newSplitTransition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__SPLIT_TRANSITION, null, msgs);
			msgs = basicSetSplitTransition(newSplitTransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__SPLIT_TRANSITION, newSplitTransition, newSplitTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinTransition getJoinTransition() {
		return joinTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJoinTransition(JoinTransition newJoinTransition, NotificationChain msgs) {
		JoinTransition oldJoinTransition = joinTransition;
		joinTransition = newJoinTransition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__JOIN_TRANSITION, oldJoinTransition, newJoinTransition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJoinTransition(JoinTransition newJoinTransition) {
		if (newJoinTransition != joinTransition) {
			NotificationChain msgs = null;
			if (joinTransition != null)
				msgs = ((InternalEObject)joinTransition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__JOIN_TRANSITION, null, msgs);
			if (newJoinTransition != null)
				msgs = ((InternalEObject)newJoinTransition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__JOIN_TRANSITION, null, msgs);
			msgs = basicSetJoinTransition(newJoinTransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__JOIN_TRANSITION, newJoinTransition, newJoinTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YawlPackage.TRANSITION__SPLIT_TRANSITION:
				return basicSetSplitTransition(null, msgs);
			case YawlPackage.TRANSITION__JOIN_TRANSITION:
				return basicSetJoinTransition(null, msgs);
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
			case YawlPackage.TRANSITION__SPLIT_TRANSITION:
				return getSplitTransition();
			case YawlPackage.TRANSITION__JOIN_TRANSITION:
				return getJoinTransition();
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
			case YawlPackage.TRANSITION__SPLIT_TRANSITION:
				setSplitTransition((SplitTransition)newValue);
				return;
			case YawlPackage.TRANSITION__JOIN_TRANSITION:
				setJoinTransition((JoinTransition)newValue);
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
			case YawlPackage.TRANSITION__SPLIT_TRANSITION:
				setSplitTransition((SplitTransition)null);
				return;
			case YawlPackage.TRANSITION__JOIN_TRANSITION:
				setJoinTransition((JoinTransition)null);
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
			case YawlPackage.TRANSITION__SPLIT_TRANSITION:
				return splitTransition != null;
			case YawlPackage.TRANSITION__JOIN_TRANSITION:
				return joinTransition != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
