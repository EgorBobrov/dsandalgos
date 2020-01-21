package com.egobob.dsandalgos.sort;

/**
 * Radix Sort is a linear-time sorting algorithm which makes assumptions about the data it's sorting.
 * To use Radix sort, all data should have the same width (number of digits if integers or length if strings)
 * and radix (range of possible values - usually 0-9 for integers and A-z for strings).
 * Radix sort uses stable variation of counting sort to repeatedly sort data n times (where n = width), starting from the
 * least significant (rightmost) digit/symbol and ending with sorting by the most significant (leftmost).
 * Because of use of linear-time algorithm (counting sort) the time of sorting for radix sort is (width * C * n), so, technically, it's linear.
 * But the overhead and restrictions on data width and radix limit its practical use.
 */
public class RadixSort extends IntArraySortingAlgorithm {

   @Override
   public void sort(int[] array) {
      if (noReasonToSort(array)) return;

      int width = calculateWidth(array);
      int radix = 10;

      radixSort(array, width, radix);
   }

   public void radixSort(int[] array, int radix, int width) {
      // for each position, from rightmost to leftmost, sort by this position using stable counting sort
      for (int i = 0; i < width; i++) {
         radixSingleSort(array, i, radix);
      }
   }

   private void radixSingleSort(int[] array, int position, int radix) {
      int numberOfItems = array.length;
      int[] countArray = new int[radix];

      for (int value: array) {
         countArray[getDigit(position, value, radix)]++;
      }

      // adjust the count array so instead of containing number of certain digits
      // it contains number of digit which are equal or less than current digit
      for (int i = 1; i < radix; i++) {
         countArray[i] += countArray[i - 1];
      }

      // stable counting sort
      int[] tempArray = new int[numberOfItems];
      for(int tempIndex = numberOfItems - 1; tempIndex >= 0; tempIndex--) {
         tempArray[--countArray[getDigit(position, array[tempIndex], radix)]] = array[tempIndex];
      }

      System.arraycopy(tempArray, 0, array, 0, numberOfItems);
   }

   // this method takes the value, divides it by radix in the power of the current digit position (the rightmost digit is in the position 0)
   // and takes a remainder of the division of this thing by radix, effectively giving us the digit in the specified position.
   // for example, if the value is 4250, the position is 1 (radix is 10) we get the digit in the position 1 from the right, which is 5.
   private int getDigit(int position, int value, int radix) {
      return (value / (int) Math.pow(radix, position)) % radix;
   }

   private int calculateWidth(int[] array) {
      int width = calculateIntWidth(array[0]);
      for (int i = 1; i < array.length; i++) {
         if(calculateIntWidth(array[i]) != width) {
            throw new RuntimeException("Not all elements are of the same width, aborting execution.");
         }
      }
      return width;
   }

   private int calculateIntWidth(int i) {
      int width = 0;
      while (i > 0) {
         i /= 10;
         width++;
      }
      return width;
   }

}
