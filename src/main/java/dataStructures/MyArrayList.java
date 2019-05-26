package main.java.dataStructures;

/**
 * Created by Влад on 23.12.2018.
 */
public class MyArrayList<E> {

    private E[] elementData;
    private int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialCapacity) {
        elementData = (E[]) new Object[initialCapacity];
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        elementData[size++] = element;
    }

    public void add(int index, E element) {
        checkIndex(index);
        if (index < size)
            move(index);
        elementData[index] = element;
        size++;
    }

    public E get(int index) {
        return elementData[index];
    }

    public E remove(int index) {
        checkIndex(index);
        E element = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = null;
        return element;
    }

    public boolean remove(E element) {
        if (element == null)
            return false;
        for (int i = 0; i < size; i++) {
            if (element.equals(elementData[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > elementData.length - 1)
            throw new IndexOutOfBoundsException("My Exception " + index);
    }

    private void move(int index) {
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= index ; i--) {
            elementData[i + 1] = elementData[i];
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            E[] newArray = (E[]) new Object[elementData.length * 2];
            for (int i = 0; i < elementData.length; i++) {
                newArray[i] = elementData[i];
            }
            elementData = newArray;
        }
    }
}
