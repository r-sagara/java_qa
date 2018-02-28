package com.java_qa.sandbox;

public interface MyIntNumPredicate<T> {
    boolean test(T mv, int n);
}

class MyIntNum {
    private int v;

    MyIntNum(int x) { v = x; }

    boolean getNum(int n) { return true; }

    boolean isFactor(int n) {
        return (v % n) == 0;
    }
}

class MethodRefDemo {
    public static void main(String[] args) {
        boolean result;

        MyIntNum myNum = new MyIntNum(12);

        MyIntNumPredicate<MyIntNum> inp = MyIntNum::isFactor;
        if(inp.test(myNum, 4)) System.out.println("lol");
        else System.out.println("not lol");
    }
}