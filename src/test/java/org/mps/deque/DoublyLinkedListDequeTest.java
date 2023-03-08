package org.mps.deque;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class contains methods for testing linked list in three different cases:
 * Empty list
 * One node list
 * Two node list
 * On every kind of list it is tested the size, insertions and deletions
 * checking if the consistency is kept between nodes.
 * @author Alba Ruiz Gutiérrez
 * @author José Manuel Sánchez Rico
 */
class DoublyLinkedListDequeTest {

    @Nested
    @DisplayName("On an empty double linked list")
    class EmptyDoubleLinkedList {
        static DoublyLinkedListDeque<Integer> emptyDoubleLinkedList;
        @BeforeAll
        static void setUp() {
            emptyDoubleLinkedList = new DoublyLinkedListDeque<>();
        }

        @DisplayName("the size is zero")
        @Test
        void hasSizeZero() {
            int expectedValue = 0;
            int actualValue = emptyDoubleLinkedList.size();
            assertEquals(expectedValue, actualValue);
        }
    }

    @Nested
    @DisplayName("On a single node, double linked list")
    class SingleNodeDoubleLinkedList {
        static DoublyLinkedListDeque<Integer> singleNodeDoubleLinkedList;
        @BeforeAll
        static void setUp() {
            singleNodeDoubleLinkedList = new DoublyLinkedListDeque<>();
            singleNodeDoubleLinkedList.append(5);
        }

        @DisplayName("the size is one")
        @Test
        void hasSizeZero() {
            int expectedValue = 1;
            int actualValue = singleNodeDoubleLinkedList.size();

            assertEquals(expectedValue, actualValue);
        }
    }
}