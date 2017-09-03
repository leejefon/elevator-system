package com.leejefon.Elevator;

public interface InterfaceElevator {
    int currentFloor();
    void addDestination(int floor);
    void moveUp();
    void moveDown();
    ElevatorStatus status();
}
