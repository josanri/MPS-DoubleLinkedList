package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class contains methods for testing double linked node in three different cases:
 * One node
 * Two node
 * On every kind of node it is tested the previous and next as well as boolean methods
 * that check so such as isTerminal and isNotTerminal.
 * @author Alba Ruiz Gutiérrez
 * @author José Manuel Sánchez Rico
 */
class DequeNodeTest {
    @DisplayName("On a single node")
    @Nested
    class SingleNodeTest {
        static DequeNode<Integer> singleNode;
        @Test
        @BeforeAll
        static void setUp() {
            singleNode = new DequeNode<>(0, null, null);
        }

        @Test
        @DisplayName("the second node is last")
        void emptyNodeIsLast () {
            assertTrue(singleNode.isLastNode());
        }

        @Test
        @DisplayName("the initial node is first")
        void emptyNodeIsFirst () {
            assertTrue(singleNode.isFirstNode());
        }
    }

    @DisplayName("On two nodes linked")
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