package org.mps.deque;

/**
 * The interface defines double ended queue methods
 * @author Antonio Jesús Nebro Urbaneja
 */
public interface DoubleEndedQueue<T> {

    // Basic operations

    void prepend(T value);
    void append(T value);

    void deleteFirst();
    void deleteLast();

    T first();
    T last();

    int size();

    // Complex operations
}
