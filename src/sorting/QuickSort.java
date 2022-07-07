package sorting;

import java.util.Arrays;

public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quicksort(T[] array, int left, int right) {

        if (left < right) {
            T pivot = array[(left + right) / 2];
            int index = partition(array, left, right, pivot);
            quicksort(array, left, index - 1);
            quicksort(array, index, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right, T pivot) {

        while (left <= right) {

            while (array[left].compareTo(pivot) < 0)
                left++;


            while (array[right].compareTo(pivot) > 0)
                right--;

            if (left <= right) {
                T temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        Integer[] array = {2, 4, 2, 1, 1, 1, 0, 10, 5, 6, 8, 2, 34, 9};

        QuickSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
