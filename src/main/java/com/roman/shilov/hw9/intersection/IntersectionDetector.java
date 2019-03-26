package com.roman.shilov.hw9.intersection;

import java.util.*;

public class IntersectionDetector {
    public static void main(String[] args) {
        List<String> a;
        a = new ArrayList<>();
        List<String> b;
        b = new ArrayList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        a.add("D");
        a.add("D");
        a.add("D");
        a.add("E");

        b.add("C");
        b.add("D");
        b.add("D");
        b.add("E");
        b.add("F");
        b.add("G");

        System.out.println("------Intersection with cycle----------------");
        System.out.println(intersect(a, b));

        System.out.println("------Intersection with retainAll------------");
        System.out.println(intersectRetainAll(a, b));
    }

    private static List<String> intersect(Collection<String> a, Collection<String> b){
        List<String> interList = new ArrayList<>();
        Set<String> setA = new HashSet<>(a);
        Set<String> setB = new HashSet<>(b);
        for(String s : setB) {
            if(setA.contains(s)) {
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


