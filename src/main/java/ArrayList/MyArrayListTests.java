package ArrayList;


public class MyArrayListTests {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Igor");
        list.add("Ivan");
        list.add("Vasya");
        list.add("Sergey");

        System.out.println("В квесте участвовало - " + list.size() + ": " + list);
        System.out.println("_______________________");

        System.out.println("Первую комнату прошли: " + list.get(0) + ", " + list.get(2) + ", " + list.get(3));
        System.out.println("А " + list.remove(1) + " выбыл");
        System.out.println("Осталось " + list.size() + " учасника");
        System.out.println("_______________________");

        System.out.println("Потом выбыл " + list.remove(0));
        System.out.println("Осталось " + list.size() + " учасника - " + list);
        System.out.println("_______________________");

        list.clear();
        System.out.println("В останней комнате выбыли все");

        if (list.isEmpty()) {
            System.out.println("Есть ещё учасники квеста? - Нет");
        }else {
            System.out.println("Есть ещё учасники квеста? - Да");
        }

        System.out.println("Осталось " + list.size() + " учасника - " + list);
    }

            {
    }
}
