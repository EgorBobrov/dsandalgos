package com.egobob.dsandalgos.sort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public abstract class AbstractArraySortingTest <T> {
   T[] sortedByCustomImpl;
   T[] sortedByJava;

   void initializeAndSortArrays(T[] arr, ArraySortingAlgorithm<T> sortingAlgorithm) {
      sortedByCustomImpl = arr.clone();
      sortedByJava = arr.clone();
      sortingAlgorithm.sort(sortedByCustomImpl);
      Arrays.sort(sortedByJava);
   }

   void performAssertions(T[] arr) {
      performAssertions(arr, sortedByJava, sortedByCustomImpl);
   }

   void performAssertions(T[] initialArray, T[] sortedByJava, T[] sortedByCustomImpl) {
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
