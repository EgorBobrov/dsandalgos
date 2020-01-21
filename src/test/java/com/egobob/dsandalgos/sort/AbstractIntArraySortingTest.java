package com.egobob.dsandalgos.sort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public abstract class AbstractIntArraySortingTest {

   int[] sortedByCustomImpl;
   int[] sortedByJava;

   void initializeAndSortArrays(int[] arr, IntArraySortingAlgorithm sortingAlgorithm) {
      sortedByCustomImpl = arr.clone();
      sortedByJava = arr.clone();
      sortingAlgorithm.sort(sortedByCustomImpl);
      Arrays.sort(sortedByJava);
   }

   void performAssertions(int[] arr) {
      performAssertions(arr, sortedByJava, sortedByCustomImpl);
   }

   void performAssertions(int[] initialArray, int[] sortedByJava, int[] sortedByCustomImpl) {
      try {
         assertArrayEquals(sortedByJava, sortedByCustomImpl);
      } catch (AssertionError assertionError) {
         System.out.println("Original: " + Arrays.toString(initialArray));
         System.out.println("Expected: " + Arrays.toString(sortedByJava));
         System.out.println("  Actual: " + Arrays.toString(sortedByCustomImpl));
         throw assertionError;
      }
   }

}
