package acc2_cat2;


import java.util.Arrays;

public class KaryHeap {
    static int n;

    public void heapify(int i, int n, int k, int[] arr) {
        int largest = i;
        for (int j = 1; j <= k; j++) {
            if ((k * i + j) < n && arr[largest] < arr[k * i + j]) {
                largest = k * i + j;
            }
        }
        if (largest != i) {
            int t = arr[largest];
            arr[largest] = arr[i];
            arr[i] = t;
            heapify(largest, n, k, arr);
        }
    }

    public static int getMax(int[] arr, int k) {
        int max = arr[0];
        int t = arr[0];
        arr[0] = arr[n - 1];
        n--;
        new KaryHeap().heapify(0, n, k, arr);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 2, 0, 1, 9};
        n = arr.length;
        int k = 2;
        for (int i = n / k - 1; i >= 0; i--) {
            new KaryHeap().heapify(i, n, k, arr);
        }
        System.out.println("Max element : " + getMax(arr, k));
        System.out.println("Second Max element : " + getMax(arr, k));
        System.out.println("Current heap : " + Arrays.toString(arr));
    }
}
