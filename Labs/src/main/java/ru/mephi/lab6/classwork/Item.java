package ru.mephi.lab6.classwork;

import java.io.Serializable;


public class Item implements Serializable {
    private int id;
    private String description;
    private double cost;

    public Item(int id, String description, double cost) {
        this.cost = cost;
        this.description = description;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    public Item() {
    }
}
