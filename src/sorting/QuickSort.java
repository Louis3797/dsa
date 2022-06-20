package sorting;

import java.util.Arrays;

public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] array) {

    }


    public static void main(String[] args) {
        Integer[] array = {2, 4, 2, 1, 1, 1, 0, 10, 5, 6, 8, 2, 34, 9};

        QuickSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
