package com.techreturners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Point;



public class MissionControlTest {

    @Test
    public void CreatePlateauMoveRover() {
        Point p = new Point(7,7);
        //GridMap grid = new GridMap(p);
        Point p2;
        //map map = new Map(p);
        ControlRoom control = new MissionControl(p);

        // Setup Plateau

        // Setup Position (of Mars Rover)

        // Instruct Rover to move to a new position

        // Check result .

        //RomanNumeralsConverter romanNumeralsConverter = new RomanNumeralsConverter();

        //assertEquals( "I", romanNumeralsConverter.Convert(1));
    }

}
