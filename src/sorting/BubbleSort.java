package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static <T extends Comparable<T>> void sort(T[] array) {

        for (int i = array.length - 1; i > 0; i--) {

            boolean swapped = false;

            for (int j = 0; j < i; j++) {

                if (array[j + 1].compareTo(array[j]) < 0) {
                    T temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }


    public static void main(String[] args) {
        Integer[] array = {2, 4, 2, 1, 1, 1, 0, 10, 5, 6, 8, 2, 34, 9};

        BubbleSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
