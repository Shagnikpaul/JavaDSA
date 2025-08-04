package dsa.twopointersliding;

public class TwoSumArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = 1;

        while (r < numbers.length) {
            if (numbers[l] + numbers[r] < target) {
                l++;
                r++;
            } else if (numbers[l] + numbers[r] > target) {
                l--;

            } else {
                return new int[] { (l + 1), (r + 1) };
            }

        }
        return new int[] { (l + 1), (r + 1) };
    }
}
