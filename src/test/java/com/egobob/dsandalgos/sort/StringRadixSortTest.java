package com.egobob.dsandalgos.sort;

import org.junit.Test;

import static com.egobob.dsandalgos.TestUtil.generateLimitedStringArray;
import static com.egobob.dsandalgos.TestUtil.generateStringArray;

public class StringRadixSortTest extends AbstractStringArraySortingTest {

   private StringRadixSort radixSort = new StringRadixSort();

   @Test
   public void testSort_whenArrayIsEmpty_ThenItSortsProperly() {
      String[] arr = generateStringArray(0);
      initializeAndSortArrays(arr, radixSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsOneElementLong_ThenItSortsProperly() {
      String[] arr = generateStringArray(1);
      initializeAndSortArrays(arr, radixSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsTenElementsLong_ThenItSortsProperly() {
      String[] arr = {"yvhy", "jtvd", "ltdd", "tiut", "nuru", "wfjw", "xgcm", "znwq", "wdvu", "bhsq"};
      initializeAndSortArrays(arr, radixSort);
      performAssertions(arr);
   }


   @Test
   public void testSort_whenArrayIsTenElementsLongWithWidth4_ThenItSortsProperly() {
      String[] arr = generateLimitedStringArray(10, 4, 'a', 'z');
      initializeAndSortArrays(arr, radixSort);
      performAssertions(arr);
   }

   @Test
   public void testSort_when10RandomizedArraysWithWidth4_ThenItSortsProperly() {
      for (int i = 0; i < 10; i++) {
         String[] arr = generateLimitedStringArray(10, 4, 'a', 'z');
         initializeAndSortArrays(arr, radixSort);
         performAssertions(arr);
      }
   }


}