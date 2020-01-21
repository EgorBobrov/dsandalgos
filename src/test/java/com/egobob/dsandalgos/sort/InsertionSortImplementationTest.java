package com.egobob.dsandalgos.sort;

import org.junit.Test;

import static com.egobob.dsandalgos.TestUtil.generateIntArray;

public class InsertionSortImplementationTest extends AbstractIntArraySortingTest {
   
   private InsertionSortImplementation insertionSort = new InsertionSortImplementation();

   @Test
   public void testSort_whenArrayIsEmpty_ThenItSortsProperly() {
      int[] arr = generateIntArray(0);
      initializeAndSortArrays(arr, insertionSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsOneElementLong_ThenItSortsProperly() {
      int[] arr = generateIntArray(1);
      initializeAndSortArrays(arr, insertionSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsTenElementsLong_ThenItSortsProperly() {
      int[] arr = generateIntArray(10);
      initializeAndSortArrays(arr, insertionSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_when10RandomizedArrays_ThenItSortsProperly() {
      for (int i = 0; i < 10; i++) {
         int[] arr = generateIntArray();
         initializeAndSortArrays(arr, insertionSort);
         performAssertions(arr);
      }
   }

}