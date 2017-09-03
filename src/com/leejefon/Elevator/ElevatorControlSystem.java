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
    public ArrayList<Elevator> getElevators() {
        return this.elevators;
    }

    @Override
    public void requestUp(int currentFloor) {
        Elevator elevator = this.getBestElevator(currentFloor, ElevatorStatus.GOING_UP);
        elevator.addDestination(currentFloor);
    }

    @Override
    public void requestDown(int currentFloor) {
        Elevator elevator = this.getBestElevator(currentFloor, ElevatorStatus.GOING_DOWN);
        elevator.addDestination(currentFloor);
    }

    @Override
    public Elevator getBestElevator(Integer currentFloor, ElevatorStatus direction) {
        ElevatorStatus oppositeDirection = direction == ElevatorStatus.GOING_UP ?
                ElevatorStatus.GOING_DOWN : ElevatorStatus.GOING_UP;
        Elevator bestElevator = null;
        int smallestFloorDiff = numberOfFloors;

        // TODO: need to handle empty status
        for (Elevator elevator : elevators) {
            int floorDiff = -1;
            if (elevator.status() == direction) {
                if (direction == ElevatorStatus.GOING_UP) {
                    if (elevator.currentFloor() < currentFloor) {
                        floorDiff = currentFloor - elevator.currentFloor();
                    } else if (elevator.currentFloor() > currentFloor) {
                        floorDiff = 2 * numberOfFloors - elevator.currentFloor() - currentFloor;
                    } else {
                        bestElevator = elevator;
                        break;
                    }
                } else if (direction == ElevatorStatus.GOING_DOWN) {
                    if (elevator.currentFloor() > currentFloor) {
                        floorDiff = elevator.currentFloor() - currentFloor;
                    } else if (elevator.currentFloor() < currentFloor) {
                        floorDiff = elevator.currentFloor() + currentFloor;
                    } else {
                        bestElevator = elevator;
                        break;
                    }
                }
            } else if (elevator.status() == oppositeDirection){
                if (direction == ElevatorStatus.GOING_UP) {
                    floorDiff = elevator.currentFloor() + currentFloor;
                } else {
                    floorDiff = 2 * numberOfFloors - elevator.currentFloor() - currentFloor;
                }
            } else if (elevator.status() == ElevatorStatus.EMPTY) {
                // Just do it for now
                bestElevator = elevator;
                break;
            }

            if (floorDiff < smallestFloorDiff) {
                smallestFloorDiff = floorDiff;
                bestElevator = elevator;
            }
        }

        return bestElevator;
    }

    @Override
    public void step() {
        for (Elevator elevator : elevators) {
            switch (elevator.status()) {
                case GOING_UP:
                    elevator.moveUp();
                    break;
                case GOING_DOWN:
                    elevator.moveDown();
                    break;
                case OPEN:
                    // NOTE: skip one round
                    break;
                case EMPTY:
                    // NOTE: move down to 1st floor
                    if (elevator.currentFloor() > 1) {
                        elevator.moveDown();
                    }
                    break;
            }
        }
    }
}
