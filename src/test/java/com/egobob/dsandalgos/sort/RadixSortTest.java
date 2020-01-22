package com.egobob.dsandalgos.sort;

import org.junit.Test;

import static com.egobob.dsandalgos.TestUtil.generateIntArray;
import static com.egobob.dsandalgos.TestUtil.generateLimitedIntArray;

public class RadixSortTest extends AbstractIntArraySortingTest {
   private RadixSort radixSort = new RadixSort();

   @Test
   public void testSort_whenArrayIsEmpty_ThenItSortsProperly() {
      Integer[] arr = generateIntArray(0);
      initializeAndSortArrays(arr, radixSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsOneElementLong_ThenItSortsProperly() {
      Integer[] arr = generateIntArray(1);
      initializeAndSortArrays(arr, radixSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsTenElementsLongWithRadix3_ThenItSortsProperly() {
      Integer[] arr = generateLimitedIntArray(100, 1000, 10);
      initializeAndSortArrays(arr, radixSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_when10RandomizedArraysWithRadix3_ThenItSortsProperly() {
      for (int i = 0; i < 10; i++) {
         Integer[] arr = generateLimitedIntArray(100, 1000, 10);
         initializeAndSortArrays(arr, radixSort);
         performAssertions(arr);
      }
   }


}