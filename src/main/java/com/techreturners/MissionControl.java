package com.techreturners;

import java.awt.Point;


abstract class ControlRoom {
    MarsVehicle [] rovers = new Rover[10]; //MAGIC NUMBER !
    Plateau map;

    ControlRoom(Plateau map) {
        this.map = map;
    }

    abstract boolean AddVehicle(Point position, char direction);

    public abstract void MoveRover(String command);

    public Point MarsRoverPosition() {
        return rovers[0].currentLocation();
    }

    public char MarsRoverDirection() {
        return rovers[0].currentDirection();
    }


}

public class MissionControl extends ControlRoom {
    static final char MOVE = 'M';
    static final char RIGHT = 'R';
    static final char LEFT = 'L';

    MissionControl(Plateau map) {
        super(map);
    }

    public boolean AddVehicle(Point position, char direction) {

        // Add vehicle to the plateau

        // Check position free.
        if (map.isOccupied(position))
            throw new IllegalStateException("Occupied position="+ position + " Cannot place Rover here.");
        if (map.outOfBounds(position))
            throw new IllegalStateException("Position beyond the map=" + position + " Cannot place Rover here.");

        rovers[0] = new Rover();
        rovers[0].setPosition(position);
        rovers[0].setDirection(direction);
        return true;
    }

    public void MoveRover(String command) {
        // Break down command
        // Starting with one rover.

        for (char c : command.toCharArray()) {
            switch (c) {
                case MOVE:
                    Point p = rovers[0].nextMove();
                    if (map.outOfBounds(p)) {
                        p = rovers[0].nextMoveBeyondLimit(map.limit);
                        if (map.isOccupied(p))
                            throw new IllegalStateException("Obstacle encountered="+ p + " Cannot move further.");
                        rovers[0].moveBeyondLimit(map.limit);
                    }
                    else {
                        if (map.isOccupied(p))
                            throw new IllegalStateException("Obstacle encountered=" + p + " Cannot move further.");
                        rovers[0].move();
                    }
                    break;
                case RIGHT:
                    rovers[0].turnRight();
                    break;
                case LEFT:
                    rovers[0].turnleft();
                    break;
                default:
                    // Invalid command skip and hope...
            }
        }
    }
}