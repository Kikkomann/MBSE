/**
 */
package dk.dtu.mbse.group7.yawl.yawlannotations.impl;

import dk.dtu.mbse.group7.yawl.yawlannotations.EnabledTransitions;
import dk.dtu.mbse.group7.yawl.yawlannotations.Marking;
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
 * An implementation of the model object '<em><b>Select Arcs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.mbse.group7.yawl.yawlannotations.impl.SelectArcsImpl#getTargetTransition <em>Target Transition</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.yawlannotations.impl.SelectArcsImpl#getSourceTransition <em>Source Transition</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.yawlannotations.impl.SelectArcsImpl#getSourceMarking <em>Source Marking</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.yawlannotations.impl.SelectArcsImpl#isSelected <em>Selected</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelectArcsImpl extends ObjectAnnotationImpl implements SelectArcs {
	/**
	 * The cached value of the '{@link #getTargetTransition() <em>Target Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTransition()
	 * @generated
	 * @ordered
	 */
	protected EList targetTransition;

	/**
	 * The cached value of the '{@link #getSourceTransition() <em>Source Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceTransition()
	 * @generated
	 * @ordered
	 */
	protected EnabledTransitions sourceTransition;

	/**
	 * The cached value of the '{@link #getSourceMarking() <em>Source Marking</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMarking()
	 * @generated
	 * @ordered
	 */
	protected Marking sourceMarking;

	/**
	 * The default value of the '{@link #isSelected() <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSelected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SELECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSelected() <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSelected()
	 * @generated
	 * @ordered
	 */
	protected boolean selected = SELECTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectArcsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return YawlannotationsPackage.Literals.SELECT_ARCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTargetTransition() {
		if (targetTransition == null) {
			targetTransition = new EObjectWithInverseResolvingEList(EnabledTransitions.class, this, YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION, YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC);
		}
		return targetTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnabledTransitions getSourceTransition() {
		if (sourceTransition != null && sourceTransition.eIsProxy()) {
			InternalEObject oldSourceTransition = (InternalEObject)sourceTransition;
			sourceTransition = (EnabledTransitions)eResolveProxy(oldSourceTransition);
			if (sourceTransition != oldSourceTransition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION, oldSourceTransition, sourceTransition));
			}
		}
		return sourceTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnabledTransitions basicGetSourceTransition() {
		return sourceTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceTransition(EnabledTransitions newSourceTransition, NotificationChain msgs) {
		EnabledTransitions oldSourceTransition = sourceTransition;
		sourceTransition = newSourceTransition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION, oldSourceTransition, newSourceTransition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceTransition(EnabledTransitions newSourceTransition) {
		if (newSourceTransition != sourceTransition) {
			NotificationChain msgs = null;
			if (sourceTransition != null)
				msgs = ((InternalEObject)sourceTransition).eInverseRemove(this, YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS, EnabledTransitions.class, msgs);
			if (newSourceTransition != null)
				msgs = ((InternalEObject)newSourceTransition).eInverseAdd(this, YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS, EnabledTransitions.class, msgs);
			msgs = basicSetSourceTransition(newSourceTransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION, newSourceTransition, newSourceTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Marking getSourceMarking() {
		if (sourceMarking != null && sourceMarking.eIsProxy()) {
			InternalEObject oldSourceMarking = (InternalEObject)sourceMarking;
			sourceMarking = (Marking)eResolveProxy(oldSourceMarking);
			if (sourceMarking != oldSourceMarking) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, YawlannotationsPackage.SELECT_ARCS__SOURCE_MARKING, oldSourceMarking, sourceMarking));
			}
		}
		return sourceMarking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Marking basicGetSourceMarking() {
		return sourceMarking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceMarking(Marking newSourceMarking) {
		Marking oldSourceMarking = sourceMarking;
		sourceMarking = newSourceMarking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlannotationsPackage.SELECT_ARCS__SOURCE_MARKING, oldSourceMarking, sourceMarking));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelected(boolean newSelected) {
		boolean oldSelected = selected;
		selected = newSelected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlannotationsPackage.SELECT_ARCS__SELECTED, oldSelected, selected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				return ((InternalEList)getTargetTransition()).basicAdd(otherEnd, msgs);
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION:
				if (sourceTransition != null)
					msgs = ((InternalEObject)sourceTransition).eInverseRemove(this, YawlannotationsPackage.ENABLED_TRANSITIONS__OUT_ARCS, EnabledTransitions.class, msgs);
				return basicSetSourceTransition((EnabledTransitions)otherEnd, msgs);
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
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				return ((InternalEList)getTargetTransition()).basicRemove(otherEnd, msgs);
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION:
				return basicSetSourceTransition(null, msgs);
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
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				return getTargetTransition();
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION:
				if (resolve) return getSourceTransition();
				return basicGetSourceTransition();
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_MARKING:
				if (resolve) return getSourceMarking();
				return basicGetSourceMarking();
			case YawlannotationsPackage.SELECT_ARCS__SELECTED:
				return isSelected() ? Boolean.TRUE : Boolean.FALSE;
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
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				getTargetTransition().clear();
				getTargetTransition().addAll((Collection)newValue);
				return;
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION:
				setSourceTransition((EnabledTransitions)newValue);
				return;
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_MARKING:
				setSourceMarking((Marking)newValue);
				return;
			case YawlannotationsPackage.SELECT_ARCS__SELECTED:
				setSelected(((Boolean)newValue).booleanValue());
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
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				getTargetTransition().clear();
				return;
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION:
				setSourceTransition((EnabledTransitions)null);
				return;
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_MARKING:
				setSourceMarking((Marking)null);
				return;
			case YawlannotationsPackage.SELECT_ARCS__SELECTED:
				setSelected(SELECTED_EDEFAULT);
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
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				return targetTransition != null && !targetTransition.isEmpty();
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION:
				return sourceTransition != null;
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_MARKING:
				return sourceMarking != null;
			case YawlannotationsPackage.SELECT_ARCS__SELECTED:
				return selected != SELECTED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (selected: ");
		result.append(selected);
		result.append(')');
		return result.toString();
	}

} //SelectArcsImpl
