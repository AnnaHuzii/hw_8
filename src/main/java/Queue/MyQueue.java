package Queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyQueue<E> implements Queue<E> {
    private static final int MAX_LENGTH = 10;
    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyQueue() {
        this(MAX_LENGTH);
    }

    public MyQueue(int length) {
        this(length, MAX_LENGTH);
    }

    public MyQueue(int length, float loadFactor) {
        if (length <= 0) {
            throw new IllegalArgumentException("Длина инициализации должна быть больше 0");
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Коэффициент нагрузки должен быть больше 0");
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(E value) {
        offerFirst(value);
    }

    @Override
    public E get() {
        Node<E> element = this.first;
        if (element == null) {
            throw new NoSuchElementException();
        }
        return element.value;
    }

      @Override
    public boolean offerFirst(E value) {
        boolean result;
        if (result = value != null && this.size < MAX_LENGTH) {
            Node<E> newNode = new Node<>(null, null, value);
            if (this.first != null) {
                newNode.next = this.first;
                this.first = this.first.prev = newNode;
                if (this.last == null) {
                    this.last = first.next;
                }
            } else {
                this.first = newNode;
            }
            this.size++;
        }
        return result;
    }

    @Override
    public boolean offerLast(E value) {
        boolean result;
        if (result = value != null && this.size < MAX_LENGTH) {
            Node<E> newNode = new Node<>(null, null, value);
            if (this.last != null) {
                newNode.prev = this.last;
                this.last = last.next = newNode;
                this.size++;
            } else {
                if (this.first == null) {
                    result = offerFirst(value);
                } else {
                    this.last = this.first.next = newNode;
                    this.last.prev = this.first;
                    this.size++;
                }
            }
        }
        return result;
    }
    @Override
    public E peek() {
        Node<E> element = this.first;
        return element != null ? element.value : null;
    }

    @Override
    public E pollFirst() {
        E value = null;
        if (this.first != null) {
            value = first.value;
            this.first = this.first.next;
            if (this.first != null) {
                first.prev = null;
            }
            this.size--;
        }
        return value;
    }

    @Override
    public E pollLast() {
        E value = null;
        if (this.last != null) {
            value = this.last.value;
            if (this.last.prev != this.first) {
                this.last = this.last.prev;
                this.last.next = null;
            } else {
                this.last = null;
            }
            this.size--;
        } else {
            if (this.first != null) {
                value = pollFirst();
            }
        }
        return value;
    }


    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public E remove() {
        E value = pollFirst();
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        int index = 0;
        for (Node<E> x = this.first; x != null; x = x.next) {
            array[index++] = x.value;
        }
        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorDeque<>(this.first);
    }

    private class Node<E> {
        private Node<E> prev;
        private Node<E> next;
        E value;

        public Node(Node<E> prev, Node<E> next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    private class IteratorDeque<E> implements Iterator<E> {
        private Node<E> first;

        public IteratorDeque(Node<E> first) {
            this.first = first;
        }

        @Override
        public boolean hasNext() {
            return this.first != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E value = this.first.value;
            this.first = first.next;
            return value;
        }
    }



}


