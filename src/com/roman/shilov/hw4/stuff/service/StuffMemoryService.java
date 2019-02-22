package com.roman.shilov.hw4.stuff.service;


import com.roman.shilov.hw4.stuff.Stuff;
import com.roman.shilov.hw4.stuff.repo.StuffMemoryRepo;

public class StuffMemoryService {
    private StuffMemoryRepo repo = new StuffMemoryRepo();

    public void addStuff(Stuff Stuff) {
        repo.addStuff(Stuff);
    }

    public Stuff findStuffById(long id) {
        return repo.findStuffById(id);
    }

    public void deleteStuff(Stuff Stuff) {
        repo.deleteStuff(Stuff);
    }

    public void deleteStuff(Long id) {
        repo.deleteStuff(id);
    }

    public void printStuff() {
        repo.printStuff();
    }
}
