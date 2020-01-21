package com.egobob.dsandalgos.sort;

import org.junit.Test;

import static com.egobob.dsandalgos.TestUtil.generateIntArray;
import static org.junit.Assert.assertArrayEquals;

public class ShellSortImplementationTest extends AbstractIntArraySortingTest {
   private ShellSortImplementation shellSortImplementation = new ShellSortImplementation();

   @Test
   public void testSort_whenArrayIsEmpty_ThenItSortsProperly() {
      int[] arr = generateIntArray(0);
      initializeAndSortArrays(arr, shellSortImplementation);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsOneElementLong_ThenItSortsProperly() {
      int[] arr = generateIntArray(1);
      initializeAndSortArrays(arr, shellSortImplementation);
      performAssertions(arr);
   }

   @Test
   public void testSort_whenArrayIsTenElementsLong_ThenItSortsProperly() {
      int[] arr = generateIntArray(10);
      initializeAndSortArrays(arr, shellSortImplementation);
      performAssertions(arr);
   }

   @Test
   public void testSort_when10RandomizedArrays_ThenItSortsProperly() {
      for (int i = 0; i < 10; i++) {
         int[] arr = generateIntArray();
         initializeAndSortArrays(arr, shellSortImplementation);
         performAssertions(arr);
      }
   }
}
