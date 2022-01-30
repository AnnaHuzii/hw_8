package Stack;

public class MyStackTests {

    public static void main(String[] args) {

        Cat barsik = new Cat("Барсик");
        Cat murzik = new Cat("Мурзик");
        Cat vaska = new Cat("Васька");
        Cat ship = new Cat("Шып");

        MyStack<Cat> pipe = new MyStack<Cat>();

        pipe.push(barsik);
        pipe.push(murzik);
        pipe.push(vaska);
        pipe.push(ship);

        System.out.println(("Коты которых запихнули в трубу:  " + pipe));
        System.out.println("Всего котов запихнули в трубу? - " + pipe.size());
        System.out.println("_______________________");

        System.out.println("Заглянем кто последний в трубе? Это - " + pipe.peek());
        System.out.println("Уйдёт первым из трубы " + pipe.pop());
        System.out.println("Сколько котов осталось в трубе? - " + pipe.size());
        System.out.println("_______________________");

        System.out.println("Заглянем кто терь последний в трубе? Это - " + pipe.peek());
        System.out.println("Уйдёт теперь из трубы " + pipe.pop());
        System.out.println("Сколько котов осталось в трубе? - " + pipe.size());
        System.out.println("_______________________");

        System.out.println("Кто остался в трубе:" + pipe);
        System.out.println("_______________________");

        System.out.println("Найдем в трубе " + pipe.remove(barsik) + " он " + pipe.search(barsik) + " на выход");
        System.out.println("_______________________");

        System.out.println("Вытащим всех котов");
        pipe.clear();

        System.out.println("Сколько котов осталось в трубе? - " + pipe.size());
        System.out.println("Заглянем в трубу. Никого? " + pipe.empty());

    }
}