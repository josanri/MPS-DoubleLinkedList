package org.mps.deque;

import java.util.Comparator;
import java.util.Objects;

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
            throw new DoubleEndedQueueException("Empty deque");
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

    public T get(int index) {
        if (size <= index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        DequeNode<T> iteratorNode = first;
        for (int i = 0; i < index; i++) {
            iteratorNode = iteratorNode.getNext();
        }
        return (iteratorNode.getItem());
    }

    public boolean contains(T value) {
        DequeNode<T> iteratorNode = first;
        boolean found = false;
        while (iteratorNode != null && !found) {
            found = Objects.equals(iteratorNode.getItem(), value);
            iteratorNode = iteratorNode.getNext();
        }
        return (found);
    }

    public void remove(T value) {
        if(size == 0){
            throw new DoubleEndedQueueException("Can't remove from an empty deque");
        }
        DequeNode<T> iteratorNode = first;
        boolean found = false;
        while (iteratorNode != null) {
            found = Objects.equals(iteratorNode.getItem(), value);
            if (found)
                break;
            iteratorNode = iteratorNode.getNext();
        }
        if (found) {
            if (iteratorNode != first)
                iteratorNode.getPrevious().setPrevious(iteratorNode.getNext());
            if (iteratorNode != last)
                iteratorNode.getNext().setPrevious(iteratorNode.getPrevious());
            if (iteratorNode == first)
                first = iteratorNode.getNext();
            if (iteratorNode == last)
                last = iteratorNode.getPrevious();
            size--;
        }
    }

    public void sort(Comparator<? super T> comparator){
        if (size == 0) {
            throw new DoubleEndedQueueException("Empty list");
        }
        while (!isSorted(comparator)) {
            DequeNode<T> iteratorNode = first;
            while (iteratorNode != null && iteratorNode.getNext() != null) {
                if (!isSortedNodes(iteratorNode, iteratorNode.getNext(), comparator))
                    swapNodesValues(iteratorNode, iteratorNode);
                iteratorNode = iteratorNode.getNext();

            }
        }
    }

    private boolean isSortedNodes(DequeNode<T> iteratorNode, DequeNode<T> next, Comparator<? super T> comparator) {
        if (iteratorNode.getItem() == null)
            return (true);
        else if (next.getItem() == null)
            return (false);
        else
            return (comparator.compare(iteratorNode.getPrevious().getItem(),
                iteratorNode.getItem()) <= 0);

    }

    private void swapNodesValues(DequeNode<T> first, DequeNode<T> next) {
        T aux = first.getItem();
        first.setItem(next.getItem());
        next.setItem(aux);
    }

    private boolean isSorted(Comparator<? super T> comparator) {
        if (size <= 1)
            return  true;
        DequeNode<T> iteratorNode = first.getNext();
        while (iteratorNode != null) {
            if (comparator.compare(iteratorNode.getPrevious().getItem(),
                    iteratorNode.getItem()) > 0) {
                return (false);
            }
            iteratorNode = iteratorNode.getNext();
        }
        return  (true);
    }
}