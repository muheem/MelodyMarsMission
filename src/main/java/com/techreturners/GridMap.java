package com.techreturners;

import java.awt.Point;



abstract class Plateau {
    Point limit;
    Point[]  occupied = new Point[10];

    Plateau(Point p) {
        this.limit = p;
    }
    Boolean IsValidMove() {
        return false;
    };

    public boolean isOccupied(Point position) {
        // Check of position is in the occupied list
        for (int i = 0; i < occupied.length; i++) {
            if (occupied[i] == position)
                return true;
        }
        return false;
    }

}

public class GridMap extends Plateau {
    GridMap(Point p) {
        super(p);
    }

    public Boolean IsValidMove() {
        return false;
    }

    public Boolean IsOccupied(Point p) {
        return false;
    }


}