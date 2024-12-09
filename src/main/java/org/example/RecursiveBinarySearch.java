package org.example;

import java.util.ArrayList;
import java.util.List;

public class RecursiveBinarySearch {

    // Recursive Binary Search for integers
    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        if (left > right) {
            return -1; // Base case: target not found
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearchRecursive(array, target, left, mid - 1);
        } else {
            return binarySearchRecursive(array, target, mid + 1, right);
        }
    }

    // Recursive Binary Search for strings
    public static int binarySearchRecursive(String[] array, String target, int left, int right) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        if (left > right) {
            return -1; // Base case: target not found
        }

        int mid = left + (right - left) / 2;

        if (array[mid].equals(target)) {
            return mid;
        } else if (array[mid].compareTo(target) > 0) {
            return binarySearchRecursive(array, target, left, mid - 1);
        } else {
            return binarySearchRecursive(array, target, mid + 1, right);
        }
    }

    // Find all indices of the target value
    public static List<Integer> findAllIndices(int[] array, int target, int left, int right, List<Integer> indices) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        if (left > right) {
            return indices; // Base case: return collected indices
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            indices.add(mid);
            // Explore both halves for duplicates
            findAllIndices(array, target, left, mid - 1, indices);
            findAllIndices(array, target, mid + 1, right, indices);
        } else if (array[mid] > target) {
            findAllIndices(array, target, left, mid - 1, indices);
        } else {
            findAllIndices(array, target, mid + 1, right, indices);
        }

        // Sort indices after recursion to maintain order
        indices.sort(Integer::compareTo);
        return indices;
    }

}
