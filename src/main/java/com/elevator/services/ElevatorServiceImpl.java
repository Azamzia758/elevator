package com.elevator.services;

import java.util.ArrayDeque;
import java.util.Queue;

import org.springframework.stereotype.Component;

@Component
public class ElevatorServiceImpl implements ElevatorService {

	private Queue<Integer> elevatorRequest = new ArrayDeque<>();

	@Override
	public synchronized void requestElevator(int currentFloor) {
		this.elevatorRequest.add(currentFloor);
	}

	@Override
	public synchronized void gotoFloor(int floorNo) {
		this.elevatorRequest.add(floorNo);
	}

	@Override
	public Queue<Integer> getToBeServedFloors() {
		return elevatorRequest;
	}

	@Override
	public synchronized int getNextFloor() {
		return elevatorRequest.poll();
	}
	
}
