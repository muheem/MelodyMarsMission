package com.techrunners;



public interface MarsVehicle {
    Position currentLocation();
    public boolean MoveTo(Position c);
}

abstract class MarsRover implements MarsVehicle {
    public boolean MoveTo(String directions){
        return false;
    }
}

