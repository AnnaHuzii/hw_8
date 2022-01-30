package Queue;

import java.util.Iterator;

public class MyQueueTests {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<String>();

        queue.add("Animals");
        queue.add("Reptiles");
        queue.add("Plants");
        queue.add("Land");
        queue.add("Water");
        queue.add("Earth");

        System.out.println("Вывод всех добавленых елементов");
        System.out.println(queue);
        System.out.println("Количество всех добавленых елементов - " + queue.size());

        System.out.println("_______________________");
        System.out.println("Вывод коллекции списком");
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println("Value: " + iterator.next());
        }

        System.out.println("_______________________");

        System.out.println("Первый элемент в очереди - " + queue.peek());

        System.out.println("_______________________");

        System.out.println("Удаляем элемент из конца очереди - " + queue.pollLast());
        System.out.println(queue);
        System.out.println("_______________________");

        System.out.println("Удалить с колекции - " + queue.remove());
        System.out.println("_______________________");

        System.out.println("Количество елементов после удаления - " + queue.size());
        System.out.println("_______________________");

        System.out.println("Добавляем 1 элемента в начало очереди");
        queue.offerFirst("Earth");
        System.out.println(queue);

        System.out.println("Добавляем 2 элемента в конец очереди");
        queue.offerLast("Animals");
        queue.offerLast("Human");
        System.out.println(queue);

        System.out.println("Количество елементов после добавления - " +queue.size());
        System.out.println("_______________________");

        System.out.println("Вывод полученой коллекции списком");
        String town;
        while ((town = queue.pollFirst()) != null) {
            System.out.println(town);
        }
        System.out.println("_______________________");
        queue.clear();
        System.out.println("Количество елементов после очистки коллекции - " + queue.size());
    }
}
