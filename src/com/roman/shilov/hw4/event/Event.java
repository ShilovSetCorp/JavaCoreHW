package com.roman.shilov.hw4.event;

import com.roman.shilov.hw4.stuff.Stuff;

import java.util.Arrays;

public class Event {
    private Long id;
    private String name;
    private String location;
    private String typeOfEvent;
    private Stuff[] stuff;

    public Event(){}

    public Event(String name, String typeOfEvent) {
        this.name = name;
        this.typeOfEvent = typeOfEvent;
    }

    public Event(String name, String location, String typeOfEvent) {
        this.name = name;
        this.location = location;
        this.typeOfEvent = typeOfEvent;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public Stuff[] getStuff() {
        return stuff;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public void setStuff(Stuff[] stuff) {
        this.stuff = stuff;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", typeOfEvent='" + typeOfEvent + '\'' +
                ", stuff=" + Arrays.toString(stuff) +
                '}';
    }

    private String getStuffAsString(){
        StringBuilder sb = new StringBuilder();
        for(Stuff stuf : stuff){
            sb.append(stuf.toString()).append("\n");
        }

        return sb.toString();
    }
}
