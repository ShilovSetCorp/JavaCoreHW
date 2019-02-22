package com.roman.shilov.hw4.event.service;

import com.roman.shilov.hw4.event.Event;
import com.roman.shilov.hw4.event.repo.EventMemoryRepo;
import com.roman.shilov.hw4.stuff.Stuff;
import com.roman.shilov.hw4.stuff.repo.StuffMemoryRepo;

public class EventMemoryService {
    private EventMemoryRepo eventRepo = new EventMemoryRepo();
    private StuffMemoryRepo stuffRepo = new StuffMemoryRepo();

    public void addEvent(Event event) {
        eventRepo.addEvent(event);

        if (event.getStuff() != null){
           for (Stuff stuff : event.getStuff()){
               stuffRepo.addStuff(stuff);
           }
        }
    }

    public Event findEventById(long id) {
        return eventRepo.findEventById(id);
    }

    public void deleteEvent(Event event) {
        eventRepo.deleteEvent(event);
    }

    public void deleteEvent(Long id) {
        eventRepo.deleteEvent(id);
    }

    public void printEvents() {
        eventRepo.printEvents();
    }
}
