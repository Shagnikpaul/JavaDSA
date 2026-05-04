package acc2_fat;

public class bitonic {

    public static int lis(int[] arr, int i, int l) {
        if (i < 0) {
            return 0;
        }
        int not = lis(arr, i - 1, l);
        int take = 0;
        if (l == -1 || arr[i] < l) {
            take = 1 + lis(arr, i - 1, arr[i]);
        }
        return Math.max(not, take);
    }

    public static int lds(int[] arr, int i, int l) {
        if (i == arr.length) {
            return 0;
        }
        int not = lds(arr, i + 1, l);
        int take = 0;
        if (l == -1 || arr[i] < l) {
            take = 1 + lds(arr, i + 1, arr[i]);
        }
        return Math.max(not, take);
    }


    public static void main(String[] args) {
        int[] ar = {1, 11, 2, 10, 4, 5, 2, 1};
        int max = -1;
        for (int i = 0; i < ar.length; i++) {
            max = Math.max(max, (lis(ar, i, -1) + lds(ar, i, -1) - 1));
        }
        System.out.println("max : " + max);
    }
}
