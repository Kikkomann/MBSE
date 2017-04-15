package dk.dtu.mbse.group7.yawl.simulator.marking;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;

import dk.dtu.mbse.group7.yawl.Place;


/**
 * This class represents a marking of a YAWL net. It guarantees a uniform
 * way of dealing with markings and avoids a lot of redundant code scattered
 * in the simulator.
 * 
 * @author ekki@dtu.dk
 *
 */
public class NetMarking {
	
	private Map<Place,Integer> marking;

	/**
	 * Creates a new empty marking.
	 */
	public NetMarking() {
		marking = new HashMap<Place,Integer>();
	}
	
	/**
	 * Creates a new marking, which is a copy of a given marking.
	 */
	public NetMarking(NetMarking marking) {
		this();
		for (Place place: marking.getSupport()) {
			this.setMarking(place, marking.getMarking(place));
		}
	}

	/**
	 * Sets the marking of a given condition to the given value. 
	 */
	public void setMarking(Place place, int value) {
		if (value > 0) {
			marking.put(place, value);
		} else {
			marking.remove(place);
		}
	}

	/**
	 * Returns the marking of a given condition. 
	 */
	public int getMarking(Place place) {
		return marking.getOrDefault(place,0);
	}

	/**
	 * Increments the marking of a given condition by a given increment. 
	 */
	public void incrementMarkingBy(Place place, int increment) {
		Assert.isLegal(increment >= 0, "The incrememt must be greater or equal than 0");
		setMarking((Place) place, getMarking((Place) place) + increment);
	}
	
	/**
	 * Decrements the marking of a given condition by a given decrement. 
	 */
	public void decrementMarkingBy(Place place, int decrement) {
		Assert.isLegal(decrement >= 0, "The decrememt must be greater or equal than 0");
		Assert.isLegal(getMarking((Place) place) >= decrement,
				"Marking of condition must be greater than the decrement");
		setMarking((Place) place, getMarking((Place) place) - decrement);
	}
	
	/**
	 * Adds marking2 to this marking
	 */
	public void add(NetMarking marking2) {
		for (Place place: marking2.marking.keySet()) {
			int m1 = marking.getOrDefault(place,0);
			int m2 = marking2.marking.getOrDefault(place, 0);
			if (m1 + m2 > 0) {
				marking.put(place, m1 + m2);
			} else {
				marking.remove(place);
			}
		}
	}
	
	/**
	 * Subtracts marking2 from this marking
	 */
	public void subtract(NetMarking marking2) {
		Assert.isLegal(this.isGreaterOrEqual(marking2), 
				"Subtraction the marking does not result in a marking again");
		
		for (Place place: marking2.marking.keySet()) {
			int m1 = marking.getOrDefault(place,0);
			int m2 = marking2.marking.getOrDefault(place, 0);
			if (m1 - m2 > 0) {
				marking.put(place, m1 - m2);
			} else {
				marking.remove(place);
			}
		}
	}
	
	/**
	 * Checks whether this marking is greater or equal than marking2.
	 */
	public boolean isGreaterOrEqual(NetMarking marking2) {
		for (Place place: marking2.marking.keySet()) {
			int m1 = marking.getOrDefault(place,0);
			int m2 = marking2.marking.getOrDefault(place, 0);
			if (m1 < m2) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns the set of all conditions that have at least one token, which is
	 * often called the support of the marking.
	 */
	public Collection<Place> getSupport() {
		return java.util.Collections.unmodifiableCollection(marking.keySet());
	}

}