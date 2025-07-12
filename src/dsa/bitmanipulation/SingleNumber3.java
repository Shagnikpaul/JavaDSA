package dsa.bitmanipulation;



public class SingleNumber3 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 2, 5 };

        long totalXOR = 0;

        for (int i : nums) {
            totalXOR = totalXOR ^ i;
        }

        int rightmost = ((int) totalXOR & ((int) totalXOR - 1)) ^ (int) totalXOR;

        int b1 = 0;
        int b2 = 0;

        for (int i : nums) {
            if ((i & rightmost) != 0) {
                b1 ^= i;
            } else {
                b2 ^= i;
            }
        }
        System.out.println("b1 = " + b1 + " b2 = " + b2);
    }
}