package org.example;

import org.example.utils.MethodUtils;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        MethodUtils methodUtils = new MethodUtils();
        System.out.println(methodUtils.add(2, 3));
    }
}