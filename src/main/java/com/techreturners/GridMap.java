package com.techreturners;

import java.awt.Point;



abstract class Plateau {
    public Point limit;
    Point[]  occupied = new Point[10];

    Plateau(Point p) {
        this.limit = p;
    }
    Boolean IsValidMove() {
        return false;
    };

    public boolean isValid(Point position) {
        // Check of position is in the occupied list
        if (isOccupied(position))
            return false;
        if (outOfBounds(position))
            return false;
        return true;
    }

    public boolean isOccupied(Point position) {
        // Check of position is in the occupied list
        for (int i = 0; i < occupied.length; i++) {
            if (occupied[i] == position)
                return true;
        }
        return false;
    }
    public boolean outOfBounds(Point position) {
        return (position.x >= limit.x || position.x < 0 ||
                position.y >= limit.y || position.y < 0) ;
    }

}

public class GridMap extends Plateau {
    GridMap(Point p) {
        super(p);
    }
}