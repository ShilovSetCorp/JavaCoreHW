package com.roman.shilov.hw16.travelagency.common.solutions.utils;


public final class ArrayUtils {

    private ArrayUtils(){
    }

    public static void removeElement(Object[] arr, int index){
        System.arraycopy(arr, index+1, arr, index, arr.length - 1 - index);
    }
}
