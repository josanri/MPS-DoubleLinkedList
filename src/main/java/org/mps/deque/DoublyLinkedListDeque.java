package org.mps.deque;

/**
 * The class contains methods a double linked list
 * @author Alba Ruiz Gutiérrez
 * @author José Manuel Sánchez Rico
 */
public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {
    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    @Override
    public void prepend(T value) {
        DequeNode<T> newNode = new DequeNode<>(value, null, first);
        if (first != null)
            first.setPrevious(newNode);
        if (last == null)
            last = newNode;
        first = newNode;
        size++;
    }

    @Override
    public void append(T value) {
        DequeNode<T> newNode = new DequeNode<>(value, last, null);
        if (last != null)
            last.setNext(newNode);
        if (first == null)
            first = newNode;
        last = newNode;
        size++;
    }

    @Override
    public void deleteFirst() {
        if (first == null)
            throw new DoubleEndedQueueException("Empty deque");
        if (first.isLastNode()) {
            first = null;
            last = null;
        } else {
            first = first.getNext();
            first.setPrevious(null);
        }
        size--;
    }

    @Override
    public void deleteLast() {
        if (last == null)
            throw new RuntimeException("Empty deque");
        if (last.isFirstNode()) {
            first = null;
            last = null;
        } else {
            last = last.getPrevious();
            last.setNext(null);
        }
        size--;
    }

    @Override
    public T first() {
        if (first == null)
            throw new DoubleEndedQueueException("No items left");
        return first.getItem();
    }

    @Override
    public T last() {
        if (last == null)
            throw new DoubleEndedQueueException("No items left");
        return last.getItem();
    }

    @Override
    public int size() {
        return this.size;
    }

}