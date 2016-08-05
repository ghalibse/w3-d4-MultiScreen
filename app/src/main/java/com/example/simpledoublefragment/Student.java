package com.example.simpledoublefragment;

/**
 * Created by admin on 8/4/2016.
 */

public class Student {

    public String name;
    public long age;
    public double grade;

    @Override
    public String toString() {

        return String.format("%1$-10s %2$-10d", name, age) + String.format("%1$,.2f",grade);
    }
}