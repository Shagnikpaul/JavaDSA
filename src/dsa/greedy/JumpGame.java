package dsa.greedy;

public class JumpGame {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 1, 1, 4 };

        int maxIndex = 0;

        int i = 0;
        while (i <= maxIndex) {
            if (nums[i] + i > maxIndex) {
                maxIndex = nums[i] + i;
                if(maxIndex >= nums.length - 1)
                return; // ture
            }
            i++;
        }
        return; // false
    }
}
