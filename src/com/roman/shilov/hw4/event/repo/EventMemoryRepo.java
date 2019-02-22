package com.roman.shilov.hw4.event.repo;

import com.roman.shilov.hw4.event.Event;

import static  com.roman.shilov.hw4.storage.Storage.events;

public class EventMemoryRepo {
    private int eventIndex = -1;

    public void addEvent(Event event){
        if(eventIndex == events.length - 1){
            Event[] newEvents = new Event[events.length * 2];
            System.arraycopy(events, 0, newEvents, 0, events.length);
            events = newEvents;
        }

        eventIndex++;
        events[eventIndex] = event;
    }

    public Event findEventById(long id){
        Integer eventIndex = findEventIndexById(id);
        if(eventIndex != null){
            return events[eventIndex];
        }
        return null;
    }

    public void deleteEvent(Event event){
        Integer foundIndex = findEventIndexByEntity(event);

        if(foundIndex != null){
            deleteEventByIndex(foundIndex);
            this.eventIndex--;
        }
    }

    public void deleteEvent(Long id){
        Integer foundIndex = findEventIndexById(id);

        if(foundIndex != null){
            deleteEventByIndex(foundIndex);
        }
    }

    private void deleteEventByIndex(int index){
        Event[] newEvents = new Event[events.length];
        System.arraycopy(events, 0, newEvents, 0, index-1);
        System.arraycopy(events, index, newEvents, index-1, events.length - index);
        events = newEvents;
        eventIndex--;
    }

    private Integer findEventIndexByEntity(Event event){
        for (int i = 0; i < events.length; i++) {
            if(events[i].equals(event)){
                return i;
            }
        }
        return null;
    }

    private Integer findEventIndexById(Long id){
        for (int i = 0; i < events.length; i++) {
            if(events[i].getId().equals(id)){
                return i;
            }
        }
        return null;
    }

    public void printEvents(){
        for(Event event : events){
            System.out.println(event);
        }
    }
}
