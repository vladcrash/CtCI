package main.java.dataStructures;

import java.util.EmptyStackException;

/**
 * Created by Влад on 23.12.2018.
 */
public class MyStack<E> {

    private MyArrayList<E> elementData;

    public MyStack() {
        elementData = new MyArrayList<E>();
    }

    public void push(E item) {
        elementData.add(item);
    }

    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return elementData.get(elementData.size() - 1);
    }

    public E pop() {
        E e = peek();
        elementData.remove(elementData.size() - 1);
        return e;
    }

    public boolean isEmpty() {
        return elementData.isEmpty();
    }

    public int size() {
        return elementData.size();
    }
}
