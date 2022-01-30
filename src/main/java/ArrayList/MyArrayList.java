package ArrayList;

import java.util.StringJoiner;

public class MyArrayList<T> {
    private static final int INIT_SIZE = 8;
    private final int CUT_RATE = 2;
    private Object[] data;
    private int mySize;

    public MyArrayList() {
        data = new Object[INIT_SIZE];
    }

    public void add(T value) {
        resizeIfNeed();

        data[mySize] = value;
        mySize++;
    }

    private void resizeIfNeed() {
        if (mySize == data.length) {
            System.out.println("Resize happened, index: " + mySize + ", data.length: " + data.length);
            int newSize = data.length * 2;
            Object[] newData = new Object[newSize];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    public T get(int i) {

        return (T) data[i];
    }

    public int size() {

        return mySize;
    }

    public T remove(int index) {

        T elements = (T)  data[index];

        fastRemove(data, index);

        return elements;
    }

    private void fastRemove(Object[] data, int index) {

        for (int i = index; i < mySize; i++)
            data[i] = data[i + 1];
        data[mySize] = null;
        mySize--;
        if ((mySize - 1) > index)
            resize(data.length / 2);
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(data, 0, newArray, 0, mySize);
        data = newArray;
    }

    public boolean isEmpty() {
        return mySize == 0;
    }

    public void clear() {

        for (int to = mySize, i = mySize = 0; i < to; i++)
            data[i] = null;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < mySize; i++) {
            result.add(data[i].toString());
        }

        return "[" + result + "]";
    }
}
