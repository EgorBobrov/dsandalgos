package com.egobob.dsandalgos.sort;

import org.junit.Test;

import static com.egobob.dsandalgos.TestUtil.generateIntArray;
import static com.egobob.dsandalgos.TestUtil.generateLimitedIntArray;

public class RadixSortTest extends AbstractIntArraySortingTest {
   private RadixSort radixSort = new RadixSort();

   @Test
   public void testSort_whenArrayIsEmpty_ThenItSortsProperly() {
      int[] arr = generateIntArray(0);
      initializeAndSortArrays(arr, radixSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsOneElementLong_ThenItSortsProperly() {
      int[] arr = generateIntArray(1);
      initializeAndSortArrays(arr, radixSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsTenElementsLongWithRadix3_ThenItSortsProperly() {
      int[] arr = generateLimitedIntArray(100, 1000, 10);
      initializeAndSortArrays(arr, radixSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_when10RandomizedArraysWithRadix3_ThenItSortsProperly() {
      for (int i = 0; i < 10; i++) {
         int[] arr = generateLimitedIntArray(100, 1000, 10);
         initializeAndSortArrays(arr, radixSort);
         performAssertions(arr);
      }
   }


}