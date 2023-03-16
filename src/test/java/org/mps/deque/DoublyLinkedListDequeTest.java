package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class contains methods for testing linked list in three different cases:
 * Empty list
 * - has size zero
 * - adding one at the beginning means size 1 and node is first
 * - adding one at the end means size 1 and node is last
 * - deleting throws exception
 * - getting first or last item throws exception
 * One node list
 * - has size zero
 * - first and last element is the same as size is equals to 1
 * - can delete once, but not twice
 * - prepend an element increments the size by one and puts it as first
 * - append an element increments the size by one and puts it as last
 * Two node list
 * - has size two
 * - can delete twice, but no more
 * - can delete once and keep consistency
 * - prepend an element increments the size by one and puts it as first
 * - append an element increments the size by one and puts it as last
 * On every kind of list it is tested the size, insertions and deletions
 * checking if the consistency is kept between nodes.
 * @author Alba Ruiz Gutiérrez
 * @author José Manuel Sánchez Rico
 */
class DoublyLinkedListDequeTest {

    @Nested
    @DisplayName("On an empty double linked list")
    class EmptyDoubleLinkedListTest {
        static DoublyLinkedListDeque<Integer> emptyDoubleLinkedList;
        @BeforeEach
        void setUp() {
            emptyDoubleLinkedList = new DoublyLinkedListDeque<>();
        }

        @DisplayName("the size is zero")
        @Test
        void hasSizeZero() {
            int expectedValue = 0;
            int actualValue = emptyDoubleLinkedList.size();
            assertEquals(expectedValue, actualValue);
        }

        @DisplayName("adding an element to the front should increase size by one and change first element")
        @Test
        void addFirst() {
            emptyDoubleLinkedList.prepend(1);
            assertEquals(1, emptyDoubleLinkedList.size());
            assertEquals(1, emptyDoubleLinkedList.first());
        }

        @DisplayName("adding an element to the back should increase size and change last element")
        @Test
        void addLast() {
            emptyDoubleLinkedList.append(1);
            assertEquals(1, emptyDoubleLinkedList.size());
            assertEquals(1, emptyDoubleLinkedList.last());
        }

        @DisplayName("deleting should throw an exception")
        @Test
        void deleteFromEmptyDeque() {
            assertThrows(DoubleEndedQueueException.class, () -> emptyDoubleLinkedList.deleteFirst());
            assertThrows(DoubleEndedQueueException.class, () -> emptyDoubleLinkedList.deleteLast());
        }

        @DisplayName("try to access to an element should throw an exception")
        @Test
        void firstOfEmptyDeque() {
            assertThrows(DoubleEndedQueueException.class, () -> emptyDoubleLinkedList.first());
            assertThrows(DoubleEndedQueueException.class, () -> emptyDoubleLinkedList.last());
        }

        @DisplayName("getting any element should throw an exception")
        @Test
        void getOnEmptyDeque(){
            assertThrows(IndexOutOfBoundsException.class, () -> emptyDoubleLinkedList.get(1));
        }


        @DisplayName("asking if it contains a value returns false")
        @Test
        void containsReturnsNull() {
            assertFalse(emptyDoubleLinkedList.contains(5));
        }

        @DisplayName("asking if it contains a null returns false")
        @Test
        void containsNullReturnsNull() {
            assertFalse(emptyDoubleLinkedList.contains(null));
        }

        @DisplayName("remove should throw an exception")
        @Test
        void removeOnEmptyDeque(){
            assertThrows(DoubleEndedQueueException.class, () -> emptyDoubleLinkedList.remove(1));
        }
    }

    @Nested
    @DisplayName("On a single node, double linked list")
    class SingleNodeDoubleLinkedListTest {
        static DoublyLinkedListDeque<Integer> singleNodeDoubleLinkedList;
        @BeforeEach
        void setUp() {
            singleNodeDoubleLinkedList = new DoublyLinkedListDeque<>();
            singleNodeDoubleLinkedList.append(5);
        }


        @DisplayName("the size is one")
        @Test
        void hasSizeOne() {
            int expectedValue = 1;
            int actualValue = singleNodeDoubleLinkedList.size();

            assertEquals(expectedValue, actualValue);
        }

        @DisplayName("the first and last element should be the same")
        @Test
        void singleElement() {

            assertEquals(1, singleNodeDoubleLinkedList.size());
            assertEquals(5, singleNodeDoubleLinkedList.first());
            assertEquals(5, singleNodeDoubleLinkedList.last());
        }


        @DisplayName("adding an element to the front should increase size by one and change first element")
        @Test
        void addFirst() {
            singleNodeDoubleLinkedList.prepend(1);
            assertEquals(2, singleNodeDoubleLinkedList.size());
            assertEquals(1, singleNodeDoubleLinkedList.first());
        }


        @DisplayName("adding an element to the back should increase size and change last element")
        @Test
        void addLast() {
            singleNodeDoubleLinkedList.append(1);
            assertEquals(2, singleNodeDoubleLinkedList.size());
            assertEquals(1, singleNodeDoubleLinkedList.last());
        }

        @DisplayName("deleting the first element should result in an empty deque")
        @Test
        void deleteFirstFromSingleNodeThrowsAnException(){
            singleNodeDoubleLinkedList.deleteFirst();
            assertEquals(0, singleNodeDoubleLinkedList.size());
            assertThrows(DoubleEndedQueueException.class, singleNodeDoubleLinkedList::first);

        }

        @DisplayName("deleting the first element should result in an empty deque")
        @Test
        void deleteLastFromSingleNodeResultsInAnEmptyList(){
            singleNodeDoubleLinkedList.deleteLast();
            assertEquals(0, singleNodeDoubleLinkedList.size());
            assertThrows(DoubleEndedQueueException.class, singleNodeDoubleLinkedList::last);
        }

        @DisplayName("asking if it contains a value that is contained returns true")
        @Test
        void containsReturnsTrueWhenAskingIfItContainsAValueThatTheListHas() {
            assertTrue(singleNodeDoubleLinkedList.contains(5));
        }

        @DisplayName("try to get an element with index less than zero should throw an exception")
        @Test
        void getValueWithNegativeIndexOnSingleDeque(){
            assertThrows(IndexOutOfBoundsException.class, () -> singleNodeDoubleLinkedList.get(-1));
        }

        @DisplayName("try to get an element with index equals to size should throw an exception")
        @Test
        void getValueWithIndexEqualsToSizeOnSingleDeque(){
            assertThrows(IndexOutOfBoundsException.class, () -> singleNodeDoubleLinkedList.get(1));
        }

        @DisplayName("try to get an element with index bigger than size should throw an exception")
        @Test
        void getValueWithIndexOutOfSizeOnSingleDeque(){
            assertThrows(IndexOutOfBoundsException.class, () -> singleNodeDoubleLinkedList.get(2));
        }

        @DisplayName("try to get an element with a valid index should return the element")
        @Test
        void getValueWithValidIndexOnSingleDeque(){
            assertEquals(5,singleNodeDoubleLinkedList.get(0));
        }
        @DisplayName("asking if it contains a value that is contained returns true")
        @Test
        void containsReturnsTrueWhenAskingIfItContainsAValueThatTheListDoesNotHave() {
            assertFalse(singleNodeDoubleLinkedList.contains(1));
        }

        @DisplayName("asking if it contains a null returns false")
        @Test
        void containsNullReturnsNull() {
            assertFalse(singleNodeDoubleLinkedList.contains(null));
        }

        @DisplayName("remove should result on an empty deque")
        @Test
        void removeOnSingleDeque(){
            singleNodeDoubleLinkedList.remove(5);
            assertEquals(0,singleNodeDoubleLinkedList.size());
        }
    }

    @Nested
    @DisplayName("On a two nodes, double linked list")
    class DoubleNodeDoubleLinkedListTest {
        static DoublyLinkedListDeque<Integer> doubleNodeDoubleLinkedList;

        @BeforeEach
        void setUp() {
            doubleNodeDoubleLinkedList = new DoublyLinkedListDeque<>();
            doubleNodeDoubleLinkedList.append(5);
            doubleNodeDoubleLinkedList.append(6);
        }


        @DisplayName("the size is two")
        @Test
        void hasSizeTwo() {
            int expectedValue = 2;
            int actualValue = doubleNodeDoubleLinkedList.size();

            assertEquals(expectedValue, actualValue);
        }


        @DisplayName("adding an element to the front should increase size by one and change first element")
        @Test
        void addFirstIncreaseSizeByOne() {
            doubleNodeDoubleLinkedList.prepend(1);
            assertEquals(3, doubleNodeDoubleLinkedList.size());
            assertEquals(1, doubleNodeDoubleLinkedList.first());
        }


        @DisplayName("adding an element to the back should increase size and change last element")
        @Test
        void addLastIncreaseSizeByOne() {
            doubleNodeDoubleLinkedList.append(1);
            assertEquals(3, doubleNodeDoubleLinkedList.size());
            assertEquals(1, doubleNodeDoubleLinkedList.last());
        }

        @Test
        @DisplayName("deleting the first element should result in a single deque")
        void deleteFirstFromDoubleNodeResultsInASingleNodeList() {
            doubleNodeDoubleLinkedList.deleteFirst();
            assertEquals(1, doubleNodeDoubleLinkedList.size());
            assertEquals(6, doubleNodeDoubleLinkedList.first());
            assertEquals(6, doubleNodeDoubleLinkedList.last());


        }

        @Test
        @DisplayName("deleting the last element should result in a single deque")
        void deleteLastFromDoubleNodeResultsInASingleNodeList() {
            doubleNodeDoubleLinkedList.deleteLast();
            assertEquals(1, doubleNodeDoubleLinkedList.size());
            assertEquals(5, doubleNodeDoubleLinkedList.first());
            assertEquals(5, doubleNodeDoubleLinkedList.last());
        }

        @Test
        @DisplayName("deleting first and last element results in an empty deque")
        void deleteFirstAndLastResultsInEmptyDeque() {
            doubleNodeDoubleLinkedList.deleteFirst();
            doubleNodeDoubleLinkedList.deleteLast();
            assertEquals(0, doubleNodeDoubleLinkedList.size());
            assertThrows(DoubleEndedQueueException.class, doubleNodeDoubleLinkedList::first);
            assertThrows(DoubleEndedQueueException.class, doubleNodeDoubleLinkedList::last);
        }

        @DisplayName("try to get an element with index less than zero should throw an exception")
        @Test
        void getValueWithNegativeIndexOnDoubleDeque(){
            assertThrows(IndexOutOfBoundsException.class, () -> doubleNodeDoubleLinkedList.get(-1));
        }

        @DisplayName("try to get an element with index equals to size should throw an exception")
        @Test
        void getValueWithSizeEqualsToIndexOnDoubleDeque(){
            assertThrows(IndexOutOfBoundsException.class, () -> doubleNodeDoubleLinkedList.get(2));
        }

        @DisplayName("try to get an element with index bigger than size should throw an exception")
        @Test
        void getValueWithIndexOutOfSizeOnDoubleDeque(){
            assertThrows(IndexOutOfBoundsException.class, () -> doubleNodeDoubleLinkedList.get(3));
        }

        @DisplayName("try to get an element with a valid index should return the element")
        @Test
        void getValueWithValidIndexOnSingleDeque(){
            assertEquals(5,doubleNodeDoubleLinkedList.get(0));
            assertEquals(6,doubleNodeDoubleLinkedList.get(1));
        }

        @DisplayName("asking if it contains a value that is contained returns true")
        @Test
        void containsReturnsTrueWhenAskingIfItContainsAValueThatTheListHas() {
            assertTrue(doubleNodeDoubleLinkedList.contains(5));
        }

        @DisplayName("asking if it contains a value that is the last returns true")
        @Test
        void containsReturnsTrueWhenAskingIfItContainsAValueThatIsTheLastOne() {
            assertTrue(doubleNodeDoubleLinkedList.contains(6));
        }

        @DisplayName("asking if it contains a value that is contained returns true")
        @Test
        void containsReturnsTrueWhenAskingIfItContainsAValueThatTheListDoesNotHave() {
            assertFalse(doubleNodeDoubleLinkedList.contains(1));
        }

        @DisplayName("asking if it contains a null returns false")
        @Test
        void containsNullReturnsNull() {
            assertFalse(doubleNodeDoubleLinkedList.contains(null));
        }
    }
    @Nested
    @DisplayName("On list with a null item")
    class NullNodeListTest {
        static DoubleEndedQueue<Integer> nullItemDoubleLinkedList;

        @BeforeEach
        void setUp() {
            nullItemDoubleLinkedList = new DoublyLinkedListDeque<>();
            nullItemDoubleLinkedList.append(null);
        }

        @DisplayName("asking if it contains null returns true")
        @Test
        void containsReturnsTrueWhenAskingIfItContainsNull() {
            assertDoesNotThrow(() -> nullItemDoubleLinkedList.contains(null));
            assertTrue(nullItemDoubleLinkedList.contains(null));
        }

        @DisplayName("asking if it contains a value different value returns false")
        @Test
        void containsReturnsFalseWhenAskingIfItContainsAValueDistinctFromNull() {
            assertDoesNotThrow(() -> nullItemDoubleLinkedList.contains(5));
            assertFalse(nullItemDoubleLinkedList.contains(5));
        }
    }
}