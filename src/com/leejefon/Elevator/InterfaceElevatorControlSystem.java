package com.leejefon.Elevator;

public interface InterfaceElevatorControlSystem {
    void requestUp(Integer currentFloor);
    void requestDown(Integer currentFloor);

    Elevator getClosestElevator(Integer currentFloor, ElevatorStatus direction);
    void step();
}
