package com.egobob.dsandalgos.sort;

import org.junit.Test;

import static com.egobob.dsandalgos.TestUtil.generateIntArray;

public class RecursiveInsertionSortTest extends AbstractIntArraySortingTest {

   private RecursiveInsertionSort insertionSort = new RecursiveInsertionSort();

   @Test
   public void testSort_whenArrayIsEmpty_ThenItSortsProperly() {
      Integer[] arr = generateIntArray(0);
      initializeAndSortArrays(arr, insertionSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsOneElementLong_ThenItSortsProperly() {
      Integer[] arr = generateIntArray(1);
      initializeAndSortArrays(arr, insertionSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsTwoElementsLongAndSorted_ThenItSortsProperly() {
      Integer[] arr = {1, 2};
      initializeAndSortArrays(arr, insertionSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsTwoElementsLong_ThenItSortsProperly() {
      Integer[] arr = {2, 1};
      initializeAndSortArrays(arr, insertionSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsThreeElementsLong_ThenItSortsProperly() {
      Integer[] arr = {2, 3, 1};
      initializeAndSortArrays(arr, insertionSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsFiveElementsLong_ThenItSortsProperly() {
      Integer[] arr = {15, -39, 6, 32, 58};
      initializeAndSortArrays(arr, insertionSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsTenElementsLong_ThenItSortsProperly() {
      Integer[] arr = generateIntArray(10);
      initializeAndSortArrays(arr, insertionSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_when10RandomizedArrays_ThenItSortsProperly() {
      for (int i = 0; i < 10; i++) {
         Integer[] arr = generateIntArray();
         initializeAndSortArrays(arr, insertionSort);
         performAssertions(arr);
      }
   }


}