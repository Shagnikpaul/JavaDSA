package dsa.twopointersliding;

public class LongestConsecutiveOnesWithZeroes {
    public static void main(String[] args) {
        int nums[] = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int l = 0, r = 0;
        int maxLength = -1;
        int k = 3;
        int zeros = 0;
        for (; r < nums.length; r++) {
            if (nums[r] == 0)
                zeros++;
            if (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            if (zeros <= k) {
                if ((r - l + 1) > maxLength)
                    maxLength = r - l + 1;
            }
        }
        System.out.println("Max Length = " + maxLength);
    }
}
