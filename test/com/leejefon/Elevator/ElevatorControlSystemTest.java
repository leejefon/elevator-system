package com.leejefon.Elevator;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ElevatorControlSystemTest extends TestCase {
    @Test
    public void testElevatorSystem() {
        ElevatorControlSystem elevatorControlSystem = new ElevatorControlSystem(2, 20);
        elevatorControlSystem.requestUp(10);
        for (int i = 0; i < 10; i++) {
            elevatorControlSystem.step();
        }
        ArrayList<Elevator> elevators = elevatorControlSystem.getElevators();
        assertEquals(10, elevators.get(0).currentFloor());
    }
}
