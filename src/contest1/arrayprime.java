
import java.util.Arrays;

public class arrayprime {
    public static void main(String[] args) {
        int nums[] = { -1, 5, 7, 0 };
        int n = nums.length;
        int prime[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prime[i] = 1;
        }

        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= n; j = j + i) {
                    prime[j] = 0;
                }
            }
        }

        System.out.println(Arrays.toString(prime));

        long aSum = 0;
        long bSum = 0;

        if (nums.length >= 2) {
            bSum = nums[0] + nums[1];
        } else {
            if (nums.length == 0) {
                // return 0;
            } else {
                bSum += nums[0];
            }
        }

        
        for (int i = 2; i < nums.length; i++) {
            if (prime[i] == 1) {
                aSum += nums[i];
            } else {
                bSum += nums[i];
            }
        }

        System.out.println("A sum = " + aSum + " B sum " + bSum);
        System.out.println("Abs diff = " + Math.abs(aSum - bSum));
    }
}
