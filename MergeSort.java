// MergeSort alg....
// Armando be trying to write a mergeSort.

import java.lang.reflect.Array;

public class MergeSort<T extends Comparable<? super T>> {
    public static <T extends Comparable<? super T>> T[] mergeSort(T[] array) {
        if (array.length == 1) {
            return array;
        }
        
        @SuppressWarnings("unchecked")
        T[] arrayOne = (T[]) Array.newInstance(array[0].getClass(), array.length / 2);
        @SuppressWarnings("unchecked")
        T[] arrayTwo = (T[]) Array.newInstance(array[0].getClass(), array.length - arrayOne.length);
        
        for (int i = 0; i < arrayOne.length; i++) {
            arrayOne[i] = array[i];
        }
        for (int i = 0; i < arrayTwo.length; i++) {
            arrayTwo[i] = array[arrayOne.length + i];
        }

        return mergeSort(arrayOne, arrayTwo);
    }
        public static <T extends Comparable<? super T>> T[] mergeSort(T[] arrayOne, T[] arrayTwo) {
        
        if (arrayOne.length == 1 && arrayTwo.length == 1) {
            
            @SuppressWarnings("unchecked")
            T[] newList = (T[]) Array.newInstance(arrayOne[0].getClass(), 2);
            
            if (arrayOne[0].compareTo(arrayTwo[0]) >= 0) {
                newList[0] = arrayTwo[0];
                newList[1] = arrayOne[0];
            } else {
                newList[0] = arrayOne[0];
                newList[1] = arrayTwo[0];
            }

            return newList;

        } else {
            
            @SuppressWarnings("unchecked")
            T[] newList = (T[]) Array.newInstance(arrayOne[0].getClass(), arrayOne.length + arrayTwo.length);
            newList = combine(mergeSort(arrayOne), mergeSort(arrayTwo));
            return newList;
        }
    }
    
    private static <T extends Comparable<? super T>> T[] combine(T[] arg1, T[] arg2) {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(arg1[0].getClass(), arg1.length + arg2.length);
        
        int left = 0;
        int right = 0;
        int pointer = 0;
        // This is where the magic happens!
        while (pointer < result.length) {
            while (left < arg1.length) {
                while (right < arg2.length && arg1[left].compareTo(arg2[right]) > 0) {
                    result[pointer] = arg2[right];
                    pointer++; right++;
                }
                result[pointer] = arg1[left];
                pointer++; left++;
            }
            while (right < arg2.length) {
                result[pointer] = arg2[right];
                pointer++; right++;
            }
        }
        return result;
    }
}