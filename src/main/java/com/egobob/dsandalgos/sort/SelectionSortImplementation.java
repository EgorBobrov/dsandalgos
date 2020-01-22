package com.egobob.dsandalgos.sort;

/**
 * An implementation of Selection Sort, an unstable sorting algorithm with a quadratic time complexity.
 * It sorts array in-place by dividing it into unsorted (left) and sorted (right) part and slowly growing the sorted part.
 * Compared to bubble sort, it doesn't require as much swapping, so it's usually faster than bubble sort, but is unstable.
 * It goes through every element in the unsorted part and selects the largest one.
 * Then, it swaps it with the last element of the unsorted part. Now, the last element belongs to the sorted partition.
 */
public class SelectionSortImplementation extends IntArraySortingAlgorithm {

   @Override
   public void sort(Integer[] array) {
      if (noReasonToSort(array)) return;

      for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
         // for now, we consider that the largest value is the first element of the array
         int largestValueIndex = 0;
         // we use <= because the last element in the unsorted partition can hold the largest value, and we don't want to swap it for second-largest
         for (int i = 1; i <= lastUnsortedIndex; i++) {
            if (array[i] > array[largestValueIndex]) {
               largestValueIndex = i;
            }
         }
         swapElements(array, largestValueIndex, lastUnsortedIndex);
      }
   }
}
