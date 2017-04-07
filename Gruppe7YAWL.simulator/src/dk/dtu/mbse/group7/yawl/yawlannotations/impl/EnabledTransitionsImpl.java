/**
 */
package dk.dtu.mbse.group7.yawl.yawlannotations.impl;

import dk.dtu.mbse.group7.yawl.yawlannotations.EnabledTransitions;
import dk.dtu.mbse.group7.yawl.yawlannotations.SelectArcs;
import dk.dtu.mbse.group7.yawl.yawlannotations.YawlannotationsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.pnml.tools.epnk.annotations.netannotations.impl.ObjectAnnotationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enabled Transitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.mbse.group7.yawl.yawlannotations.impl.EnabledTransitionsImpl#getResolved <em>Resolved</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.yawlannotations.impl.EnabledTransitionsImpl#getInArc <em>In Arc</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.yawlannotations.impl.EnabledTransitionsImpl#getOutArcs <em>Out Arcs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnabledTransitionsImpl extends ObjectAnnotationImpl implements EnabledTransitions {
	/**
	 * The cached value of the '{@link #getResolved() <em>Resolved</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolved()
	 * @generated
	 * @ordered
	 */
	protected EnabledTransitions resolved;

	/**
	 * The cached value of the '{@link #getInArc() <em>In Arc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInArc()
	 * @generated
	 * @ordered
	 */
	protected SelectArcs inArc;

	/**
	 * The cached value of the '{@link #getOutArcs() <em>Out Arcs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutArcs()
	 * @generated
	 * @ordered
	 */
	protected EList outArcs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnabledTransitionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return YawlannotationsPackage.Literals.ENABLED_TRANSITIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnabledTransitions getResolved() {
		if (resolved != null && resolved.eIsProxy()) {
			InternalEObject oldResolved = (InternalEObject)resolved;
			resolved = (EnabledTransitions)eResolveProxy(oldResolved);
			if (resolved != oldResolved) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, YawlannotationsPackage.ENABLED_TRANSITIONS__RESOLVED, oldResolved, resolved));
			}
		}
		return resolved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnabledTransitions basicGetResolved() {
		return resolved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolved(EnabledTransitions newResolved) {
		EnabledTransitions oldResolved = resolved;
		resolved = newResolved;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlannotationsPackage.ENABLED_TRANSITIONS__RESOLVED, oldResolved, resolved));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectArcs getInArc() {
		if (inArc != null && inArc.eIsProxy()) {
			InternalEObject oldInArc = (InternalEObject)inArc;
			inArc = (SelectArcs)eResolveProxy(oldInArc);
			if (inArc != oldInArc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC, oldInArc, inArc));
			}
		}
		return inArc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectArcs basicGetInArc() {
		return inArc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInArc(SelectArcs newInArc, NotificationChain msgs) {
		SelectArcs oldInArc = inArc;
		inArc = newInArc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC, oldInArc, newInArc);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInArc(SelectArcs newInArc) {
		if (newInArc != inArc) {
			NotificationChain msgs = null;
			if (inArc != null)
				msgs = ((InternalEObject)inArc).eInverseRemove(this, YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION, SelectArcs.class, msgs);
			if (newInArc != null)
				msgs = ((InternalEObject)newInArc).eInverseAdd(this, YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION, SelectArcs.class, msgs);
			msgs = basicSetInArc(newInArc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC, newInArc, newInArc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOutArcs() {
		if (outArcs == null) {
			outArcs = new EObjectWithInverseResolvingEList(SelectArcs.class, this, YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS, YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION);
		}
		return outArcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				if (inArc != null)
					msgs = ((InternalEObject)inArc).eInverseRemove(this, YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION, SelectArcs.class, msgs);
				return basicSetInArc((SelectArcs)otherEnd, msgs);
			case YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS:
				return ((InternalEList)getOutArcs()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				return basicSetInArc(null, msgs);
			case YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS:
				return ((InternalEList)getOutArcs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YawlannotationsPackage.ENABLED_TRANSITIONS__RESOLVED:
				if (resolve) return getResolved();
				return basicGetResolved();
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				if (resolve) return getInArc();
				return basicGetInArc();
			case YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS:
				return getOutArcs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case YawlannotationsPackage.ENABLED_TRANSITIONS__RESOLVED:
				setResolved((EnabledTransitions)newValue);
				return;
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				setInArc((SelectArcs)newValue);
				return;
			case YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS:
				getOutArcs().clear();
				getOutArcs().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case YawlannotationsPackage.ENABLED_TRANSITIONS__RESOLVED:
				setResolved((EnabledTransitions)null);
				return;
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				setInArc((SelectArcs)null);
				return;
			case YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS:
				getOutArcs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case YawlannotationsPackage.ENABLED_TRANSITIONS__RESOLVED:
				return resolved != null;
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				return inArc != null;
			case YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS:
				return outArcs != null && !outArcs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnabledTransitionsImpl
