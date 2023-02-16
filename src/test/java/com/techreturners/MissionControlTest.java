package com.techreturners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Point;



public class MissionControlTest {

    @Test
    public void CreatePlateauMoveRoverFirstTest() {
        Plateau gridMap = new GridMap(new Point(7,7));
        ControlRoom control = new MissionControl(gridMap);

        // Setup Position (of Mars Rover)
        Point loc = new Point(1,2);
        MarsVehicle rover = new Rover();
        control.AddVehicle(loc, 'N');

        // Instruct Rover to move to a new position
        String command = "LMLMLMLMM";
        control.MoveRover(command);

        Point expected = new Point(1,3);
        assertEquals( expected, control.MarsRoverPosition());

        char direction = 'N';
        assertEquals( direction, control.MarsRoverDirection());
    }

    @Test
    public void CreatePlateauMoveRoverSecondTest() {
        Plateau gridMap = new GridMap(new Point(5,5));
        ControlRoom control = new MissionControl(gridMap);

        // Setup Position (of Mars Rover)
        Point loc = new Point(3,3);
        MarsVehicle rover = new Rover();
        control.AddVehicle(loc, 'E');

        // Instruct Rover to move to a new position
        String command = "MMRMMRMRRM";
        control.MoveRover(command);

        Point expected = new Point(5,1);
        assertEquals( expected, control.MarsRoverPosition());

        char direction = 'E';
        assertEquals( direction, control.MarsRoverDirection());

    }

}
