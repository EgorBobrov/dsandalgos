package com.egobob.dsandalgos.sort;

/**
 * Shell sort is an improvement of Insertion sort. The Insertion sort works much faster if the array is mostly sorted.
 * Shell sort brings elements of the array closer to the state of being sorted.
 * Then, the regular Insertion sort is run on the more-sorted array.
 * Gap value is the index of the first unsorted element and the index shift between current element and the next.
 * If the gap value = 1, we simply have Insertion sort. We compare it to the [gap-gap] element, which is 0.
 * Then, we move to [gap + gap] element, which is 2, and compare it with the [gap + gap - gap] element, which is 1, and so on.
 * If it's 3, we start with the element at the position 3, and compare it with element in a position 0. Then, we move to element 6, and so on.
 *
 */
public class ShellSortImplementation extends IntArraySortingAlgorithm {

   @Override
   public void sort(Integer[] array) {

      if (noReasonToSort(array)) return;

      for (int gapValue = array.length / 2; gapValue > 0; gapValue /= 2) {

         // the code below is essentially the same as the code for Insertion Sort.
         // The only change is the use of "gapValue" instead of 1 as the initial value for the first unsorted index
         for (int firstUnsortedIndex = gapValue; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int valueToInsert = array[firstUnsortedIndex];
            int insertionIndex = firstUnsortedIndex;
            while (insertionIndex >= gapValue && array[insertionIndex - gapValue] > valueToInsert) {
               array[insertionIndex] = array[insertionIndex - gapValue];
               insertionIndex -= gapValue;
            }
            array[insertionIndex] = valueToInsert;
         }

      }

   }
}
