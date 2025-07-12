package dsa.bitmanipulation;

public class SingleNumber2 {
    public static void main(String[] args) {
        int[] nums = { 30000, 500, 100, 30000, 100, 30000, 100 };

        long totalXOR = 0;
        for (int i : nums) {
            totalXOR ^= i;
        }
        System.out.println("Total XOR = " + totalXOR);
        for (int i : nums) {
            int k = (int) totalXOR ^ i;
            k = (k & (k - 1));
            if (k == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
