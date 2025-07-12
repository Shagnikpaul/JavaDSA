package dsa.bitmanipulation;

public class DivisionWithoutOperators {
    public static void main(String[] args) {
        int dividend = 22;
        int divisor = 3;

        if (dividend == divisor)
            System.out.println(1);

        boolean sign = true;

        if (dividend >= 0 && divisor < 0)
            sign = false;
        else if (dividend <= 0 && divisor > 0)
            sign = false;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;
        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            quotient += 1 << count;
            n -= (d << count);
        }

        if (quotient == (1 << 31) && sign) {
            System.out.println(Integer.MAX_VALUE);
        }

        if (quotient == (1 << 31) && !sign)
            System.out.println(Integer.MIN_VALUE);

        if (sign)
            System.out.println(quotient);
        else
            System.out.println(-quotient);
    }
}
