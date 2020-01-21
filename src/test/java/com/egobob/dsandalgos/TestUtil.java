package com.egobob.dsandalgos;

import java.util.Arrays;
import java.util.Random;

public final class TestUtil {

   private static final Random RANDOM = new Random();

   public static int[] generateIntArray() {
      return generateIntArray(40);
   }

   public static int[] generateIntArray(int size) {
      return generateLimitedIntArray(-100, 100, size);
   }

   public static int[] generateLimitedIntArray(int fromIncluded, int toExcluded, int size) {
      return RANDOM.ints(fromIncluded, toExcluded)
            .limit(size)
            .toArray();
   }

   public static int[] reverseArray(int[] array) {
      if (array.length < 2) return array;
      for (int i = 0; i < array.length / 2; i++) {
         int temp = array[i];
         array[i] = array[array.length - i - 1];
         array[array.length - i - 1] = temp;
      }
      return array;
   }

   public static String[] generateStringArray(int arraySize) {
      return generateLimitedStringArray(arraySize,4, 'a', 'z');
   }

   public static String[] generateLimitedStringArray(int arraySize, int stringLength, int leftBound, int rightBound) {
      String[] strings = new String[arraySize];
      for (int i = 0; i < arraySize; i++) {
         StringBuilder builder = new StringBuilder();
         RANDOM.ints(leftBound, rightBound + 1).limit(stringLength)
               .forEach(number -> builder.append((char) number));
         strings[i] = builder.toString();
      }
      return strings;
   }


}
