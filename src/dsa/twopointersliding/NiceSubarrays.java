package dsa.twopointersliding;

public class NiceSubarrays {
    public static void main(String[] args) {
        int nums[] = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int goal = 2;
        System.out.println(countSubarrays(nums, goal) - countSubarrays(nums, goal - 1));
    }

    public static int countSubarrays(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int l = 0, r = 0;
        int count = 0;
        int Oddsum = 0;
        for (; r < nums.length; r++) {
            if (nums[r] % 2 != 0)
                Oddsum++;

            while (Oddsum > goal) {
                if (nums[l] % 2 != 0)
                    Oddsum--;
                l++;
            }

            count = count + (r - l + 1); // include all combinations...
        }

        return count;
    }
}
