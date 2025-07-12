package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println("Combination :D");
        int[] candidates = { 2, 3, 6, 7 };
        Arrays.sort(candidates);
        int target = 7;
        System.out.println(getCombination(candidates, target));
    }

    public static ArrayList<Integer> getCombination(int[] candidates, int target) {
        return null;
    }
}
