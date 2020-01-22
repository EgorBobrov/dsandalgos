package com.egobob.dsandalgos.sort;

import org.junit.Test;

import static com.egobob.dsandalgos.TestUtil.generateIntArray;
import static org.junit.Assert.*;

public class MergeSortImplementationTest extends AbstractIntArraySortingTest {

   MergeSortImplementation mergeSortImplementation = new MergeSortImplementation();

   @Test
   public void testMerge_whenTwoHalvesOf2ElementsArraySorted_thenSortTheArray() {
      Integer[] array = {2, 1};
      mergeSortImplementation.merge(array, 0, array.length / 2, array.length);
      assertArrayEquals(new Integer[]{1, 2}, array);
   }

   @Test
   public void testMerge_whenTwoHalvesOf10ElementsArraySorted_thenSortTheArray() {
      Integer[] array = {5, 6, 7, 8, 9,
                        0, 1, 2, 3, 4};
      mergeSortImplementation.merge(array, 0, array.length / 2, array.length);
      assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
   }

   @Test
   public void testMerge_whenTwoUnevenHalvesOf3ElementsArraySorted_thenSortTheArray() {
      Integer[] array = {3, 1, 2};
      mergeSortImplementation.merge(array, 0, array.length / 2, array.length);
      assertArrayEquals(new Integer[]{1, 2, 3}, array);
   }

   @Test
   public void testSort_whenArrayIsEmpty_ThenItSortsProperly() {
      Integer[] arr = generateIntArray(0);
      initializeAndSortArrays(arr, mergeSortImplementation);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsOneElementLong_ThenItSortsProperly() {
      Integer[] arr = generateIntArray(1);
      initializeAndSortArrays(arr, mergeSortImplementation);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIs3ElementLong_ThenItSortsProperly() {
      Integer[] arr = generateIntArray(3);
      initializeAndSortArrays(arr, mergeSortImplementation);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsTenElementsLong_ThenItSortsProperly() {
      Integer[] arr = generateIntArray(10);
      initializeAndSortArrays(arr, mergeSortImplementation);
      performAssertions(arr);
   }

   @Test
   public void testSort_when10RandomizedArrays_ThenItSortsProperly() {
      for (int i = 0; i < 10; i++) {
         Integer[] arr = generateIntArray();
         initializeAndSortArrays(arr, mergeSortImplementation);
         performAssertions(arr);
      }
   }


}