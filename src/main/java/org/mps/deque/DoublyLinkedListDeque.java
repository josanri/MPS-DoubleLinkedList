package org.mps.deque;

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
            throw new RuntimeException("Empty deque");
        if (first.isLastNode()) {
            first = null;
            last = null;
        } else {
            DequeNode<T> secondNode = first.getNext();
            secondNode.setPrevious(null);
            first = secondNode;
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
            DequeNode<T> penultimateNode = last.getPrevious();
            penultimateNode.setPrevious(null);
            last = penultimateNode;
        }
        size--;
    }

    @Override
    public T first() {
        if (first == null)
            return null;
        else
            return first.getItem();
    }

    @Override
    public T last() {
        if (last == null)
            return null;
        else
            return last.getItem();
    }

    @Override
    public int size() {
        return this.size;
    }

}