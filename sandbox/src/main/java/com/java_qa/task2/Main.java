package com.java_qa.task2;

import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {


        Point p1 = new Point(keyboard("x of p1"),keyboard("y of p1"));
        Point p2 = new Point(keyboard("x of p2"),keyboard("y of p2"));

        System.out.println("The distance between these points is: " + p1.distance(p2));
        System.out.println("The distance between these points is: " + distance(p1, p2));
    }

    public static double distance(Point p1, Point p2) {
        return sqrt(pow((p2.x - p1.x),2) + pow((p2.y - p1.y),2));
    }

    public static double keyboard(String string) {
        System.out.print("Enter position of the " + string + " point: ");
        Scanner in = new Scanner(System.in);
        return in.nextDouble();
    }
}
