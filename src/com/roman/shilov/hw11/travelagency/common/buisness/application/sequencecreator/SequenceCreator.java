package com.roman.shilov.hw11.travelagency.common.buisness.application.sequencecreator;

public final class SequenceCreator {
    private static long globalId = 0;

    public static Long getNextId(){
        return ++globalId;
    }

}
