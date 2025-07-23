package dsa.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {

}

class StockSpanner {

    Stack<ArrayList<Integer>> st;
    int index = -1;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        index++;
        while (!st.isEmpty() && price > st.peek().get(0)) {
            st.pop();
        }
        int ans;
        if (st.isEmpty()) {
            ans = index + 1;
        } else {
            ans = index - st.peek().get(1);
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(price);
        temp.add(index);
        st.push(temp);
        return ans;
    }
}