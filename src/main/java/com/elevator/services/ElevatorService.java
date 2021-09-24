package com.elevator.services;

import java.util.Queue;

/**
 * 
 * Hanldes elevator services
 * 
 * @author Azam Zia
 *
 */
public interface ElevatorService {

	/**
	 * 
	 * A person requests an elevator be sent to their current floor
	 * 
	 * @param currentFloor
	 */
	void requestElevator(int currentFloor);
	
	/**
	 * 
	 * A person requests that they be brought to a floor
	 * 
	 * @param floorNo
	 */
	void gotoFloor(int floorNo);
	
	/**
	 * An elevator car requests all floors that it’s current passengers are servicing (e.g. to light up the buttons that show which floors the car is going to)
	 * 
	 * @return {@link Queue}
	 */
	Queue<Integer> getToBeServedFloors();
	
	/**
	 * 
	 * An elevator car requests the next floor it needs to service
	 * 
	 * @return {@link Integer}
	 */
	int getNextFloor();
	
}
