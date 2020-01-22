package com.egobob.dsandalgos.sort;

/**
 * Quicksort is an unstable in-place sorting algorithm with n-log complexity.
 * In the worst case (when the pivot is the smallest or the largest element every time) it can degrade to quadratic complexity.
 * It usually performs better than mergesort.
 * It works by designating some element as the pivot and going from left to right selecting elements that are bigger than pivot
 * and from right to left selecting elements that are smaller than the pivot, and moving them to the right and left parts of the array.
 * When right and left indices meet, the proper position of the pivot is located.
 * Then, the same process is repeated for right and left parts of the array, until every element has been the pivot and, because of that,
 * is at its proper position.
 */
public class QuickSortImplementation extends IntArraySortingAlgorithm {

   @Override
   public void sort(Integer[] array) {
      if (noReasonToSort(array)) return;
      quickSort(array, 0, array.length);
   }

   private void quickSort(Integer[] array, int startIndex, int endIndex) {
      if (endIndex - startIndex < 2) return;

      int pivotIndex = partition(array, startIndex, endIndex);
      quickSort(array, startIndex, pivotIndex);
      quickSort(array, pivotIndex + 1, endIndex);
   }

   private int partition(Integer[] array, int startIndex, int endIndex) {
      int pivot = array[startIndex];

      int leftIndex = startIndex;
      int rightIndex = endIndex;

      while (leftIndex < rightIndex) {

         // empty loop for decrementing rightIndex
         while (leftIndex < rightIndex && array[--rightIndex] >= pivot);
         if (leftIndex < rightIndex) {
            array[leftIndex] = array[rightIndex];
         }
         // empty loop for incrementing leftIndex
         while (leftIndex < rightIndex && array[++leftIndex] <= pivot);
         if (leftIndex < rightIndex) {
            array[rightIndex] = array[leftIndex];
         }
      }
      array[rightIndex] = pivot;

      return rightIndex;
   }
}
