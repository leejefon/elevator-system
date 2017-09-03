package com.leejefon.Elevator;

import java.util.ArrayList;

public interface InterfaceElevatorControlSystem {
    ArrayList<Elevator> getElevators();
    void requestUp(int currentFloor);
    void requestDown(int currentFloor);

    Elevator getBestElevator(Integer currentFloor, ElevatorStatus direction);
    void step();
}
