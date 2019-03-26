package com.roman.shilov.hw8;

import java.util.Arrays;

public class ArraySorter {
    public static String[] sort(String[] arr){
        sort(arr, new String[arr.length], 0, arr.length-1);
        return arr;
    }


    public static void sort(String[] array, String[] tmp, int leftStart, int rightEnd){
        if(leftStart >= rightEnd){
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        sort(array, tmp, leftStart, middle);
        sort(array, tmp, middle + 1, rightEnd);
        merge(array, tmp, leftStart, rightEnd);
    }

    private static void merge(String[] array, String[] tmp, int leftStart, int rightEnd){
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd){
            if(array[left].compareTo(array[right]) <= 0){
                tmp[index] = array[left];
                left++;
            }else{
                tmp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, tmp, index, leftEnd - left + 1);
        System.arraycopy(array, right, tmp, index, rightEnd - right + 1);
        System.arraycopy(tmp, leftStart, array, leftStart, size);
    }


    public static void main(String[] args) {
        String[] strings = {"c", "a", "b", "C", "B", "A"};
        System.out.println(Arrays.toString(ArraySorter.sort(strings)));
    }
}
