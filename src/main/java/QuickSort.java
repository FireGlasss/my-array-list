
/**
 * The QuickSort class represents the quicksort algorithm.
 * It uses the divide and conquer principle, dividing the array into subarrays,
 * sorting them separately, and then merging the sorted subarrays into one sorted array.
 */

public class QuickSort {

    /**
     * Method for calling the quicksort.
     * It takes a MyList object containing elements to be sorted,
     * and calls the private quickSort method to sort the entire array.
     *
     * @param array MyList object containing elements to be sorted
     * @param <T> type of array elements, must implement the Comparable interface
     */
    public static <T extends Comparable<T>> void quickSort(MyList<T> array) {
        quickSort(array,0, array.getSize() - 1);
    }

    /**
     * Private method for recursive quicksort.
     * It takes a MyList object containing elements to be sorted,
     * as well as the lower and upper bounds of the sorting part of the array.
     *
     * @param array MyList object containing elements to be sorted
     * @param low lower bound of the sorting part of the array
     * @param high upper bound of the sorting part of the array
     * @param <T> type of array elements, must implement the Comparable interface
     */
    private static <T extends Comparable<T>> void quickSort(MyList<T> array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * Private method for partitioning the array into subarrays.
     * It selects a pivot element (the last element of the array),
     * and moves all elements smaller than the pivot to the left of it,
     * and all elements greater than the pivot to the right of it.
     *
     * @param array MyList object containing elements to be sorted
     * @param low lower bound of the sorting part of the array
     * @param high upper bound of the sorting part of the array
     * @param <T> type of array elements, must implement the Comparable interface
     * @return index of the pivot element after partitioning
     */
    private static <T extends Comparable<T>> int partition(MyList<T> array, int low, int high) {
        T pivot = array.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array.get(j).compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    /**
     * Private method for swapping array elements.
     * It takes a MyList object containing elements to be sorted,
     * as well as the indices of two elements to be swapped.
     *
     * @param array MyList object containing elements to be sorted
     * @param i index of the first element to be swapped
     * @param j index of the second element to be swapped
     * @param <T> type of array elements
     */
    private static <T> void swap(MyList<T> array, int i, int j) {
        T temp = array.get(i);
        array.set(array.get(j), i);
        array.set(temp, j);
    }
}



