package com.java_qa.sandbox;

public interface TestInterface {
    void increment(int x);
}

class Getter {
    public static void main(String[] args) {
        int num = 10;

        TestInterface myLambda = System.out::print;
        myLambda.increment(5);
    }
}
