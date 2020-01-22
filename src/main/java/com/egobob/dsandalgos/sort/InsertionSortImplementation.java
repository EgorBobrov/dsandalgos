package com.egobob.dsandalgos.sort;

/**
 * Insertion Sort is an in-place stable sorting algorithm with a quadratic time complexity.
 * It works by dividing the array into sorted and unsorted parts and growing the sorted part.
 * Unlike in Bubble and Selection sorts, the sorted part at the beginning contains one element: the first element of the array.
 * The algorithm looks at the first element in the unsorted part, finds its proper position in the sorted part, and inserts it there.
 * If the values are (almost) sorted, it runs in a linear time.
 */
public class InsertionSortImplementation extends IntArraySortingAlgorithm {

   @Override
   public void sort(Integer[] array) {
      if (noReasonToSort(array)) return;

      for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
         int valueToInsert = array[firstUnsortedIndex];
         int insertionIndex;
         for (insertionIndex = firstUnsortedIndex; insertionIndex > 0 &&
               valueToInsert <= array[insertionIndex - 1];
              insertionIndex--) {
            array[insertionIndex] = array[insertionIndex - 1]; // moving current element to the right to free place for the insertion
         }
         // now we have the proper insertion index and we put the value there
         array[insertionIndex] = valueToInsert;
      }

   }
}
