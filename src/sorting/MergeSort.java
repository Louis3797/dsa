package sorting;

import java.util.Arrays;

public class MergeSort {


    /**
     * Helper method
     *
     * @param array array we want to sort
     * @param <T>   Generic Type
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * Method sorts array through merge sort
     *
     * @param array given array
     * @param left  left index
     * @param right right index
     * @param <T>   Generic Type
     */
    public static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        // base case
        if (left < right) {
            // find the middle
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle); // sort left half
            mergeSort(array, middle + 1, right);  // sort right half

            // merge left and right
            merge(array, left, middle, right);
        }
    }

    /**
     * This method merges left and right half in main array
     *
     * @param array  array
     * @param left   left boundary
     * @param middle middle
     * @param right  right boundary
     * @param <T>    Generic Type
     */
    public static <T extends Comparable<T>> void merge(T[] array, int left, int middle, int right) {

        int lenLeft = middle - left + 1;
        int lenRight = right - middle;

        T[] leftArray = (T[]) new Comparable[lenLeft];
        T[] rightArray = (T[]) new Comparable[lenRight];

        // fill in left array
        System.arraycopy(array, left, leftArray, 0, lenLeft);

        // fill in right array
        System.arraycopy(array, middle + 1, rightArray, 0, lenRight);

        int leftIndex = 0, rightIndex = 0;

        int currentIndex = left;

        // put values of left and right array back in main array in sorted order
        while (leftIndex < lenLeft && rightIndex < lenRight) {
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0) {
                array[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }

        // copy remaining elements of leftArray
        while (leftIndex < lenLeft)
            array[currentIndex++] = leftArray[leftIndex++];

        // copy remaining elements of rightArray
        while (rightIndex < lenRight)
            array[currentIndex++] = rightArray[rightIndex++];
    }


    public static void main(String[] args) {
        Integer[] array = {2, 4, 2, 1, 1, 1, 0, 10, 5, 6, 8, 2, 34, 9};

        MergeSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
