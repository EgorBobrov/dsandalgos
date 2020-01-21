package com.egobob.dsandalgos.sort;

import org.junit.Test;

import static com.egobob.dsandalgos.TestUtil.generateIntArray;
import static org.junit.Assert.*;

public class QuickSortImplemnentationTest extends AbstractIntArraySortingTest {

   private QuickSortImplementation quickSortImplementation = new QuickSortImplementation();

   @Test
   public void testSort_whenArrayIsEmpty_ThenItSortsProperly() {
      int[] arr = generateIntArray(0);
      initializeAndSortArrays(arr, quickSortImplementation);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsOneElementLong_ThenItSortsProperly() {
      int[] arr = generateIntArray(1);
      initializeAndSortArrays(arr, quickSortImplementation);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsFourElementsLong_ThenItSortsProperly() {
      int[] arr = {1, 3, 2, 0};
      initializeAndSortArrays(arr, quickSortImplementation);
      assertArrayEquals(new int[]{0, 1, 2, 3}, sortedByCustomImpl);
   }

   @Test
   public void testSort_whenArrayIsTenElementsLong_ThenItSortsProperly() {
      int[] arr = generateIntArray(10);
      initializeAndSortArrays(arr, quickSortImplementation);
      performAssertions(arr);
   }

   @Test
   public void testSort_when10RandomizedArrays_ThenItSortsProperly() {
      for (int i = 0; i < 10; i++) {
         int[] arr = generateIntArray();
         initializeAndSortArrays(arr, quickSortImplementation);
         performAssertions(arr);
      }
   }


}