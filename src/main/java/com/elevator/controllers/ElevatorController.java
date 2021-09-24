package com.elevator.controllers;

import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elevator.services.ElevatorService;

@RestController
@RequestMapping("/elevator")
public class ElevatorController {

	@Autowired
	private ElevatorService elevatorService;
	
	@PutMapping("/v1/{currentFloor}")
	public ResponseEntity<Void> requestElevator(int currentFloor) {
		elevatorService.requestElevator(currentFloor);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/v1/{floorNo}")
	public ResponseEntity<Void> gotoFloor(int floorNo) {
		elevatorService.gotoFloor(floorNo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/v1")
	public ResponseEntity<Queue<Integer>> getToBeServedFloors() {
		return new ResponseEntity<Queue<Integer>>(elevatorService.getToBeServedFloors(), HttpStatus.OK);
	}
	
	@GetMapping("/v1/next")
	public ResponseEntity<Integer> getNextFloor() {
		return new ResponseEntity<Integer>(elevatorService.getNextFloor(), HttpStatus.OK);
	}
}

