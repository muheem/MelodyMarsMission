package com.techrunners;


public class Position{
    public int x_value;
    public int y_value;

    Position() {
        x_value = 0;
        y_value = 0;
    }

    int getX() {
        return x_value;
    }

    int getY() {
        return y_value;
    }

    void set(int x, int y) {
        x_value = x;
        y_value = y;
        }
    }


}
