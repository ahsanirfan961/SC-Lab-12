package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.RecursiveBinarySearch.binarySearchRecursive;
import static org.example.RecursiveBinarySearch.findAllIndices;

public class Main {
    public static void main(String[] args) {

        int[] sortedArray = {1, 3, 5, 7, 9, 9, 9, 12, 15};
        int target = 9;
        System.out.println("Index of target: " + binarySearchRecursive(sortedArray, target, 0, sortedArray.length - 1));

        // Test for string binary search
        String[] sortedStringArray = {"apple", "banana", "cherry", "date", "fig", "grape"};
        String targetString = "cherry";
        System.out.println("Index of target: " + binarySearchRecursive(sortedStringArray, targetString, 0, sortedStringArray.length - 1));

        // Test for finding all indices of target
        List<Integer> indices = findAllIndices(sortedArray, target, 0, sortedArray.length - 1, new ArrayList<>());
        System.out.println("All indices of target: " + indices);
    }
}