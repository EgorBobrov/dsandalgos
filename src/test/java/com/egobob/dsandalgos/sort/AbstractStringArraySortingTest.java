package com.egobob.dsandalgos.sort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public abstract class AbstractStringArraySortingTest {
   String[] sortedByJava;
   String[] sortedByCustomImpl;

   void initializeAndSortArrays(String[] arr, StringArraySortingAlogrithm sortingAlgorithm) {
      sortedByCustomImpl = arr.clone();
      sortedByJava = arr.clone();
      sortingAlgorithm.sort(sortedByCustomImpl);
      Arrays.sort(sortedByJava);
   }
   void performAssertions(String[] arr) {
      performAssertions(arr, sortedByJava, sortedByCustomImpl);
   }

   void performAssertions(String[] initialArray, String[] sortedByJava, String[] sortedByCustomImpl) {
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
