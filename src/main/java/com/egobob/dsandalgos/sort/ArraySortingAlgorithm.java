package com.egobob.dsandalgos.sort;

public abstract class ArraySortingAlgorithm<T> {

   public abstract void sort(T[] array);

   boolean noReasonToSort(T[] array) {
      return (array == null || array.length < 2);
   }

   void swapElements(T[] array, int firstIndex, int secondIndex) {
      if(firstIndex == secondIndex) return;
      T secondValueHolder = array[secondIndex];
      array[secondIndex] = array[firstIndex];
      array[firstIndex] = secondValueHolder;
   }

}
