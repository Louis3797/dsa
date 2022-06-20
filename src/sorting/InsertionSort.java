package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static <T extends Comparable<T>> void sort(T[] array) {

        for (int i = 1; i < array.length; i++) {

            T temp = array[i];
            int prevIndex = i - 1;

            while (prevIndex >= 0 && array[prevIndex].compareTo(temp) > 0){
                array[prevIndex + 1] = array[prevIndex];
                prevIndex -=1;
            }

            array[prevIndex + 1] = temp;
        }
    }


    public static void main(String[] args) {
        Integer[] array = {2, 4, 2, 1, 1, 1, 0, 10, 5, 6, 8, 2, 34, 9};

        InsertionSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
