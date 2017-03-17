/**
 */
package dk.dtu.compute.mbse.yawl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>TType</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTType()
 * @model
 * @generated
 */
public enum TType implements Enumerator {
	/**
	 * The '<em><b>SINGLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_VALUE
	 * @generated
	 * @ordered
	 */
	SINGLE(0, "SINGLE", "SINGLE"),

	/**
	 * The '<em><b>SPLITOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPLITOR_VALUE
	 * @generated
	 * @ordered
	 */
	SPLITOR(1, "SPLITOR", "SPLITOR"),

	/**
	 * The '<em><b>SPLITXOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPLITXOR_VALUE
	 * @generated
	 * @ordered
	 */
	SPLITXOR(2, "SPLITXOR", "SPLITXOR"),

	/**
	 * The '<em><b>JOINAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOINAND_VALUE
	 * @generated
	 * @ordered
	 */
	JOINAND(3, "JOINAND", "JOINAND"),

	/**
	 * The '<em><b>JOINOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOINOR_VALUE
	 * @generated
	 * @ordered
	 */
	JOINOR(4, "JOINOR", "JOINOR"),

	/**
	 * The '<em><b>JOINXOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOINXOR_VALUE
	 * @generated
	 * @ordered
	 */
	JOINXOR(5, "JOINXOR", "JOINXOR"),

	/**
	 * The '<em><b>SPLITAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPLITAND_VALUE
	 * @generated
	 * @ordered
	 */
	SPLITAND(6, "SPLITAND", "SPLITAND");

	/**
	 * The '<em><b>SINGLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE_VALUE = 0;

	/**
	 * The '<em><b>SPLITOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPLITOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPLITOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPLITOR_VALUE = 1;

	/**
	 * The '<em><b>SPLITXOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPLITXOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPLITXOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPLITXOR_VALUE = 2;

	/**
	 * The '<em><b>JOINAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JOINAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JOINAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JOINAND_VALUE = 3;

	/**
	 * The '<em><b>JOINOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JOINOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JOINOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JOINOR_VALUE = 4;

	/**
	 * The '<em><b>JOINXOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JOINXOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JOINXOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JOINXOR_VALUE = 5;

	/**
	 * The '<em><b>SPLITAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPLITAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPLITAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPLITAND_VALUE = 6;

	/**
	 * An array of all the '<em><b>TType</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TType[] VALUES_ARRAY =
		new TType[] {
			SINGLE,
			SPLITOR,
			SPLITXOR,
			JOINAND,
			JOINOR,
			JOINXOR,
			SPLITAND,
		};

	/**
	 * A public read-only list of all the '<em><b>TType</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>TType</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TType</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TType</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TType get(int value) {
		switch (value) {
			case SINGLE_VALUE: return SINGLE;
			case SPLITOR_VALUE: return SPLITOR;
			case SPLITXOR_VALUE: return SPLITXOR;
			case JOINAND_VALUE: return JOINAND;
			case JOINOR_VALUE: return JOINOR;
			case JOINXOR_VALUE: return JOINXOR;
			case SPLITAND_VALUE: return SPLITAND;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TType
