package com.java_qa.task2;

import static java.lang.Math.*;

public class Point {


    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        return sqrt(pow((point.x - this.x),2) + pow((point.y - this.y),2));
    }
}
