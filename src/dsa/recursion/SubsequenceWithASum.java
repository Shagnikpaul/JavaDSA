package dsa.recursion;

import java.util.ArrayList;



/*
 * Only one subsequence will be printed below due to boolean return type... make it void to get all possible subsequences....
 *
 * */


public class SubsequenceWithASum {


    public static int countSequencesWithSum(int ind, int[] arr, ArrayList<Integer> l, int currentSum, int targetSum) {
        if (ind >= arr.length) {
            if (currentSum == targetSum) {
                return 1;
            } else {
                return 0;
            }
        }
        if (currentSum == targetSum) {
            return 1;
        } else {
            l.add(arr[ind]);
            currentSum += arr[ind];
            int lef = countSequencesWithSum(ind + 1, arr, l, currentSum, targetSum);
            currentSum -= arr[ind];
            l.remove(l.size() - 1);
            int ri = countSequencesWithSum(ind + 1, arr, l, currentSum, targetSum);
            return lef + ri;
        }
    }


    public static boolean findSubseq(int ind, int[] arr, ArrayList<Integer> l, int currentSum, int targetSum) {
        if (ind >= arr.length) {
            if (currentSum == targetSum) {
                System.out.println("Yes this subsequence satisfies the sum condition: " + l.toString());
                return true;
            } else {
                return false;
            }

        }
        if (currentSum == targetSum) {
            System.out.println("Yes this subsequence satisfies the sum condition: " + l.toString());
            return true;
        } else {
            l.add(arr[ind]);
            currentSum += arr[ind];
            if (!findSubseq(ind + 1, arr, l, currentSum, targetSum)) {
                l.remove(l.size() - 1);
                currentSum -= arr[ind];
                return findSubseq(ind + 1, arr, l, currentSum, targetSum);
            } else {
                return true;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int targetSum = 2;
        ArrayList<Integer> l = new ArrayList<>();
        System.out.printf("Total subsequences with sum of %d = %d", targetSum, countSequencesWithSum(0, arr, l, 0, targetSum));
    }
}
