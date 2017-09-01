package com.leejefon.Elevator;

public interface InterfaceElevator {
    int currentFloor();
    void addDestination(Integer floor);
    void moveUp();
    void moveDown();
    ElevatorStatus status();
}
