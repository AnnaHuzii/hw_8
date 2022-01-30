package HashMap;

import java.util.Set;

public class MyHashMapTests {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();

        hashMap.put(1, "doll");
        hashMap.put(2, "constructor");
        hashMap.put(3, "typewriter");

        System.out.println("Розмер после добавления всех елементов - " + hashMap.size());
        System.out.println("_______________________");
        Set<Integer> keys = hashMap.keySet();

        System.out.println("Вывод всех добавленых елементов");
        for (Integer key : keys) {
            System.out.print(key + ": ");
            System.out.println(hashMap.get(key));
        }
        System.out.println("_______________________");
        System.out.println("Вывод после изменения елемента 1");

        hashMap.replace(1, "robot");
        for (Integer key : keys) {
            System.out.print(key + ": ");
            System.out.println(hashMap.get(key));
        }
        System.out.println("_______________________");

        hashMap.remove(2);
        System.out.println("Розмер без одного елемента - " + hashMap.size());

        hashMap.clear();
        System.out.println("Размер после удаления всех елементов - " + hashMap.size());

    }
}
