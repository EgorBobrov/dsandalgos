package com.egobob.dsandalgos.sort;

/**
 * An implementation of Bubble Sort, a stable sorting algorithm with a quadratic time complexity.
 * It sorts array in-place by dividing it into unsorted (left) and sorted (right) part and slowly growing the sorted part.
 * We start from the the leftmost element and compare it to its neighbor to the right.
 * If the left one is bigger, we swap them. If not, we leave them in place.
 * Next, we look at the right element and its neighbor to the right.
 * We continue until we hit the last element of the unsorted part. Now, it belongs to the sorted part.
 * We repeat until size of the unsorted part is 0.
 */
public class BubbleSortImplementation extends IntArraySortingAlgorithm {

   @Override
   public void sort(Integer[] array) {
      if (noReasonToSort(array)) return;

      // last index of the unsorted partition - at the beginning the array is unsorted, so it's simply the last index in the array
      for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
         for (int i = 0; i < lastUnsortedIndex; i++) {
            if (array[i] > array[i + 1]) {
               swapElements(array, i, i + 1);
            }
         }
      }
   }


}
