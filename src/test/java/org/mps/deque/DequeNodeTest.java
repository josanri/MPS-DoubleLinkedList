package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class contains methods for testing double linked node in three different cases:
 * One node:
 *  - Is first
 *  - Is last
 *  - Is terminal
 *  - Getter of the item
 * Two nodes:
 *  - First is first
 *  - Last is last
 *  - First is terminal
 *  - Last is terminal
 *  - The previous of the second node is the first node
 *  - The next of the first is the second
 * Three nodes:
 *  - Second node is not terminal
 *  - Third node changes when setter is used
 * @author Alba Ruiz Gutiérrez
 * @author José Manuel Sánchez Rico
 */
class DequeNodeTest {
    @DisplayName("On a single node")
    @Nested
    class SingleNodeTest {
        static DequeNode<Integer> singleNode;
        static Integer firstItem;
        @BeforeAll
        static void setUp() {
            firstItem = 15;
            singleNode = new DequeNode<>(firstItem, null, null);
        }

        @Test
        @DisplayName("the initial node is last")
        void emptyNodeIsLast () {
            assertTrue(singleNode.isLastNode());
        }

        @Test
        @DisplayName("the initial node is first")
        void emptyNodeIsFirst () {
            assertTrue(singleNode.isFirstNode());
        }

        @Test
        @DisplayName("the initial node is terminal")
        void emptyNodeIsTerminal () {
            assertFalse(singleNode.isNotATerminalNode());
        }

        @Test
        @DisplayName("the initial node has its item")
        void emptyNodeGetItem ()
        {
            int expectedValue = firstItem;
            int actualValue = singleNode.getItem();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("the initial node has the item when it is set")
        void emptyNodeGetItemThatIsSet ()
        {
            int newValue = 78;
            DequeNode<Integer> newNode = new DequeNode<>(15, null, null);
            newNode.setItem(newValue);

            int expectedValue = newValue;
            int actualValue = newNode.getItem();

            assertEquals(expectedValue, actualValue);
        }
    }

    @DisplayName("On two nodes linked")
    @Nested
    class TwoNodesTest {
        static DequeNode<Integer> firstNode;
        static DequeNode<Integer> secondNode;
        @BeforeAll
        static void setUp() {
            firstNode = new DequeNode<>(0, null, null);
            secondNode = new DequeNode<>(1, firstNode, null);
            firstNode.setNext(secondNode);
        }

        @Test
        @DisplayName("the second node is last")
        void secondNodeIsLast () {
            assertTrue(secondNode.isLastNode());
        }

        @Test
        @DisplayName("the first node is first")
        void firstNodeIsFirst () {
            assertTrue(firstNode.isFirstNode());
        }

        @Test
        @DisplayName("first node has second node as next node")
        void firstNodeIsLinkedWithSecond () {
            DequeNode<Integer> expectedValue = secondNode;
            DequeNode<Integer> actualValue = firstNode.getNext();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("second node has first node as previous node")
        void secondNodeIsLinkedWithFirst () {
            DequeNode<Integer> expectedValue = firstNode;
            DequeNode<Integer> actualValue = secondNode.getPrevious();

            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("the second node is terminal")
        void firstNodeIsTerminal () {
            assertFalse(firstNode.isNotATerminalNode());
        }

        @Test
        @DisplayName("the second node is terminal")
        void secondNodeIsTerminal () {
            assertFalse(secondNode.isNotATerminalNode());
        }
    }

    @DisplayName("On three nodes linked")
    @Nested
    class ThreeNodeTest {
        static DequeNode<Integer> firstNode;
        static DequeNode<Integer> secondNode;
        static DequeNode<Integer> thirdNode;
        @BeforeAll
        static void setUp() {
            firstNode = new DequeNode<>(0, null, null);
            secondNode = new DequeNode<>(1, firstNode, null);
            thirdNode = new DequeNode<>(2, secondNode, null);
            firstNode.setNext(secondNode);
            secondNode.setNext(thirdNode);
        }

        @Test
        @DisplayName("the second node is not terminal")
        void secondNodeIsNotTerminal () {
            assertTrue(secondNode.isNotATerminalNode());
        }

        @Test
        @DisplayName("setting the previous of the last node to null removes the previous node")
        void thirdNodeChangesPreviousWhenSet () {

            DequeNode <Integer> node_one = new DequeNode<>(0, null, null);
            DequeNode <Integer> node_two = new DequeNode<>(1, node_one, null);
            DequeNode <Integer> node_three = new DequeNode<>(2, node_two, null);
            node_one.setNext(node_two);
            node_two.setNext(node_three);

            node_three.setPrevious(null);

            DequeNode<Integer> actualValue = null;
            DequeNode<Integer> expectedValue = node_three.getPrevious();

            assertEquals(expectedValue, actualValue);
        }
    }
}