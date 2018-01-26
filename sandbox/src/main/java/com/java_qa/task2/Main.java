package com.java_qa.task2;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {

        Point p1 = new Point();
        Point p2 = new Point();

        p1.enterPosition("p1");
        p2.enterPosition("p2");

        System.out.println("The distance between these points is: " + p1.distance(p2));
        System.out.println("The distance between these points is: " + distance(p1, p2));
    }

    public static double distance(Point p1, Point p2) {
        return sqrt(pow((p2.getX() - p1.getX()),2) + pow((p2.getY() - p1.getY()),2));
    }
}
