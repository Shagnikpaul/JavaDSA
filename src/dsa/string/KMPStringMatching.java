package dsa.string;

import java.util.Arrays;

public class KMPStringMatching {


    public static int[] pi(String s) {
        int i = 1;
        int j = 0;
        int[] pi = new int[s.length()];
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                pi[i] = j + 1;
                i++;
                j++;
            } else {
                if (j > 0)
                    j = pi[j - 1];
                else
                    i++;
            }
        }
        return pi;
    }

    public static void main(String[] args) {
        String pattern = "bba";
        int[] p = pi(pattern);
        System.out.println(Arrays.toString(p));
    }
}
