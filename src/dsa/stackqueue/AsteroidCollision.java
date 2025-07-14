package dsa.stackqueue;

import java.util.Stack;

public class AsteroidCollision {

    public static boolean willCollide(int left, int right) {
        if (left > 0 && right < 0) {
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        int asteroids[] = { 10, 2, -5 };
        Stack<Integer> st = new Stack<>();
        st.push(asteroids[0]);
        int i = 1;
        while (i < asteroids.length) {
            if (willCollide(st.peek(), asteroids[i])) {
                if (st.isEmpty()) {
                    st.push(asteroids[i++]);
                    continue;
                }
                if (Math.abs(st.peek()) < Math.abs(asteroids[i])) {
                    st.pop();
                } else if (Math.abs(st.peek()) > Math.abs(asteroids[i])) {
                    i++;
                    continue;
                } else {
                    st.pop();
                    i++;
                    continue;
                }
            } else {
                st.push(asteroids[i++]);
                continue;
            }

        }

    }
}
