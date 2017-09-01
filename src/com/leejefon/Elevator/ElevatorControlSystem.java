package com.leejefon.Elevator;

import java.util.ArrayList;

public class ElevatorControlSystem implements InterfaceElevatorControlSystem {
    Integer numberOfElevators= 0;
    Integer numberOfFloors = 0;
    ArrayList<Elevator> elevators;

    public ElevatorControlSystem(Integer numberOfElevators, Integer numberOfFloors) {
        this.numberOfElevators = numberOfElevators;
        this.numberOfFloors = numberOfFloors;

        this.elevators = new ArrayList<>();
        for (int i = 0; i < numberOfElevators; i++) {
            this.elevators.add(new Elevator(1));
        }
    }

    @Override
    public void requestUp(Integer currentFloor) {
        Elevator elevator = this.getClosestElevator(currentFloor, ElevatorStatus.ELEVATOR_GOING_UP);
        elevator.addDestination(currentFloor);
    }

    @Override
    public void requestDown(Integer currentFloor) {
        Elevator elevator = this.getClosestElevator(currentFloor, ElevatorStatus.ELEVATOR_GOING_DOWN);
        elevator.addDestination(currentFloor);
    }

    @Override
    public Elevator getClosestElevator(Integer currentFloor, ElevatorStatus direction) {
        // TODO: calculate
        return elevators.get(0);
    }

    @Override
    public void step() {
        // TODO: loop elevators
    }
}
