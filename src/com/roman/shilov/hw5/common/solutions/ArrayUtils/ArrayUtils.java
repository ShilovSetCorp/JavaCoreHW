package com.roman.shilov.hw5.common.solutions.ArrayUtils;

import java.util.ArrayList;

public final class ArrayUtils {

    private ArrayUtils(){
    }

    public static void removeElement(Object[] arr, int index){
        System.arraycopy(arr, index+1, arr, index, arr.length - 1 - index);
    }
}
