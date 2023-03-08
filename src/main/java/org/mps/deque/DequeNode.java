package org.mps.deque;

class DequeNode<T> {

    private T item;
    private DequeNode<T> previous;
    private DequeNode<T> next;

    DequeNode(T item, DequeNode<T> previous, DequeNode<T> next) {
        this.item = item;
        this.previous = previous;
        this.next = next;
    }

    T getItem() { return item; }
    void setItem(T item) { this.item = item;  }

    DequeNode<T> getPrevious() { return previous; }
    void setPrevious(DequeNode<T> previous) { this.previous = previous; }

    DequeNode<T> getNext() { return next; }
    void setNext(DequeNode<T> next) {  this.next = next; }
    boolean isFirstNode() {  return previous == null; }
    boolean isLastNode() {  return next == null; }
    boolean isNotATerminalNode() { return !(isFirstNode() || isLastNode());  }
}
