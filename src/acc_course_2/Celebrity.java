package acc_course_2;

import java.util.Stack;

public class Celebrity {

    static int findCelebrity(int[][] M) {
        Stack<Integer> s = new Stack<>();
        int n = M.length;

        for (int i = 0; i < n; i++) s.push(i);

        while (s.size() > 1) {
            int a = s.pop(), b = s.pop();
            if (M[a][b] == 1) s.push(b);
            else s.push(a);
        }

        int c = s.pop();
        for (int i = 0; i < n; i++)
            if (i != c && (M[c][i] == 1 || M[i][c] == 0))
                return -1;
        return c;
    }

    public static void main(String[] args) {
        int[][] M = {
                {0, 1, 1},
                {0, 0, 1},
                {0, 0, 0}
        };
        System.out.println(findCelebrity(M));
    }
}
