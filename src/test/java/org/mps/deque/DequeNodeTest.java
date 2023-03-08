package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {
    @DisplayName("A single node")
    @Nested
    class SingleNodeTest {
        static DequeNode<Integer> singleNode;
        @Test
        @BeforeAll
        static void setUp() {
            singleNode = new DequeNode<>(0, null, null);
        }

        @Test
        @DisplayName("is last")
        void emptyNodeIsLast () {
            assertTrue(singleNode.isLastNode());
        }

        @Test
        @DisplayName("is first")
        void emptyNodeIsFirst () {
            assertTrue(singleNode.isFirstNode());
        }
    }

    @DisplayName("Two nodes linked")
    @Nested
    class TwoNodesTest {
        static DequeNode<Integer> firstNode;
        static DequeNode<Integer> secondNode;
        @Test
        @BeforeAll
        static void setUp() {
            firstNode = new DequeNode<>(0, null, null);
            secondNode = new DequeNode<>(1, firstNode, null);
            firstNode.setNext(secondNode);
        }

        @Test
        @DisplayName("is last")
        void secondNodeIsLast () {
            assertTrue(secondNode.isLastNode());
        }

        @Test
        @DisplayName("is first")
        void emptyNodeIsFirst () {
            assertTrue(firstNode.isFirstNode());
        }
    }
}