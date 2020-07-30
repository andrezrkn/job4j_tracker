package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> page = new HashMap<>();
        page.put("parsentev@yandex.ru", "Petr Arsentev");
        page.put("vartan.andreevich@gmail.com", "Andre Tsarukyan");
        page.put("vartan.andreevich@yandex.ru", "Andre Tsarukyan");
        for (String element : page.keySet()) {
            String value = page.get(element);
            System.out.println(element + " = " + value);
        }
    }
}
