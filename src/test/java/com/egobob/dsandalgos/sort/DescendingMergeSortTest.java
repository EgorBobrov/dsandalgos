package com.egobob.dsandalgos.sort;

import org.junit.Test;

import static com.egobob.dsandalgos.TestUtil.generateIntArray;
import static com.egobob.dsandalgos.TestUtil.reverseArray;

public class DescendingMergeSortTest extends AbstractIntArraySortingTest {

   DescendingMergeSort descendingMergeSort = new DescendingMergeSort();

   @Test
   public void testMerge_whenTwoHalvesOf2ElementsArraySorted_thenSortTheArray() {
      int[] initialArray = {1, 2};
      int[] array = initialArray.clone();
      descendingMergeSort.merge(array, 0, array.length / 2, array.length);
      performAssertions(initialArray, new int[]{2, 1}, array);
   }

   @Test
   public void testMerge_whenTwoHalvesOf10ElementsArraySorted_thenSortTheArray() {
      int[] initialArray = {9, 8, 7, 6, 5,
            4, 3, 2, 1, 0};
      int[] array = initialArray.clone();
      descendingMergeSort.merge(array, 0, array.length / 2, array.length);
      performAssertions(initialArray, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, array);
   }

   @Test
   public void testMerge_whenTwoUnevenHalvesOf3ElementsArraySorted_thenSortTheArray() {
      int[] initialArray = {1, 3, 2};
      int[] array = initialArray.clone();
      descendingMergeSort.merge(array, 0, array.length / 2, array.length);
      performAssertions(initialArray, new int[]{3, 2, 1}, array);
   }

   @Test
   public void testSort_whenArrayIsEmpty_ThenItSortsProperly() {
      int[] arr = generateIntArray(0);
      initializeAndSortArrays(arr, descendingMergeSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsOneElementLong_ThenItSortsProperly() {
      int[] arr = generateIntArray(1);
      initializeAndSortArrays(arr, descendingMergeSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIs3ElementLong_ThenItSortsProperly() {
      int[] initialArray = new int[]{67, 85, 9};
      int[] arr = initialArray.clone();
      initializeAndSortArrays(arr, descendingMergeSort);
      performAssertions(initialArray, reverseArray(sortedByJava), sortedByCustomImpl);
   }

   @Test
   public void testSort_whenRandomArrayIs3ElementLong_ThenItSortsProperly() {
      int[] initialArray = generateIntArray(3);
      int[] arr = initialArray.clone();
      initializeAndSortArrays(arr, descendingMergeSort);
      performAssertions(initialArray, reverseArray(sortedByJava), sortedByCustomImpl);
   }

   @Test
   public void testSort_whenArrayIsTenElementsLong_ThenItSortsProperly() {
      int[] initialArray = generateIntArray(10);
      int[] arr = initialArray.clone();
      initializeAndSortArrays(arr, descendingMergeSort);
      performAssertions(initialArray, reverseArray(sortedByJava), sortedByCustomImpl);
   }

   @Test
   public void testSort_when10RandomizedArrays_ThenItSortsProperly() {
      for (int i = 0; i < 10; i++) {
         int[] initialArray = generateIntArray();
         int[] arr = initialArray.clone();
         initializeAndSortArrays(arr, descendingMergeSort);
         performAssertions(initialArray, reverseArray(sortedByJava), sortedByCustomImpl);
      }
   }


}