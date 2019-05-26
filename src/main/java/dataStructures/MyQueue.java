package main.java.dataStructures;

/**
 * Created by Влад on 23.12.2018.
 */
public class MyQueue<E> {

    private MyArrayList<E> elementData;

    public MyQueue() {
        elementData = new MyArrayList<E>();
    }

    public void add(E e) {
        elementData.add(e);
    }

    public E peek() {
        if (isEmpty())
            return null;
        return elementData.get(0);
    }

    public E poll() {
        E e = peek();
        elementData.remove(0);
        return e;
    }

    public boolean isEmpty() {
        return elementData.isEmpty();
    }
}
