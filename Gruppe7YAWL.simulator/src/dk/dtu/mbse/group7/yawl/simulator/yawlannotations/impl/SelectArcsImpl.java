/**
 */
package dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl;

import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.EnabledTransitions;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.Marking;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.SelectArcs;
import dk.dtu.mbse.group7.yawl.simulator.yawlannotations.YawlannotationsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.pnml.tools.epnk.annotations.netannotations.impl.ObjectAnnotationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Select Arcs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.SelectArcsImpl#getTargetTransition <em>Target Transition</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.SelectArcsImpl#getSourceTransition <em>Source Transition</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.SelectArcsImpl#getSourceMarking <em>Source Marking</em>}</li>
 *   <li>{@link dk.dtu.mbse.group7.yawl.simulator.yawlannotations.impl.SelectArcsImpl#isSelected <em>Selected</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelectArcsImpl extends ObjectAnnotationImpl implements SelectArcs {
	/**
	 * The cached value of the '{@link #getTargetTransition() <em>Target Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTransition()
	 * @generated
	 * @ordered
	 */
	protected EnabledTransitions targetTransition;

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
	 * @author Sebastian Hoppe - s154306
	 * @generated NOT
	 */
	protected static final boolean WARNING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSelected() <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSelected()
	 * @generated
	 * @ordered
	 */
	protected boolean selected = SELECTED_EDEFAULT;
	
	protected boolean warning = WARNING_EDEFAULT;

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
	@Override
	protected EClass eStaticClass() {
		return YawlannotationsPackage.Literals.SELECT_ARCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnabledTransitions getTargetTransition() {
		if (targetTransition != null && targetTransition.eIsProxy()) {
			InternalEObject oldTargetTransition = (InternalEObject)targetTransition;
			targetTransition = (EnabledTransitions)eResolveProxy(oldTargetTransition);
			if (targetTransition != oldTargetTransition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION, oldTargetTransition, targetTransition));
			}
		}
		return targetTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnabledTransitions basicGetTargetTransition() {
		return targetTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetTransition(EnabledTransitions newTargetTransition, NotificationChain msgs) {
		EnabledTransitions oldTargetTransition = targetTransition;
		targetTransition = newTargetTransition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION, oldTargetTransition, newTargetTransition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetTransition(EnabledTransitions newTargetTransition) {
		if (newTargetTransition != targetTransition) {
			NotificationChain msgs = null;
			if (targetTransition != null)
				msgs = ((InternalEObject)targetTransition).eInverseRemove(this, YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC, EnabledTransitions.class, msgs);
			if (newTargetTransition != null)
				msgs = ((InternalEObject)newTargetTransition).eInverseAdd(this, YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC, EnabledTransitions.class, msgs);
			msgs = basicSetTargetTransition(newTargetTransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION, newTargetTransition, newTargetTransition));
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
	 * @author Sebastian Hoppe - s154306
	 * @generated NOT
	 */
	public boolean isWarning() {
		return warning;
	}
	
	/**
	 * @author Sebastian Hoppe - s154306
	 * @generated NOT
	 */
	public void setWarning(boolean newWarning) {
		boolean oldWarning = selected;
		selected = newWarning;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlannotationsPackage.SELECT_ARCS__SELECTED, oldWarning, selected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				if (targetTransition != null)
					msgs = ((InternalEObject)targetTransition).eInverseRemove(this, YawlannotationsPackage.ENABLED_TRANSITIONS__IN_ARC, EnabledTransitions.class, msgs);
				return basicSetTargetTransition((EnabledTransitions)otherEnd, msgs);
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				return basicSetTargetTransition(null, msgs);
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				if (resolve) return getTargetTransition();
				return basicGetTargetTransition();
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION:
				if (resolve) return getSourceTransition();
				return basicGetSourceTransition();
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_MARKING:
				if (resolve) return getSourceMarking();
				return basicGetSourceMarking();
			case YawlannotationsPackage.SELECT_ARCS__SELECTED:
				return isSelected();
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
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				setTargetTransition((EnabledTransitions)newValue);
				return;
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_TRANSITION:
				setSourceTransition((EnabledTransitions)newValue);
				return;
			case YawlannotationsPackage.SELECT_ARCS__SOURCE_MARKING:
				setSourceMarking((Marking)newValue);
				return;
			case YawlannotationsPackage.SELECT_ARCS__SELECTED:
				setSelected((Boolean)newValue);
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
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				setTargetTransition((EnabledTransitions)null);
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
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case YawlannotationsPackage.SELECT_ARCS__TARGET_TRANSITION:
				return targetTransition != null;
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
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (selected: ");
		result.append(selected);
		result.append(')');
		return result.toString();
	}

} //SelectArcsImpl
