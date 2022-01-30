package LinkedList;

public class MyLinkedList<E> {
    private int mySize = 0;
    private transient Node<E> first; // нужна для задания ссылки предыдущей ноде на следующую вновь созданную ноду.
    private transient Node<E> last; // переменная содержащая ссылку на последнюю созданную ноду.
    private transient Node<E> linkFirst; // постоянно содержит ссылку на первую ноду
    private transient Node<E> linkLast; // постоянно содержит ссылку на самую последнюю созданную ноду


    public void add(E elem) {
        if (mySize == 0) {

            first = new Node<>(first, elem, last);
            linkFirst(first);
        } else {

            Node<E> nextNode = new Node<>(first, elem, null);
            last = nextNode;
            first.setNext(last);
            first = nextNode;
            linkLast(last);
        }
        mySize++;
    }

    public void clear() {
        if (mySize != 0) {
            Node<E> elem = linkFirst;
            Node<E> elem2;
            for (int buff = 0; buff < mySize; buff++) {
                elem2 = elem.getNext();
                elem.prev = null;
                elem.next = null;
                elem.item = null;
                elem = elem2;
            }
            mySize = 0;
            linkFirst = null;
            linkLast = null;

        } else {
            System.out.println("Нет элементов в коллекции");
        }
    }

    public int size() {
        return this.mySize;
    }

    // запоминаем ссылку на первую ноду
    private void linkFirst(Node<E> firstLink) {
        linkFirst = firstLink;
    }

    // запоминаем ссылку на последнюю ноду
    private void linkLast(Node<E> lastLink) {
        linkLast = lastLink;
    }

    @SuppressWarnings({"ConstantConditions"})
    public E get(int index) {
        int buff = mySize;
        Node<E> item = null;
        do {
            if (index < 0) {
                System.out.println("Вы указали отрицательный индекс, так быть не может!");
                break;
            }

            if (buff / 2 >= index) {
                item = linkFirst;
                for (buff = 0; buff != index; buff++) {
                    item = item.getNext();
                }
                return (E) item.getItem().toString();

            }

            if (buff / 2 < index && index <= mySize) {
                item = linkLast;
                for (; buff - 1 != index; buff--) {
                    item = item.getPrev();
                }
                return (E) item.getItem().toString();
            } else {
                System.out.println("Вы вышли за границы коллекции");
            }

        } while (false);

        return (E) item;
    }

    public E remove(int index) {
        Node<E> prevNode;
        Node<E> nextNode;
        E elemets = get(index);
        if (index < mySize && index >= 0) {
            if (index > mySize / 2) {
                if (index != mySize - 1) {
                    Node<E> lastNode = linkLast;
                    for (int buff = mySize; index != (buff - 1); buff--) {
                        lastNode = lastNode.getPrev();
                    }
                    prevNode = lastNode.getPrev();
                    nextNode = lastNode.getNext();
                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                    lastNode.allToNull();
                    mySize--;
                } else {
                    prevNode = linkLast.getPrev();
                    linkLast.allToNull();
                    prevNode.setNext(null);
                    linkLast = prevNode;
                    mySize--;
                }

            } else {
                if (index != 0) {
                    Node<E> firstNode = linkFirst;
                    for (int buff = 0; index != buff; buff++) {
                        firstNode = firstNode.getNext();
                    }
                    prevNode = firstNode.getPrev();
                    nextNode = firstNode.getNext();
                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                    firstNode.allToNull();
                    mySize--;
                } else {
                    if (index != mySize - 1) {
                        nextNode = linkFirst.getNext();
                        nextNode.setPrev(null);
                        linkFirst = nextNode;
                        mySize--;
                    } else {
                        linkFirst.allToNull();
                        mySize--;
                    }
                }

            }
        } else {

            System.out.println("Вы вышли за границу коллекции");

        }

        return elemets;
    }

    private static class Node<E> {

        private E item;
        private Node<E> next;
        private Node<E> prev;

        private Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        private void setNext(Node<E> next) {
            this.next = next;
        }

        //дезинтегратор йопта! Использовать только в особых назначениях!
        private void allToNull() {
            this.item = null;
            this.next = null;
            this.prev = null;
        }

        private void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        private Node<E> getPrev() {
            return prev;
        }

        private Node<E> getNext() {
            return next;
        }

        private E getItem() {
            return item;
        }
    }
}
