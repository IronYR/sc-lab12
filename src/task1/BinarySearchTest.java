package task1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearchInteger() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(3, BinarySearch.binarySearchRecursive(arr, 7));
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, 4));
        assertEquals(0, BinarySearch.binarySearchRecursive(arr, 1));
        assertEquals(6, BinarySearch.binarySearchRecursive(arr, 13));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullArrayInteger() {
        BinarySearch.binarySearchRecursive((int[]) null, 5);
    }

    @Test
    public void testBinarySearchString() {
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry"};
        assertEquals(2, BinarySearch.binarySearchRecursive(arr, "cherry"));
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, "fig"));
        assertEquals(0, BinarySearch.binarySearchRecursive(arr, "apple"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullArrayString() {
        BinarySearch.binarySearchRecursive((String[]) null, "test");
    }

    @Test
    public void testFindAllOccurrences() {
        int[] arr = {1, 2, 2, 2, 3, 4, 4, 5};
        assertArrayEquals(new int[]{1, 2, 3}, BinarySearch.findAllOccurrences(arr, 2));
        assertArrayEquals(new int[]{5, 6}, BinarySearch.findAllOccurrences(arr, 4));
        assertArrayEquals(new int[]{0}, BinarySearch.findAllOccurrences(arr, 1));
        assertArrayEquals(new int[]{}, BinarySearch.findAllOccurrences(arr, 6));
    }
}