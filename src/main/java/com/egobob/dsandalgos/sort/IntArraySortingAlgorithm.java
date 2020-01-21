package com.egobob.dsandalgos.sort;

public abstract class IntArraySortingAlgorithm {

   public abstract void sort(int[] array);

   boolean noReasonToSort(int[] array) {
      return (array == null || array.length < 2);
   }

   void swapElements(int[] array, int firstIndex, int secondIndex) {
      if(firstIndex == secondIndex) return;
      int secondValueHolder = array[secondIndex];
      array[secondIndex] = array[firstIndex];
      array[firstIndex] = secondValueHolder;
   }

}
