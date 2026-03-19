package dsa.dailyproblems;

public class BinaryGap {
    public static void main(String[] args) {
        int n = 5;
        int last = -1;
        int max = 0;
        int i = 1;
        while (n != 0) {
            int d = n % 2;
            if (d == 1) {
                if (last != -1) {
                    max = Math.max(i - last, max);
                }
                last = i;
            }
            i++;
            n /= 2;
        }
        System.out.println("Max distance : " + max);
    }
}
