package com.techrunners;

public interface ControlRoom {
    void TurnLeft();
    void TurnRight();
    boolean MoveForward(int count);
    void Stop();
}

abstract class MissionControl implements ControlRoom {
    MarsVehicle[]  rovers;
}
