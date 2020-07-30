package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    //private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public boolean delete(int id) {
        int index = -1;
        index = indexOf(id);
        if (index != -1) {
            items.remove(items.get(index));
           // System.arraycopy(items, index + 1, items, index, size - index);
            //items.set(size - 1, null);
            //items[size - 1] = null;
            size--;
        }
        return index != -1;
    }

    public Item add(Item item) {
        item.setId(ids++);
        //items[size++] = item;
        items.add(size++, item);
        return item;
    }

    public boolean replace(int id, Item item) {
        int index = -1;
        index = indexOf(id);
        if (index != -1) {
            //items[index] = item;
            //items[index].setId(id);
            item.setId(id);
            items.set(index, item);
           //Item i = items.get(index);
           // i.setId(id);
            //items.set(index, i);
        }
        return index != -1;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            //items[index].getId() == id
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        //items[index]
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        //return Arrays.copyOf(items, size);
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> namesKey = new ArrayList<>();
        for (Item element : items) {
            if (element.getName().equals(key)) {
                namesKey.add(element);
            }
        }
        return namesKey;
    }
}