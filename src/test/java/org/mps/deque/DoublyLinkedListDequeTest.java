package org.mps.deque;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 The class contains methods for testing linked list in three different cases:
 *<h3>Empty list</h3>
 * - has size zero
 * - adding one at the beginning means size 1 and node is first
 * - adding one at the end means size 1 and node is last
 * - deleting throws exception
 * - getting first or last item throws exception
 * - sorting has no effect and does not throw an exception
 * - asking if it contains a value or a null returns false
 * - remove should throw an exception
 * - sorting does not throw and exception
 *<h3>One node list</h3>
 * - has size one
 * - first and last element is the same as size is equals to 1
 * - can delete once, but not twice
 * - prepend an element increments the size by one and puts it as first
 * - append an element increments the size by one and puts it as last
 * - sorting has no effect and does not throw an exception
 * - asking if it contains a value that is contained returns true
 * - try to get an element with index less than zero or greater or equal to the size should throw an exception
 * - try to get an element with a valid index should return the element
 * - asking if it contains a value that is contained returns true
 * - asking if it contains a null returns false
 * - remove should result on an empty deque
 *<h3>Two node list</h3>
 * - has size two
 * - can delete twice, but no more
 * - can delete once and keep consistency
 * - prepend an element increments the size by one and puts it as first
 * - append an element increments the size by one and puts it as last
 * - try to get an element with index less than zero or greater or equal to the size should throw an exception
 * - try to get an element with a valid index should return the element
 * - asking if it contains a value that is contained returns true
 * - asking if it contains a null returns false
 * - remove first ocurrency of an element should remove it first ocurrence only, even if it is repeated
 * - remove an element that doesn't exist should do nothing
 *<h3>Null node item list</h3>
 * - contains null and does nos throw an exception
 * - does not contain any other value than null
 *<h3>Sorted lists</h3>
 *  - sorting has no effect
 *<h3>Unsorted lists</h3>
 *  - sorting on different kinds of list sorts the list
 *<br/>
 * On every kind of list it is tested the size, insertions and deletions
 * checking if the consistency is kept between nodes.
 * @author Alba Ruiz Gutiérrez
 * @author José Manuel Sánchez Rico
 */
class DoublyLinkedListDequeTest {
    private DoublyLinkedListDeque<Integer> createQueueOf(Integer ...args) {
        DoublyLinkedListDeque<Integer> list = new DoublyLinkedListDeque<>();
        for (Integer number : args) {
            list.append(number);
        }
        return list;
    }

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

        @DisplayName("adding an element to the front should increase size by one")
        @Test
        void addFirstIncreasesSizeByOne() {
            emptyDoubleLinkedList.prepend(1);

            int expectedValue = 1;
            int actualValue = emptyDoubleLinkedList.size();

            assertEquals(expectedValue, actualValue);
        }


        @DisplayName("adding an element to the front should change it as first element")
        @Test
        void addFirstIncreasesMakesItTheFirst() {
            emptyDoubleLinkedList.prepend(1);

            int expectedValue = 1;
            int actualValue = emptyDoubleLinkedList.first();

            assertEquals(expectedValue, actualValue);
        }
        @DisplayName("adding an element to the back should increase size and change last element")
        @Test
        void addLastIncreasesSizeByOne() {
            emptyDoubleLinkedList.append(1);

            int expectedValue = 1;
            int actualValue = emptyDoubleLinkedList.size();

            assertEquals(expectedValue, actualValue);
        }

        @DisplayName("adding an element to the back should increase size and change last element")
        @Test
        void addLastSetsItAsLast() {
            emptyDoubleLinkedList.append(1);

            int expectedValue = 1;
            int actualValue = emptyDoubleLinkedList.last();

            assertEquals(expectedValue, actualValue);
        }

        @DisplayName("deleting should throw an exception")
        @Test
        void deleteFirstFromEmptyDequeThrowAnException() {
            assertThrows(DoubleEndedQueueException.class, () -> emptyDoubleLinkedList.deleteFirst());
        }

        @DisplayName("deleting last should throw an exception")
        @Test
        void deleteLastFromEmptyDequeThrowAnException() {
            assertThrows(DoubleEndedQueueException.class, () -> emptyDoubleLinkedList.deleteLast());
        }

        @DisplayName("try to access to an element should throw an exception")
        @Test
        void firstOfEmptyDequeThrowsAnException() {
            assertThrows(DoubleEndedQueueException.class, () -> emptyDoubleLinkedList.first());
        }

        @DisplayName("try to access to an element should throw an exception")
        @Test
        void lastOfEmptyDequeThrowsAnException() {
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
            boolean expectedValue = false;
            boolean actualValue = emptyDoubleLinkedList.contains(5);

            assertEquals(expectedValue, actualValue);
        }

        @DisplayName("asking if it contains a null returns false")
        @Test
        void containsNullReturnsNull() {
            boolean expectedValue = false;
            boolean actualValue = emptyDoubleLinkedList.contains(null);

            assertEquals(expectedValue, actualValue);
        }

        @DisplayName("remove should throw an exception")
        @Test
        void removeOnEmptyDequeThrowsAnException(){
            assertThrows(DoubleEndedQueueException.class, () -> emptyDoubleLinkedList.remove(1));
        }

        @DisplayName("sorting does not throw and exception")
        @Test
        void sortingDoesNotThrowAnException(){
            assertDoesNotThrow(() -> emptyDoubleLinkedList.sort(Integer::compareTo));
        }
    }

    @Nested
    @DisplayName("On a single node, double linked list")
    class SingleNodeDoubleLinkedListTest {
        static DoublyLinkedListDeque<Integer> singleNodeDoubleLinkedList;
        @BeforeEach
        void setUp() {
            singleNodeDoubleLinkedList = createQueueOf( 5);
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
        void firstEqualsLast() {
            int expectedValue = 5;

            assertEquals(expectedValue, singleNodeDoubleLinkedList.first());
            assertEquals(expectedValue, singleNodeDoubleLinkedList.last());
        }


        @DisplayName("adding an element to the front should increase size by one and change first element")
        @Test
        void addFirstIncreasesSizeByOne() {
            singleNodeDoubleLinkedList.prepend(1);

            int expectedValue = 2;
            int actualValue = singleNodeDoubleLinkedList.size();

            assertEquals(expectedValue, actualValue);
        }

        @DisplayName("adding an element to the front should change it as the first element")
        @Test
        void addFirstSetsItemAsFirst() {
            singleNodeDoubleLinkedList.prepend(1);

            int expectedValue = 1;
            int actualValue = singleNodeDoubleLinkedList.first();

            assertEquals(expectedValue, actualValue);
        }


        @DisplayName("adding an element to the back should increase size by on")
        @Test
        void addLastIncreasesSizeByOne() {
            singleNodeDoubleLinkedList.append(1);

            int expectedValue = 2;
            int actualValue = singleNodeDoubleLinkedList.size();

            assertEquals(expectedValue, actualValue);
        }

        @DisplayName("adding an element to the back should change last element")
        @Test
        void addLastChangesLastElement() {
            singleNodeDoubleLinkedList.append(1);

            int expectedValue = 1;
            int actualValue = singleNodeDoubleLinkedList.last();

            assertEquals(expectedValue, actualValue);
        }

        @DisplayName("deleting the first element should result in an empty deque")
        @Test
        void deleteFirstFromSingleNodeDecreasesItsSize(){
            singleNodeDoubleLinkedList.deleteFirst();

            int expectedSize = 0;
            int actualSize = singleNodeDoubleLinkedList.size();

            assertEquals(expectedSize, actualSize);
            assertThrows(DoubleEndedQueueException.class, singleNodeDoubleLinkedList::first);
        }

        @DisplayName("deleting the first element should result in an empty deque")
        @Test
        void deleteLastFromSingleNodeResultsInAnEmptyList(){
            singleNodeDoubleLinkedList.deleteLast();

            int expectedSize = 0;
            int actualSize = singleNodeDoubleLinkedList.size();

            assertEquals(expectedSize, actualSize);
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

            int expectedSize = 0;
            int actualSize = singleNodeDoubleLinkedList.size();

            assertEquals(expectedSize, actualSize);
        }
    }

    @Nested
    @DisplayName("On a two nodes, double linked list")
    class DoubleNodeDoubleLinkedListTest {
        static DoublyLinkedListDeque<Integer> doubleNodeDoubleLinkedList;

        @BeforeEach
        void setUp() {
            doubleNodeDoubleLinkedList = createQueueOf( 5, 6);
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

        @DisplayName("remove first occurrence of an element with two occurencys sholud left the second element and remove the first one")
        @Test
        void removeOneOutOfTwoFromDoubleDeque(){
            doubleNodeDoubleLinkedList.append(5);
            doubleNodeDoubleLinkedList.remove(5);
            assertEquals(2,doubleNodeDoubleLinkedList.size());
            assertEquals(6, doubleNodeDoubleLinkedList.first());
            assertEquals(5, doubleNodeDoubleLinkedList.last());
        }

        @DisplayName("remove an element with one occurrence should left the second element and remove the first one")
        @Test
        void removeFromDoubleDeque(){
            doubleNodeDoubleLinkedList.remove(6);
            assertEquals(1,doubleNodeDoubleLinkedList.size());
            assertEquals(5, doubleNodeDoubleLinkedList.first());
            assertEquals(5, doubleNodeDoubleLinkedList.last());
        }

        @DisplayName("remove an element that doesn't exist should do nothing")
        @Test
        void removeAnElementThatIsNotInADoubleDeque(){
            doubleNodeDoubleLinkedList.remove(2);
            assertEquals(2,doubleNodeDoubleLinkedList.size());
            assertEquals(5, doubleNodeDoubleLinkedList.first());
            assertEquals(6, doubleNodeDoubleLinkedList.last());
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

        @DisplayName("asking if it contains a value different that it has returns false")
        @Test
        void containsReturnsFalseWhenAskingIfItContainsAValueDistinctFromNull() {
            assertDoesNotThrow(() -> nullItemDoubleLinkedList.contains(5));
            assertFalse(nullItemDoubleLinkedList.contains(5));
        }
    }

    @DisplayName("On a sorted node list")
    @Nested
    class SortedNodeListTest {
        @DisplayName("sorting two elements has no effect")
        @Test
        void sortingTwoElementsDoesNotModifyTheList() {
            DoublyLinkedListDeque<Integer> list = createQueueOf(4, 5);

            list.sort(Integer::compareTo);

            assertEquals(4, list.first());
            assertEquals(4, list.get(0));
            assertEquals(5, list.last());
            assertEquals(5, list.get(1));
        }

        @DisplayName("sorting three elements has no effect")
        @Test
        void sortingThreeElementsDoesNotModifyTheList() {
            DoublyLinkedListDeque<Integer> list = createQueueOf(4, 5, 6);

            list.sort(Integer::compareTo);

            assertEquals(4, list.first());
            assertEquals(4, list.get(0));
            assertEquals(5, list.get(1));
            assertEquals(6, list.last());
            assertEquals(6, list.get(2));
        }
    }

    @DisplayName("On an unsorted node list")
    @Nested
    class UnsortedNodeListTest {
        @DisplayName("sorting three elements 4 0 5 sorts them as 0 4 5")
        @Test
        void sortingTwoElementsSortsThem() {
            DoublyLinkedListDeque<Integer> list = createQueueOf(4, 0, 5);

            list.sort(Integer::compareTo);

            assertEquals(0, list.first());
            assertEquals(0, list.get(0));
            assertEquals(4, list.get(1));
            assertEquals(5, list.last());
            assertEquals(5, list.get(2));
        }

        @DisplayName("sorting three elements 5 6 4 sorts them as 4 5 6")
        @Test
        void sortingThreeElementsSortsThem() {
            DoublyLinkedListDeque<Integer> list = createQueueOf( 5, 6, 4);

            list.sort(Integer::compareTo);

            assertEquals(4, list.first());
            assertEquals(4, list.get(0));
            assertEquals(5, list.get(1));
            assertEquals(6, list.last());
            assertEquals(6, list.get(2));
        }

        @DisplayName("sorting three 5 null 4 elements sorts them as null 4 5")
        @Test
        void sortingThreeElementsWithNullSortsThem() {
            DoublyLinkedListDeque<Integer> list = createQueueOf( 5, null, 4);

            list.sort(Integer::compareTo);

            assertEquals(null, list.first());
            assertEquals(null, list.get(0));
            assertEquals(4, list.get(1));
            assertEquals(5, list.last());
            assertEquals(5, list.get(2));
        }

        @DisplayName("sorting three elements null, 4, null sorts them as null, null, 4")
        @Test
        void sortingTwoNullsAndOneElementsWithNullSortsThem() {
            DoublyLinkedListDeque<Integer> list = createQueueOf( null, 4, null);

            list.sort(Integer::compareTo);

            assertEquals(null, list.first());
            assertEquals(null, list.get(0));
            assertEquals(null, list.get(1));
            assertEquals(4, list.last());
            assertEquals(4, list.get(2));
        }
    }
}