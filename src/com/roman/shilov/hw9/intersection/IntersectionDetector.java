package com.roman.shilov.hw9.intersection;

import java.util.LinkedList;
import java.util.List;

public class IntersectionDetector {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        List<String> b = new LinkedList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        a.add("D");
        a.add("E");

        b.add("C");
        b.add("D");
        b.add("E");
        b.add("F");
        b.add("G");

        System.out.println("------Intersection with cycle----------------");
        System.out.println(intersect(a, b));

        System.out.println("------Intersection with retainAll------------");
        System.out.println(intersectRetainAll(a, b));
    }

    private static List<String> intersect(List<String> a, List<String> b){
        List<String> interList = new LinkedList<>();
        for(String s : a) {
            if(b.contains(s)) {
                interList.add(s);
            }
        }
        return interList;
    }

    private static List<String> intersectRetainAll(List<String> a, List<String> b){
        a.retainAll(b);
        return a;
    }
}


