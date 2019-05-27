package main.java.tasks;

import main.java.dataStructures.MyArrayList;
import main.java.dataStructures.MyStack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * {4 / 6)
 *
 * Created by Влад on 24.03.2019.
 */
public class ChapterThree {
    /* ------------------------------------------------------------------------------------------------------------- */
    // 3.1

    /* ------------------------------------------------------------------------------------------------------------- */
    // 3.2

    /* ------------------------------------------------------------------------------------------------------------- */
    // 3.3 Stack Of Plates
    // 26.05.2019

    public static class StackOfPlates<E> {
        private final MyArrayList<MyStack<E>> stacks;
        private final int threshold;
        private int currentStack;

        public StackOfPlates(int threshold) {
            stacks = new MyArrayList<>();
            this.threshold = threshold;
            currentStack = 0;
        }

        public void push(E item) {
            MyStack<E> stack = stacks.get(currentStack);
            if (stack == null) {
                stack = new MyStack<>();
                stacks.add(stack);
            }

            if (stack.size() >= threshold) {
                currentStack++;
                stack = new MyStack<>();
                stacks.add(stack);
            }

            stack.push(item);
        }

        public E pop() {
            if (isEmpty())
                throw new EmptyStackException();

            MyStack<E> stack = stacks.get(currentStack);
            E result = null;
            if (stack != null && !stack.isEmpty())
                result = stack.pop();
            if (result == null && currentStack != 0) {
                while (stack != null && stack.isEmpty() && currentStack != 0)
                    stack = stacks.get(--currentStack);
                result = stack.pop();
            }

            return result;
        }

        public E popAt(int index) {
            if (isEmpty())
                throw new EmptyStackException();
            MyStack<E> stack = stacks.get(index);
            E result = null;
            if (stack != null && !stack.isEmpty())
                result = stack.pop();
            if (result == null)
                throw new EmptyStackException();

            return result;
        }

        public E peek() {
            if (isEmpty())
                throw new EmptyStackException();

            MyStack<E> stack = stacks.get(currentStack);
            E result = null;
            if (stack != null && !stack.isEmpty())
                result = stack.peek();
            if (result == null && currentStack != 0) {
                stack = stacks.get(--currentStack);
                result = stack.peek();
            }

            return result;
        }

        public boolean isEmpty() {
            MyStack<E> stack = stacks.get(0);
            return stack == null || stack.isEmpty();
        }
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 3.4 Queue via Stacks
    // 27.05.2019

    public static class MyQueue<E> {
        private Stack<E> in;
        private Stack<E> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void add(E item) {
            moveItems(out, in);
            in.add(item);
        }

        public E remove() {
            moveItems(in, out);
            return out.pop();
        }

        public E peek() {
            moveItems(in, out);
            return out.peek();
        }

        public boolean isEmpty() {
            return out.isEmpty() && in.isEmpty();
        }

        private void moveItems(Stack<E> from, Stack<E> to) {
            while (!from.isEmpty()) {
                to.push(from.pop());
            }
        }
    }
}
