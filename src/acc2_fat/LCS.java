package acc2_fat;

public class LCS {
    public static int dp(String a, String b, int i, int j) {
        if (i == a.length() || j == b.length())
            return 0;
        if (a.charAt(i) == b.charAt(j))
            return 1 + dp(a, b, i + 1, j + 1);
        else
            return Math.max(dp(a, b, i + 1, j), dp(a, b, i, j + 1));
    }

    public static void main(String[] args) {

    }
}
