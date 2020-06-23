package Lesson03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PhoneBook {

    private HashMap<String, HashSet<Long>> phoneBook;
    private final HashSet<Long> emptyHashSet = new HashSet<>();

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String surname, Long phone) {
        if (!phoneBook.containsKey(surname)) {
            phoneBook.put(surname, new HashSet<>());
        }
        phoneBook.get(surname).add(phone);
        System.out.printf("В справочник добавлена запись %s - %d\n", surname, phone);
    }

    public HashSet<Long> get(String surname) {
        return phoneBook.getOrDefault(surname,emptyHashSet);
    }

    public void print() {
        phoneBook.forEach((k, v) -> System.out.println(k + " - " + phoneBook.get(k)));
    }
}
