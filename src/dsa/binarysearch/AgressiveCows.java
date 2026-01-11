package dsa.binarysearch;

import java.util.TreeSet;

public class AgressiveCows {

    public static boolean isValid(int[] stalls, int cows, int dist) {
        int lastCow = stalls[0];
        int cowCnt = 1;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastCow >= dist) {
                lastCow = stalls[i];
                cowCnt++;
                if (cowCnt == cows) {
                    return true;
                }
            }
        }
        if (cowCnt == cows) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 9, 10};
        int cows = 4;
        int low = 0;
        int high = 10;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (isValid(stalls, cows, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        TreeSet<Integer> i = new TreeSet<>();
        
        System.out.println("Valid max of the min distances to place the cows  : " + high);
    }
}
