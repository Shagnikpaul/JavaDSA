package dsa.dp.strings;

public class LongestSubstring {

    static int max = 0;

    public static int lcsSubstring(String s1, String s2, int i, int j, int count) {
        if (i < 0 || j < 0) {
            return count;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            count = lcsSubstring(s1, s2, i - 1, j - 1, count + 1);
            max = Math.max(max, count);
        }

        lcsSubstring(s1, s2, i - 1, j, 0);
        lcsSubstring(s1, s2, i, j - 1, 0);

        return max;
    }


    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        System.out.println("Ans : " + lcsSubstring(s1, s2, s1.length() - 1, s2.length() - 1, 0));

    }
}
