package com.egobob.dsandalgos.sort;

public abstract class StringArraySortingAlogrithm {

   public abstract void sort(String[] array);

   boolean noReasonToSort(String[] array) {
      return (array == null || array.length < 2);
   }


}
