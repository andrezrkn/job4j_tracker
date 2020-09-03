package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = t -> t.getAddress().contains(key);
        combine = combine.or(t -> t.getPhone().contains(key)).or(t -> t.getName().contains(key)).
                or(t -> t.getSurname().contains(key)).or(t -> t.getAddress().contains(key));
        ArrayList<Person> result = new ArrayList<>();
        for (Person element : persons) {
            if (combine.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
