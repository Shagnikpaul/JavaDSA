package dsa.dailyproblems;

public class WordGame {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("a");
        int operations[] = { 0, 1, 0, 1 };
        int k = 10;
        int z = 0;
        while (z < operations.length) {
            if (operations[z] == 1) {
                int x = str.length();
                for (int i = 0; i < x; i++) {
                    char c = str.charAt(i);
                    str.append((char) (97 + (c + 1) % 97));
                    // System.out.println("Appending...." + (char) (97 + (c + 1) % 97));
                }
            } else {
                str.append(str);
            }
            z++;

        }
        char res[] = str.toString().toCharArray();

        System.out.println(res[k - 1]);
    }
}
