package com.java_qa.task2;

import static java.lang.Math.*;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {
        return sqrt(pow((p2.getX() - p1.getX()),2) + pow((p2.getY() - p1.getY()),2));
    }
}
