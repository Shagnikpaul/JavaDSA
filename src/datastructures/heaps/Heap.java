package datastructures.heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void sinkDown(int index) {

        int maxIndex = index;

        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);
            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (index != maxIndex) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

    public int remove() {
        if (heap == null) {
            return -1;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        else {
            int k = heap.get(0);
            swap(0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            sinkDown(0);
            return k;
        }
    }

}
