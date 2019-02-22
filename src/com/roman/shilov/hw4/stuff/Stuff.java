package com.roman.shilov.hw4.stuff;

public class Stuff {
    private Long id;
    private String name;
    private int weight;
    private boolean outdoor;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setOutdoor(boolean outdoor) {
        this.outdoor = outdoor;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isOutdoor() {
        return outdoor;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", outdoor=" + outdoor +
                '}';
    }
}
