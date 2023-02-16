package com.techreturners;

import java.awt.Point;

enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction rotateRight() {
        //return values()[ordinal() + 1];
        return values()[(ordinal() + 1) % 4];
    }

    public Direction turnAround() {
        return values()[(ordinal() + 2) % 4];
    }

    public Direction rotateLeft() {
        return values()[(ordinal() + 3) % 4];
    }
}


abstract class MarsVehicle {
    Direction direction = Direction.NORTH;
    Point location;

    MarsVehicle(Point loc) {
        this.location = loc;
    }

    Point currentLocation() {
        return location;
    }
    public boolean Command(String c) {
        //Go through each character and act on it.
        return false;
    };

    private void turnleft() {
        direction.rotateLeft();
    };
    private void turnRight() {
        direction.rotateRight();
    }
    private boolean move(String count) {
        // C
        return false;
    }

}

public class Rover extends MarsVehicle {
    Rover(Point loc) {
        super(loc);
    }
}
