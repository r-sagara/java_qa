package com.java_qa.task2;

import java.util.Scanner;

import static java.lang.Math.*;

public class Point {
    Scanner in = new Scanner(System.in);

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

    public double distance(Point point) {
        return sqrt(pow((point.getX() - this.getX()),2) + pow((point.getY() - this.getY()),2));
    }

    public void enterPosition(String point) {
        System.out.print("Enter position (x and y) of the " + point + " point: ");
        this.setX(in.nextDouble());
        this.setY(in.nextDouble());
        System.out.println();
    }
}
