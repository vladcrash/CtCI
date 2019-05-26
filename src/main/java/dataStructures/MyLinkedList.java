package main.java.dataStructures;

/**
 * Created by Влад on 23.12.2018.
 */
public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    class Node<E> {
        E element;
        Node<E> previous;
        Node<E> next;

        public Node() {
        }

        Node (E e) {
            element = e;
        }
    }

    public MyLinkedList() {
        head = new Node<E>();
    }

    public int size(){
        return size;
    }

    public void add(E e) {
        if (head.element == null) {
            head.element = e;
            tail = head;
        } else {
            Node<E> node = new Node<E>(e);
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void add(int index, E e) {
        checkIndex(index);
        Node<E> element = head;
        Node<E> newElement = new Node<E>(e);
        if (index > 0) {
            for (int i = 0; i < index; i++) {
                if (element.next != null) {
                    element = element.next;
                }
            }
        }
        if (index == 0) {
            if (head.element == null) {
                head.element = newElement.element;
            } else {
                head.previous = newElement;
                newElement.next = head;
                head = newElement;
            }
        } else if (element.next == null) {
            element.next = newElement;
            newElement.previous = element;
        } else {
            element.previous.next = newElement;
            element.previous = newElement;
            newElement.next = element;
            newElement.previous = element.previous;
        }
        size++;
    }

    public E get(int index) {
        if (index < 0 || index > size ) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        if (index == 0)
            return node.element;
        else {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }

        return node.element;
    }

    public boolean remove(E e) {
        if (e == null)
            return false;

        Node<E> element = head;
        for (int i = 0; i < size; i++) {
            if (e.equals(element.element)) {
                remove(element);
                size--;
                return true;
            }

            element = element.next;
        }

        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> element = head;
        if (index == 0) {
            head.next.previous = null;
            head = head.next;
        } else {
            for (int i = 0; i < index; i++) {
                element = element.next;
            }
            remove(element);
        }
        size--;
        return element.element;
    }

    private void remove(Node<E> element) {
        if (element.previous == null) {
            element.next.previous = null;
            head = element.next;
        } else if (element.next == null) {
            tail = element.previous;
            element.previous.next = null;
        } else {
            element.previous.next = element.next;
            element.next = element.previous;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size + 1) {
            throw new IndexOutOfBoundsException();
        }
    }
}
