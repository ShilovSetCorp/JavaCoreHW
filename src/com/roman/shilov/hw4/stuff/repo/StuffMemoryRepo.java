package com.roman.shilov.hw4.stuff.repo;

import com.roman.shilov.hw4.stuff.Stuff;

import static com.roman.shilov.hw4.storage.Storage.stuff;

public class StuffMemoryRepo {

    private int stuffIndex = -1;

    public void addStuff(Stuff Stuff) {
        if (stuffIndex == stuff.length - 1) {
            Stuff[] newArrstuff = new Stuff[stuff.length * 2];
            System.arraycopy(stuff, 0, newArrstuff, 0, stuff.length);
            stuff = newArrstuff;
        }

        stuffIndex++;
        stuff[stuffIndex] = Stuff;
    }

    public Stuff findStuffById(long id) {
        Integer StuffIndex = findStuffIndexById(id);
        if (StuffIndex != null) {
            return stuff[StuffIndex];
        }

        return null;
    }

    public void deleteStuff(Stuff Stuff) {
        Integer foundIndex = findStuffIndexByEntity(Stuff);

        if (foundIndex != null) {
            deleteStuffByIndex(foundIndex);
            this.stuffIndex--;
        }
    }

    public void deleteStuff(Long id) {
        Integer StuffIndex = findStuffIndexById(id);

        if (StuffIndex != null) {
            deleteStuffByIndex(StuffIndex);
        }
    }

    private void deleteStuffByIndex(int index) {
        Stuff[] newArrstuff = new Stuff[stuff.length];
        System.arraycopy(stuff, 0, newArrstuff, 0, index - 1);
        System.arraycopy(stuff, index, newArrstuff, index - 1, stuff.length - index);
        stuff = newArrstuff;
        stuffIndex--;
    }

    public void printStuff() {
        for (Stuff Stuff : stuff) {
            System.out.println(Stuff);
        }
    }

    private Integer findStuffIndexByEntity(Stuff Stuff) {
        for (int i = 0; i < stuff.length; i++) {
            if (stuff[i].equals(Stuff)) {
                return i;
            }
        }

        return null;
    }

    private Integer findStuffIndexById(Long StuffId) {
        for (int i = 0; i < stuff.length; i++) {
            if (stuff[i].getId().equals(StuffId)) {
                return i;
            }
        }
        return null;
    }

}
