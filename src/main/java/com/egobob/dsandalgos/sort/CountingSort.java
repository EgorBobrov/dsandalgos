package com.egobob.dsandalgos.sort;

import java.util.Arrays;

/**
 * Counting sort is an unstable sorting algorithm with linear complexity.
 * It achieves that by assuming some information about the values it sorts.
 * First, all values need to be discrete (so, no floats, doubles or Strings and similar objects).
 * Second, the range of values needs to be reasonably low, otherwise the counting array will not fit in memory.
 *
 */
public class CountingSort extends IntArraySortingAlgorithm {

   @Override
   public void sort(Integer[] array) {
      if (noReasonToSort(array)) return;

      int lowerLimit = getMinValue(array);
      int upperLimit = getMaxValue(array);
      sort(array, lowerLimit, upperLimit);
   }

   public void sort(Integer[] array, int lowerLimit, int upperLimit) {
      if (noReasonToSort(array)) return;

      int[] countingArray = new int[upperLimit - lowerLimit + 1];
      for (int i = 0; i < array.length; i++) {
         countingArray[array[i] - lowerLimit]++;
      }

      int arrayIndex = 0;
      int countingArrayIndex = 0;
      while (countingArrayIndex < countingArray.length) {
         for (int i = 0; i < countingArray[countingArrayIndex]; i++) {
            array[arrayIndex++] = countingArrayIndex + lowerLimit;
         }
         countingArrayIndex++;
      }
   }

   private int getMinValue(Integer[] array) {
      return Arrays.stream(array).mapToInt(i -> i).min().getAsInt();
   }

   private int getMaxValue(Integer[] array) {
      return Arrays.stream(array).mapToInt(i -> i).max().getAsInt();
   }

}
