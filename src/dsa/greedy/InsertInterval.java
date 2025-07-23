package dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.SortedSet;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ArrayList<Integer> k = new ArrayList<>();
            k.add(intervals[i][0]);
            k.add(intervals[i][1]);
            res.add(k);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        ArrayList<Integer> k = new ArrayList<>();
        k.add(newInterval[0]);
        k.add(newInterval[1]);
        res.add(k);

        while (i < intervals.length) {
            ArrayList<Integer> ki = new ArrayList<>();
            ki.add(intervals[i][0]);
            ki.add(intervals[i][1]);
            res.add(ki);
            i++;
        }

        int ans[][] = new int[res.size()][res.size()];

        for (i = 0; i < ans.length; i++) {
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);

        }

        System.out.println(res.toString());

    }
}
