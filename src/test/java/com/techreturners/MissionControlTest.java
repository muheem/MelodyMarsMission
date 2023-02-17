package com.techreturners;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
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
        Plateau gridMap = new GridMap(new Point(7,7));
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

    class YouAreHere {
        public Point p;
        public char direction = ' ';
    }

    public YouAreHere ConvertInputData(String s) {
        YouAreHere here = new YouAreHere();

        String[] strNums;
        strNums = s.split(" ");

        // Convert into a Point
        int one = Integer.parseInt(strNums[0]);
        int two = Integer.parseInt(strNums[1]);
        here.p = new Point(one ,two );

        // Get the direction pointed
        if (strNums.length > 2)
            here.direction = strNums[2].charAt(0);

        return here;
    }


    @ParameterizedTest
    @CsvFileSource(resources="/MelodyMarsMissionTest.csv", numLinesToSkip = 1)
    public void MelodyMarsMissionParametrisedTest(String input1, String input2, String input3, String expected) {

        YouAreHere here = ConvertInputData(input1);

        Plateau gridMap = new GridMap(here.p);
        ControlRoom control = new MissionControl(gridMap);


        // Setup Position (of Mars Rover)
        here = ConvertInputData(input2);
        Point loc = new Point(here.p);
        MarsVehicle rover = new Rover();
        control.AddVehicle(here.p, here.direction);

        // Instruct Rover to move to a new position
        control.MoveRover(input3);

        here = ConvertInputData(expected);
        assertEquals( here.p, control.MarsRoverPosition());
        assertEquals( here.direction, control.MarsRoverDirection());
    }

}
