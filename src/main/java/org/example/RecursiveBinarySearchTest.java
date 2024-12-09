package org.example;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RecursiveBinarySearchTest {

    @Test
    void testBinarySearchRecursiveIntegers() {
        int[] sortedArray = {1, 3, 5, 7, 9, 12, 15};
        assertEquals(4, RecursiveBinarySearch.binarySearchRecursive(sortedArray, 9, 0, sortedArray.length - 1));
        assertEquals(-1, RecursiveBinarySearch.binarySearchRecursive(sortedArray, 2, 0, sortedArray.length - 1));
        assertThrows(IllegalArgumentException.class, () -> RecursiveBinarySearch.binarySearchRecursive(null, 5, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> RecursiveBinarySearch.binarySearchRecursive(new int[]{}, 5, 0, 0));
    }

    @Test
    void testBinarySearchRecursiveStrings() {
        String[] sortedArray = {"apple", "banana", "cherry", "date", "fig", "grape"};
        assertEquals(2, RecursiveBinarySearch.binarySearchRecursive(sortedArray, "cherry", 0, sortedArray.length - 1));
        assertEquals(-1, RecursiveBinarySearch.binarySearchRecursive(sortedArray, "kiwi", 0, sortedArray.length - 1));
        assertThrows(IllegalArgumentException.class, () -> RecursiveBinarySearch.binarySearchRecursive(null, "banana", 0, 0));
        assertThrows(IllegalArgumentException.class, () -> RecursiveBinarySearch.binarySearchRecursive(new String[]{}, "banana", 0, 0));
    }

    @Test
    void testFindAllIndices() {
        int[] sortedArray = {1, 3, 5, 7, 9, 9, 9, 12, 15};
        List<Integer> expectedIndices = List.of(4, 5, 6);
        assertEquals(expectedIndices, RecursiveBinarySearch.findAllIndices(sortedArray, 9, 0, sortedArray.length - 1, new ArrayList<>()));

        assertEquals(new ArrayList<>(), RecursiveBinarySearch.findAllIndices(sortedArray, 2, 0, sortedArray.length - 1, new ArrayList<>()));

        assertThrows(IllegalArgumentException.class, () -> RecursiveBinarySearch.findAllIndices(null, 5, 0, 0, new ArrayList<>()));
        assertThrows(IllegalArgumentException.class, () -> RecursiveBinarySearch.findAllIndices(new int[]{}, 5, 0, 0, new ArrayList<>()));
    }
}
