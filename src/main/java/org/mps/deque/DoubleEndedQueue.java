package org.mps.deque;

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
    // (Estas operaciones se incluirán más adelante para ser realizadas en la segunda
    // sesión de laboratorio de esta práctica.)
}
