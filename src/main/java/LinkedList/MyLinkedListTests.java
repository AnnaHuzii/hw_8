package LinkedList;

public class MyLinkedListTests {
    public static void main(String[] args) {

        Relatives mother = new Relatives("Мама");
        Relatives father = new Relatives("Отец");
        Relatives brother = new Relatives("Брат");
        Relatives baughterInLaw = new Relatives("Невестка");

        MyLinkedList<Relatives> list = new MyLinkedList<Relatives>();
        list.add(mother);
        list.add(father);
        list.add(brother);

        System.out.println("Родствиники которые приехали в гости:");
        System.out.println(list.get(0) + ", " + list.get(1) + ", " + list.get(2));
        System.out.println("Всего приехало родствиников: " + list.size());
        System.out.println("_______________________");

        list.add(baughterInLaw);
        System.out.println("Потом приехала: " + list.get(3));
        System.out.println("Стало родствиников: " + list.size());
        System.out.println("_______________________");


        System.out.println("Потом " + list.remove(2) + " уехал");
        System.out.println("и " + list.remove(2) + " уехала");
        System.out.println("Всего осталось родствиников: " + list.size());
        System.out.println("_______________________");

        list.clear();
        System.out.println("Потом уехали родители");

       System.out.println("Осталось родствиников: " + list.size());

    }
}