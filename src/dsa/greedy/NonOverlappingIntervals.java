package dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class ArrayComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return a[1] - b[1];
    }
}

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        Arrays.sort(intervals, new ArrayComparator());
        int c = 1;

        int ltime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= ltime) {
                ltime = intervals[i][1];
                c++;
            } 

        }

        System.out.println(c);
    }
}
