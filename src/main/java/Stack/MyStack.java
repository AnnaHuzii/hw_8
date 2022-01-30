package Stack;

import java.util.*;

public class MyStack<E> implements Stack<E> {
    private static final int DEFAULT_CAPACITY = 64;

    private ArrayList<E> data;

    private int mySize;

    @Override
    public Iterator<E> iterator() {
        return null;
    }



    private enum Action {
        GET_AND_REMOVE,
        GET_NO_REMOVE
    }

    public MyStack(final int initialCapacity) {
        data = new ArrayList<>(initialCapacity);
    }

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public E push(E item) {
        data.add(item);
        mySize++;
        return item;
    }
    @Override
    public E peek() {
        return getTrailingElement(Action.GET_NO_REMOVE);
    }

    @Override
    public E pop() {
        mySize--;
        return getTrailingElement(Action.GET_AND_REMOVE);
    }

    @Override
    public boolean empty() {
        return mySize == 0;
    }

    @Override
    public int size() {
        return mySize;
    }

    @Override
    public void clear() {
        mySize = 0;
    }

    @Override
    public E remove(E index) {
        E curValue = index;
        if (curValue == null)  {
            throw new NoSuchElementException();
        }
        return curValue;
    }

    @Override
    public int search(Object o) {
        int distance = data.lastIndexOf(o);

        if (distance > -1)
            distance = data.size() - distance;

        return distance;
    }

    @Override
    public String toString() {
       return Arrays.toString(data.toArray());
    }


    private E getTrailingElement(Action behaviourType) {
        if (empty()) {
            throw new NoSuchElementException();
        }
        E item;
        if (behaviourType == Action.GET_NO_REMOVE) {
            item = data.get(size() - 1);

        } else{
            item = data.remove(size());
    }
        return item;
    }

}