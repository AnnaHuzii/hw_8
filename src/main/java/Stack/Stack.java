package Stack;

interface Stack<E> extends Iterable<E> {

    //    Добавляем елемент в колекцию.
    E push(E value);

    //   Возвращает первый элемент в очереди.
    E peek();

    //   Возвращает первый элемент в очереди и удаляет его из коллекции.
    E pop();

    //    Очищает коллекциюи
    void clear();

     //     Возвращаем розмер колекции.
    int size();

    //    Возвращает значение true если коллекция пуста.
    boolean empty();

    //    Возвращает значение по индексу
    E remove(E value);

    int search(Object o);
   }
