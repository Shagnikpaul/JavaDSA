package acc2_cat2;

import java.util.Arrays;

public class HeapSort {


    public void heapify(int i, int n, int[] arr) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < n && arr[largest] < arr[right]) {
            largest = right;
        }

        // if any of the child is larger than parent meaning the largest nums index is still i else diff... then swap it...
        if (largest != i) {
            int t = arr[largest];
            arr[largest] = arr[i];
            arr[i] = t;
            //subtree below the fixed index might be broken so fix it...
            heapify(largest, n, arr);
        }
    }

    public void sort(int[] arr) {
        int n = arr.length;

        // n/2 -1 is the last non leaf element...
        // leaves already satisfy heap property no need to fix them
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i, n, arr);
        }

        for (int i = n - 1; i > 0; i--) {
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            heapify(0, i, arr); // not i+1 cuz last element was already sorted don't include it in heap....
        }
    }


    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 1, 0, 7, 2};
        new HeapSort().sort(arr);
        System.out.println("Sorted : " + Arrays.toString(arr));
    }
}
