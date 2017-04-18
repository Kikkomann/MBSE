/**
 */
package dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl;

import dk.dtu.mbse.group7.yawl.Transition;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsPackage;

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
 *   <li>{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.EnabledTransitionsImpl#getResolved <em>Resolved</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.EnabledTransitionsImpl#getInArc <em>In Arc</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.EnabledTransitionsImpl#getOutArcs <em>Out Arcs</em>}</li>
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
	 * @generated NOT
	 * @author s150157
	 */
	protected boolean enabled = false;

	/**
	 * The cached value of the '{@link #getInArc() <em>In Arc</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInArc()
	 * @generated
	 * @ordered
	 */
	protected EList<SelectArcs> inArc;

	/**
	 * The cached value of the '{@link #getOutArcs() <em>Out Arcs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutArcs()
	 * @generated
	 * @ordered
	 */
	protected EList<SelectArcs> outArcs;

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
	@Override
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
	public EList<SelectArcs> getInArc() {
		if (inArc == null) {
			inArc = new EObjectWithInverseResolvingEList<SelectArcs>(SelectArcs.class, this, YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC, YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION);
		}
		return inArc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SelectArcs> getOutArcs() {
		if (outArcs == null) {
			outArcs = new EObjectWithInverseResolvingEList<SelectArcs>(SelectArcs.class, this, YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS, YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION);
		}
		return outArcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInArc()).basicAdd(otherEnd, msgs);
			case YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutArcs()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				return ((InternalEList<?>)getInArc()).basicRemove(otherEnd, msgs);
			case YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS:
				return ((InternalEList<?>)getOutArcs()).basicRemove(otherEnd, msgs);
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
			case YawlannotationsPackage.ENABLED_TRANSITIONS__RESOLVED:
				if (resolve) return getResolved();
				return basicGetResolved();
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				return getInArc();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case YawlannotationsPackage.ENABLED_TRANSITIONS__RESOLVED:
				setResolved((EnabledTransitions)newValue);
				return;
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				getInArc().clear();
				getInArc().addAll((Collection<? extends SelectArcs>)newValue);
				return;
			case YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS:
				getOutArcs().clear();
				getOutArcs().addAll((Collection<? extends SelectArcs>)newValue);
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
			case YawlannotationsPackage.ENABLED_TRANSITIONS__RESOLVED:
				setResolved((EnabledTransitions)null);
				return;
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				getInArc().clear();
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
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case YawlannotationsPackage.ENABLED_TRANSITIONS__RESOLVED:
				return resolved != null;
			case YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC:
				return inArc != null && !inArc.isEmpty();
			case YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS:
				return outArcs != null && !outArcs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 *  @author s150157
	 */
	@Override
	public Transition getTransition() {
		if (getObject() instanceof Transition) {
			return (Transition) getObject();
		}
		return null;
	}

} //EnabledTransitionsImpl
