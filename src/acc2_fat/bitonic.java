package acc2_fat;

public class bitonic {

    public static int lis(int[] arr, int i, int l) {
        if (i == arr.length)
            return 0;
        if (arr[i] >= l) {
            return Math.max(lis(arr, i + 1, arr[i]), lis(arr, i + 1, l));
        } else {
            return lis(arr, i + 1, l);
        }
    }

    public static void main(String[] args) {
        int[] lisdp = new int[5]; // sample length
        int[] ldsdp = new int[5]; // sample length
        int[] arr = new int[5]; // assume 5 elelmetns
        lis(arr, 0, -1); // assume passing lisdp
        //reverse array
        lis(arr, 0, -1); // assume passing ldsdp
        // now cal longest len
        for (int i = 0; i < 5; i++) {
            /*
                lisdp[i]+ldsdp[i]-1 (max)
             */
        }
    }
}
