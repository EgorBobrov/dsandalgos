package com.egobob.dsandalgos.sort;

import java.util.Arrays;

/**
 * A modification of Radix sort which sorts Strings (containing lowercase letters of Latin alphabet) instead of Integers.
 */
public class StringRadixSort extends StringArraySortingAlogrithm{

   @Override
   public void sort(String[] array) {
      if (noReasonToSort(array)) return;

      int width = calculateWidth(array);
      int radix = 'z' - 'a' + 1;
      radixSort(array, width, radix);
   }

   private void radixSort(String[] array, int width, int radix) {
      for (int i = width - 1; i >= 0; i--) {
         radixSingleSort(array, i, radix);
      }
   }

   private void radixSingleSort(String[] array, int position, int radix) {
      int numberOfItems = array.length;
      int[] countArray = new int[radix];

      for (String s: array) {
         countArray[getCharPosition(position, s)]++;
      }

      for (int i = 1; i < radix; i++) {
         countArray[i] += countArray[i - 1];
      }

      // stable counting sort
      String[] tempArray = new String[numberOfItems];
      for(int tempIndex = numberOfItems - 1; tempIndex >= 0; tempIndex--) {
         tempArray[--countArray[getCharPosition(position, array[tempIndex])]] = array[tempIndex];
      }
      System.arraycopy(tempArray, 0, array, 0, numberOfItems);

   }
   private int getCharPosition(int position, String value) {
      return value.charAt(position) - 'a';
   }

   private int calculateWidth(String[] array) {
      int width = array[0].length();
      Arrays.stream(array).forEach((s -> {
         if (s.length() != width) throw new RuntimeException("String of incorrect width found");
      }));
      return width;
   }
}
