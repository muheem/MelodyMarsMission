package com.techreturners;

import java.awt.Point;

enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction rotateRight() {
        Direction d = values()[(ordinal() + 1) % 4];
        return d;
    }

    public Direction rotateLeft() {
        Direction d =  values()[(ordinal() + 3) % 4];
        return d;
    }
}


abstract class MarsVehicle {
    Direction direction = Direction.NORTH;
    Point location = new Point(0, 0);

    Plateau map;

    MarsVehicle() {
    }


    Point currentLocation() {
        return location;
    }

    public void turnleft() {
        direction = direction.rotateLeft();
    }

    public void turnRight() {
        direction = direction.rotateRight();
    }

    public void move() {
            switch (direction) {
                case NORTH:
                    location.y += 1;
                    break;
                case EAST:
                    location.x += 1;
                    break;
                case SOUTH:
                    location.y -= 1;
                    break;
                case WEST:
                    location.x -= 1;
                    break;
            }
        }

    public Point nextMove() {
        Point next = new Point(location);
        switch (direction) {
            case NORTH:
                next.y += 1;
                break;
            case EAST:
                next.x += 1;
                break;
            case SOUTH:
                next.y -= 1;
                break;
            case WEST:
                next.x -= 1;
                break;
        }
        return next;
    }

    public char currentDirection() {
        char ret = ' ';
        switch (direction) {
            case NORTH:
                ret = 'N';
                break;
            case EAST:
                ret = 'E';
                break;
            case SOUTH:
                ret = 'S';
                break;
            case WEST:
                ret = 'W';
                break;
        }
        return ret;
    }

    public Point currentPosition() {
        return location;
    }

    public void setPosition(Point position) {
        location = position;
    }

    public void setDirection(char c) {
        switch (c) {
            case 'N':
                direction = Direction.NORTH;
                break;
            case 'E':
                direction = Direction.EAST;
                break;
            case 'S':
                direction = Direction.SOUTH;
                break;
            case 'W':
                direction = Direction.WEST;
                break;
        }
    }
}

public class Rover extends MarsVehicle {
        Rover() {
            super();
        }
}
