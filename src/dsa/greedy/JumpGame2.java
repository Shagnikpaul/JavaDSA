package dsa.greedy;

public class JumpGame2 {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 1 };

        int position = 0;
        int count = 0;
        while (position < nums.length - 1) {
            int bestStep = 1;
            int maxDistance = -1;
            for (int i = 1; i <= nums[position]; i++) {
                // System.out.println("position + i = " + (position + i));
                if (position + i >= nums.length - 1) {
                    // System.out.println("ran");
                    count++;
                    System.out.println("Steps : " + count);
                    return;
                }
                if ((nums[position + i] + position + i) > maxDistance) {
                    maxDistance = nums[position + i] + position + i;
                    bestStep = i;
                }
            }
            position += bestStep;
            System.out.println("Went to " + position);
            count++;
        }

        System.out.println("Steps : " + count);
    }
}
