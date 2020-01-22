package com.egobob.dsandalgos.sort;

public class RecursiveInsertionSort extends IntArraySortingAlgorithm {

   @Override
   public void sort(Integer[] array) {
      if (noReasonToSort(array)) return;
      recursiveInsertionSort(array, 1);
   }

   private void recursiveInsertionSort(Integer[] array, int firstUnsortedIndex) {
      if (firstUnsortedIndex >= array.length) {
         return;
      }
      if (array[firstUnsortedIndex] < array[firstUnsortedIndex - 1]) {
         insert(array, array[firstUnsortedIndex], firstUnsortedIndex);
      }
      recursiveInsertionSort(array, firstUnsortedIndex + 1);
   }

   private void insert(Integer[] array, int valueToInsert, int firstUnsortedIndex) {
      if (firstUnsortedIndex == 0) {
         array[firstUnsortedIndex] = valueToInsert;
         return;
      }
      array[firstUnsortedIndex] = array[firstUnsortedIndex - 1];
      if (array[firstUnsortedIndex - 1] <= valueToInsert) {
         array[firstUnsortedIndex] = valueToInsert;
      } else {
         insert(array, valueToInsert, firstUnsortedIndex - 1);
      }
   }
}
