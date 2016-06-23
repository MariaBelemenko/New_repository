package com.epam.TestNG.pageFactory.logicForCustomAnnotation;

/**
 * Created by Mariya_Belemenko on 6/23/2016.
 */
public class Logic {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.epam.TestNG.pageFactory.steps.Steps");
        String name = c1.getName();
        System.out.println(name);
    }
}
