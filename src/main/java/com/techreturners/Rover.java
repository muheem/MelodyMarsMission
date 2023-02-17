package com.techreturners;

import java.awt.Point;

enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction rotateRight() {
        return values()[(ordinal() + 1) % 4];
    }
    public Direction rotate180() {
        return values()[(ordinal() + 2) % 4];
    }
    public Direction rotateLeft() {
        return values()[(ordinal() + 3) % 4];
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

    public void wrap(Point limit) {
        // We've reached the edge of the
        switch (direction) {
            case NORTH:
                location.y = 0;
                break;
            case EAST:
                location.x = 0;
                break;
            case SOUTH:
                location.y = 0;
                break;
            case WEST:
                location.x = 0;
                break;
        }
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
    public void moveBeyondLimit(Point limit) {
        // We've reached the edge , beyond lie dragons.
        switch (direction) {
            case NORTH:
                location.y = 0;
                break;
            case EAST:
                location.x = 0;
                break;
            case SOUTH:
                location.y = limit.y - 1;
                break;
            case WEST:
                location.x = limit.x - 1;
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

    public Point nextMoveBeyondLimit(Point limit) {
        // We've reached the edge , beyond lie dragons.
        Point newPoint = new Point(location);
        switch (direction) {
            case NORTH:
                newPoint.y = 0;
                break;
            case EAST:
                newPoint.x = 0;
                break;
            case SOUTH:
                newPoint.y = limit.y - 1;
                break;
            case WEST:
                newPoint.x = limit.x - 1;
                break;
        }
        return newPoint;
    }

}

public class Rover extends MarsVehicle {
    Rover() { super(); }
}
