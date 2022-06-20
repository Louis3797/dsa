package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] array) {

        int len = array.length;

        for (int i = 0; i < len - 1; i++) {

            int minPos = i;

            for (int j = i + 1; j < len; j++) {
                if (array[j].compareTo(array[minPos]) < 0) {
                    minPos = j;
                }
            }

            T temp = array[minPos];
            array[minPos] = array[i];
            array[i] = temp;
        }
    }


    public static void main(String[] args) {
        Integer[] array = {2, 4, 2, 1, 1, 1, 0, 10, 5, 6, 8, 2, 34, 9};

        SelectionSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
