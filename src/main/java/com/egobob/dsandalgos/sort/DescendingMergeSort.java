package com.egobob.dsandalgos.sort;

/**
 * Merge Sort is a stable sorting algorithm with n-log time complexity.
 * It's not in-place, because it requires memory for temporary arrays during the merge phase.
 * The algorithm consists of 2 phases. First, the array is logically divided into subarrays of size 1.
 * Then, the subarrays are merged together, at which point the sorting is taking place.
 * This variation of Merge Sort sorts the values in descending order.
 */
public class DescendingMergeSort extends IntArraySortingAlgorithm {
   @Override
   public void sort(Integer[] array) {
      if (noReasonToSort(array)) return;
      mergeSort(array, 0, array.length);
   }

   private void mergeSort(Integer[] array, int leftStart, int rightEnd) {
      if (rightEnd - leftStart < 2) {
         return;
      }

      int rightStart = (leftStart + rightEnd) / 2;
      mergeSort(array, leftStart, rightStart);
      mergeSort(array, rightStart, rightEnd);

      merge(array, leftStart, rightStart, rightEnd);
   }

   void merge(Integer[] array, int leftStart, int rightStart, int rightEnd) {

      // we are merging 2 arrays sorted in a descending order.
      // If the smallest element of the left array is bigger or equal than the biggest element of the right array,
      // there is nothing to be done here: elements of both arrays are already sorted taken together.
      if (array[rightStart - 1] >= array[rightStart]) {
         return;
      }

      Integer[] tempArray = new Integer[rightEnd - leftStart];
      int leftIndex = leftStart;
      int rightIndex = rightStart;
      int tempIndex = 0;

      // copying the smallest current element from one of the merging arrays to the current index of the temporary array
      while (leftIndex < rightStart && rightIndex < rightEnd) {
         tempArray[tempIndex++] = array[leftIndex] >= array[rightIndex] ? array[leftIndex++] : array[rightIndex++];
      }

      // if one of the arrays ended, we just copy the remaining elements from the remaining array to our temp array
      if (leftIndex >= rightStart) {
         System.arraycopy(array, rightIndex, tempArray, tempIndex, tempArray.length - tempIndex);
      } else {
         System.arraycopy(array, leftIndex, tempArray, tempIndex, tempArray.length - tempIndex);
      }
      // copy sorted elements from the temp array to the original array
      System.arraycopy(tempArray, 0, array, leftStart, tempArray.length);
   }

}
