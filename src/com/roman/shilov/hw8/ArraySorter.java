package com.roman.shilov.hw8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraySorter {

    public static String[] sort(String[] unsortedArr){
        String[] sortedArr = new String[unsortedArr.length];
        List<String> stringList = new ArrayList<>(unsortedArr.length);
        stringList = Arrays.asList(unsortedArr);
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.compareTo(o2) > 0){
                    return 1;
                }else if(o1.equals(o2)) {
                    return 0;
                }else {
                    return -1;
                }
            }
        };
        stringList.sort(comp);

        for(int i = 0; i < stringList.size(); i++){
            sortedArr[i] = stringList.get(i);
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        String[] strings = {"c", "a", "b", "C", "B", "A"};
        System.out.println(Arrays.toString(ArraySorter.sort(strings)));
    }
}
