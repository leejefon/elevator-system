package com.leejefon.Elevator;

import java.util.ArrayList;

public class Elevator implements InterfaceElevator {
    private Integer currentFloor;
    private ElevatorStatus currentStatus;
    private ArrayList<Integer> destinationFloors;

    public Elevator(Integer currentFloor) {
        this.currentFloor = currentFloor;
        this.currentStatus = ElevatorStatus.EMPTY;
        this.destinationFloors = new ArrayList<>();
    }

    @Override
    public int currentFloor() {
        return this.currentFloor;
    }

    @Override
    public void addDestination(int floor) {
        if (floor > this.currentFloor) {
            this.currentStatus = ElevatorStatus.GOING_UP;
            this.destinationFloors.add(floor);
        } else if (floor < this.currentFloor) {
            this.currentStatus = ElevatorStatus.GOING_DOWN;
            this.destinationFloors.add(floor);
        } else {
            this.currentStatus = ElevatorStatus.OPEN;
        }
    }

    @Override
    public void moveUp() {
        this.currentFloor++;
        if (destinationFloors.contains(this.currentFloor)) {
            this.currentStatus = ElevatorStatus.OPEN;
            destinationFloors.remove(Integer.valueOf(this.currentFloor));
        }
    }

    @Override
    public void moveDown() {
        this.currentFloor--;
        if (destinationFloors.contains(this.currentFloor)) {
            this.currentStatus = ElevatorStatus.OPEN;
            destinationFloors.remove(Integer.valueOf(this.currentFloor));
        }
    }

    @Override
    public ElevatorStatus status() {
        if (destinationFloors.isEmpty() && this.currentStatus != ElevatorStatus.OPEN) {
            this.currentStatus = ElevatorStatus.EMPTY;
        }
        return this.currentStatus;
    }
}
