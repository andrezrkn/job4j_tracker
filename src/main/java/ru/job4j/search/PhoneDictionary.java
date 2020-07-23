package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
            if (persons.get(0).getSurname().contains(key) ||
                    persons.get(0).getName().contains(key) ||
                    persons.get(0).getPhone().contains(key) ||
                    persons.get(0).getAddress().contains(key)) {
                result = persons;
        }
        return result;
    }
}
