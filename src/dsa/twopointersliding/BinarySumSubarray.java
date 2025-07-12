package dsa.twopointersliding;

public class BinarySumSubarray {
    public static void main(String[] args) {
        int nums[] = { 1, 0, 1, 0, 1
        };
        int k = 2;
        System.out.println(countSubarrays(nums, k) - countSubarrays(nums, k - 1));
    }

    public static int countSubarrays(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int l = 0, r = 0;
        int count = 0;
        int sum = 0;
        for (; r < nums.length; r++) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            count = count + (r - l + 1); // include all combinations...
        }

        return count;
    }
}
