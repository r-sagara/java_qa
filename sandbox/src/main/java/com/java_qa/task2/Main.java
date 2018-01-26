package com.java_qa.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Point p1 = new Point();
        Point p2 = new Point();

        System.out.print("Enter position (x and y) of the first point: ");
        p1.setX(in.nextDouble());
        p1.setY(in.nextDouble());
        System.out.println();

        System.out.print("Enter position (x and y) of the second point: ");
        p2.setX(in.nextDouble());
        p2.setY(in.nextDouble());
        System.out.println();

        System.out.println("The distance between there points is: " + Point.distance(p1, p2));
    }
}
