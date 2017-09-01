package com.leejefon.Elevator;

import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator implements InterfaceElevator {
    private Integer currentFloor;
    private Queue<Integer> destinationFloors;

    public Elevator(Integer currentFloor) {
        this.currentFloor = currentFloor;
        this.destinationFloors = new PriorityQueue<>();
    }

    @Override
    public int currentFloor() {
        return this.currentFloor;
    }

    @Override
    public void addDestination(Integer floor) {
        this.destinationFloors.offer(floor);
    }

    @Override
    public void moveUp() {
        this.currentFloor++;
    }

    @Override
    public void moveDown() {
        this.currentFloor--;
    }

    @Override
    public ElevatorStatus status() {
        // TODO: check status
        return ElevatorStatus.ELEVATOR_OPEN;
    }
}
