package conceptsdsa.recursion;

public class ObserveRecursionInStack {

    public static void non_infinity(int n) {
        if (n == 0)
            return;
        System.out.println("Hello");
        non_infinity(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Started process");
        non_infinity(4);
    }
}
