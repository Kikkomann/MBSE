package dk.dtu.mbse.group7.yawl.simulator.exceptions;

/**
 * @author Nicki Nylin - s153769
 */
public class WrongTypeException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongTypeException() {
		super();
	}
	
	public WrongTypeException(String message) {
		super(message);
	}
}
