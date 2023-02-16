package com.techreturners;

import java.awt.Point;


abstract class ControlRoom {
    MarsVehicle[] rovers = new Rover[10];
    Plateau grid;

    ControlRoom(Point p) {
        this.grid = new GridMap(p);
    }

    abstract boolean AddVehicle(Rover r, Point position);
}

public class MissionControl extends ControlRoom{

    MissionControl(Point p) {
        super(p);
    }
    public boolean AddVehicle(Rover r, Point position){
        // Check position free.
        if (grid.isOccupied(position))
            return false;
        // else
        //rovers.insert(r); xxx
        return true;
    }


}