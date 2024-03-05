package rvt;

import java.util.ArrayList;

public class Box 
{
    // kg
    private int capacity;

    private ArrayList<Packable> items;

    public Box(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void add(Packable item) {
        items.add(item);
    }

    @Override
    public String toString() {
        double totalWeigth = 0;
        for (Packable item : items) {
            totalWeigth += item.weight();
        }
        return "Box: " + this.items.size() + " items, total weigth " + totalWeigth + " kg";
    }
}