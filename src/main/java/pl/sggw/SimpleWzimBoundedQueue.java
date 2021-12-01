package pl.sggw;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SimpleWzimBoundedQueue<E> implements WzimBoundedQueue<E> {
    private E[] arr;
    private int front;
    private int rear;
    private int size;
    private final int maxCapacity;
    // .
    public SimpleWzimBoundedQueue(final int maxCapacity) {
        this.maxCapacity = maxCapacity;
        arr = (E[])new Object[maxCapacity];
        size = 0;
        front = -1;
        rear = -1;
    }

    @Override
    public boolean add(E e) {
        if (size() == maxCapacity)
        {
            throw new IllegalStateException("");
        }
        if (front == -1) {
            front = 0;
        }

        rear += 1;
        arr[rear] = e;
        size++;
        return true;
    }

    @Override
    public boolean offer(E e) {
        if (size() == maxCapacity)
        {
            return false;
        }

        if (front == -1) {
            front = 0;
        }

        rear += 1;
        arr[rear] = e;
        size++;
        return true;
    }

    @Override
    public E remove() throws NoSuchElementException {
        if (size() < 1)
        {
            throw new NoSuchElementException("");
        }

        E x = arr[front];

        if (front >= rear) {
            front = -1;
            rear = -1;
        }

        front = front + 1;
        size--;

        return x;
    }

    @Override
    public E poll() {
        if (size() < 1)
        {
            return null;
        }

        E x = arr[front];

        if (front >= rear) {
            front = -1;
            rear = -1;
        }
        
        front = front + 1;
        size--;

        return x;
    }

    @Override
    public E element() {
        if (size() < 1)
        {
            throw new NoSuchElementException("");
        }
        return arr[front];
    }

    @Override
    public E peek() {
        if (size() < 1)
        {
            return null;
        }
        return arr[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return maxCapacity;
    }
}
