package com.java_qa.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {

        List<String> languages = new ArrayList<String>();

        List<String> lang = Arrays.asList("Java","C#","Python","PHP");
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");
        languages.add("PHP");

        for (String l : languages) {
            System.out.println("I want to learn " + l);
        }

        for (int i = 0; i < lang.size(); i++) {
            System.out.println("I want to learn" + lang.get(i));
        }
    }
}
