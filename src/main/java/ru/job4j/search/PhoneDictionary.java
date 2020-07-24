package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person element : persons) {
            if (element.getSurname().contains(key) ||
                    element.getName().contains(key) ||
                    element.getPhone().contains(key) ||
                    element.getAddress().contains(key)) {
                result = persons;
            }
        }
        return result;
    }
}
