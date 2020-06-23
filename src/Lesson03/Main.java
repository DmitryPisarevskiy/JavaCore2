package Lesson03;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // 1 часть. Массив слов с подсчетом количества каждого
        String[] stringArray={"Барсик","Мурзик","Мурка","Барсик","Кеша","Евгеша","Мурка","Барсик","Васька","Васька","Мурка","Барсик","Малыш","Кеша","Леопольд","Том","Барсик","Васька","Мурзик","Мурзик"};
        System.out.print("Список имен всех кошек: ");
        HashMap<String, Integer> cats = new HashMap<>();
        int num;
        for (String s : stringArray) {
            System.out.print(s + ", ");
            num=cats.getOrDefault(s,0);
            cats.put(s,num+1);
        }
        System.out.println("\n");
        for (String s : cats.keySet()) {
            System.out.printf("Имя %s встретилось %d раз\n",s, cats.get(s));
        }
        System.out.println();

        // 2 часть. Телефонный справочик
        PhoneBook phoneBook=new PhoneBook();
        phoneBook.add("Иванов",89658745123L);
        phoneBook.add("Петров",89176542145L);
        phoneBook.add("Сидоров",89133355145L);
        phoneBook.add("Иванов",89137356599L);
        phoneBook.print();
        System.out.println("Запрос Козлов - " + phoneBook.get("Козлов"));
    }
}
