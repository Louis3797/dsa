package sorting;

import java.util.Arrays;

public class HeapSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        // Build heap (rearrange array)
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);

        // One by one extract an element from heap
        for (int i = array.length - 1; i > 0; i--) {
            // Move current root to end
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    public static <T extends Comparable<T>> void heapify(T[] array, int size, int i) {
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // if left child is larger than root
        if (left < size && array[left].compareTo(array[root]) > 0)
            root = left;

        // if right child is larger than max
        if (right < size && array[right].compareTo(array[root]) > 0)
            root = right;

        // if root is not root
        if (root != i) {
            // swap
            T temp = array[i];
            array[i] = array[root];
            array[root] = temp;

            // recursively heapify the affected sub-tree
            heapify(array, size, root);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {2, 4, 2, 1, 1, 1, 0, 10, 5, 6, 8, 2, 34, 9};

        HeapSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
