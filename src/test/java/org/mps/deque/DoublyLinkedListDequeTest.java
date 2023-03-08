package org.mps.deque;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListDequeTest {

    @Nested
    @DisplayName("An empty double linked list")
    class EmptyDoubleLinkedList {
        static DoublyLinkedListDeque<Integer> emptyDoubleLinkedList;
        @BeforeAll
        static void setUp() {
            emptyDoubleLinkedList = new DoublyLinkedListDeque<>();
        }

        @DisplayName("has size zero")
        @Test
        void hasSizeZero() {
            assertEquals(0, emptyDoubleLinkedList.size());
        }

    }
}