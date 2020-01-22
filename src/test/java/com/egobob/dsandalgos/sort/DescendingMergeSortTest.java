package com.egobob.dsandalgos.sort;

import org.junit.Test;

import static com.egobob.dsandalgos.TestUtil.generateIntArray;
import static com.egobob.dsandalgos.TestUtil.reverseArray;

public class DescendingMergeSortTest extends AbstractIntArraySortingTest {

   DescendingMergeSort descendingMergeSort = new DescendingMergeSort();

   @Test
   public void testMerge_whenTwoHalvesOf2ElementsArraySorted_thenSortTheArray() {
      Integer[] initialArray = {1, 2};
      Integer[] array = initialArray.clone();
      descendingMergeSort.merge(array, 0, array.length / 2, array.length);
      performAssertions(initialArray, new Integer[]{2, 1}, array);
   }

   @Test
   public void testMerge_whenTwoHalvesOf10ElementsArraySorted_thenSortTheArray() {
      Integer[] initialArray = {9, 8, 7, 6, 5,
            4, 3, 2, 1, 0};
      Integer[] array = initialArray.clone();
      descendingMergeSort.merge(array, 0, array.length / 2, array.length);
      performAssertions(initialArray, new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, array);
   }

   @Test
   public void testMerge_whenTwoUnevenHalvesOf3ElementsArraySorted_thenSortTheArray() {
      Integer[] initialArray = {1, 3, 2};
      Integer[] array = initialArray.clone();
      descendingMergeSort.merge(array, 0, array.length / 2, array.length);
      performAssertions(initialArray, new Integer[]{3, 2, 1}, array);
   }

   @Test
   public void testSort_whenArrayIsEmpty_ThenItSortsProperly() {
      Integer[] arr = generateIntArray(0);
      initializeAndSortArrays(arr, descendingMergeSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsOneElementLong_ThenItSortsProperly() {
      Integer[] arr = generateIntArray(1);
      initializeAndSortArrays(arr, descendingMergeSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIs3ElementLong_ThenItSortsProperly() {
      Integer[] initialArray = new Integer[]{67, 85, 9};
      Integer[] arr = initialArray.clone();
      initializeAndSortArrays(arr, descendingMergeSort);
      performAssertions(initialArray, reverseArray(sortedByJava), sortedByCustomImpl);
   }

   @Test
   public void testSort_whenRandomArrayIs3ElementLong_ThenItSortsProperly() {
      Integer[] initialArray = generateIntArray(3);
      Integer[] arr = initialArray.clone();
      initializeAndSortArrays(arr, descendingMergeSort);
      performAssertions(initialArray, reverseArray(sortedByJava), sortedByCustomImpl);
   }

   @Test
   public void testSort_whenArrayIsTenElementsLong_ThenItSortsProperly() {
      Integer[] initialArray = generateIntArray(10);
      Integer[] arr = initialArray.clone();
      initializeAndSortArrays(arr, descendingMergeSort);
      performAssertions(initialArray, reverseArray(sortedByJava), sortedByCustomImpl);
   }

   @Test
   public void testSort_when10RandomizedArrays_ThenItSortsProperly() {
      for (int i = 0; i < 10; i++) {
         Integer[] initialArray = generateIntArray();
         Integer[] arr = initialArray.clone();
         initializeAndSortArrays(arr, descendingMergeSort);
         performAssertions(initialArray, reverseArray(sortedByJava), sortedByCustomImpl);
      }
   }


}