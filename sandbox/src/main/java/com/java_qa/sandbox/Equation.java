package com.java_qa.sandbox;

public class Equation {

    private double a;
    private double b;
    private double c;

    private int n;

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;


        if (0 != a) {
            double d = b * b - 4 * a * c;

            if (d > 0) {
                n = 2;
            } else if (0 == d) {
                n = 1;
            } else {
                n = 0;
            }
        } else if (0 != b) {
            n = 1;
        } else if (0 != c) {
            n = 0;
        } else {
            n = -1;
        }


    }

    public int rootNumber() {
        return n;
    }
}
