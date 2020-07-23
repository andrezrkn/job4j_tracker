package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Andre", "Tsarukyan", "1234567890", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Andre");
        assertThat(persons.get(0).getSurname(), is("Tsarukyan"));
    }
}