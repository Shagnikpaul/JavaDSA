package dsa.greedy;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;

class IntervalComparator implements Comparator<ArrayList<Integer>> {

    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        return a.get(0) - b.get(0);
    }
}

public class MergeInterval {
    public static void main(String[] args) {

        int intervals[][] = { { 1, 4 }, { 0, 2 }, { 3, 5 } };

        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            ArrayList<Integer> t = new ArrayList<>();
            t.add(intervals[i][0]);
            t.add(intervals[i][1]);
            ls.add(t);
        }
        ls.sort(new IntervalComparator());
        ArrayList<ArrayList<Integer>> ls1 = new ArrayList<>();
        for (int i = 0; i < ls.size(); i++) {
            ArrayList<Integer> t = new ArrayList<>();
            if (ls1.isEmpty()) {
                t.add(ls.get(i).get(0));
                t.add(ls.get(i).get(1));
                ls1.add(t);
            }

            else {
                if (ls1.get(ls1.size() - 1).get(1) <= ls.get(i).get(1)
                        && ls1.get(ls1.size() - 1).get(1) >= ls.get(i).get(0)) {
                    t.add(Math.min(ls.get(i).get(0), ls.get(ls1.size() - 1).get(0)));
                    t.add(Math.max(ls.get(i).get(1), ls.get(ls1.size() - 1).get(1)));
                    ls1.set(ls1.size() - 1, t);
                }

                else if (ls1.get(ls1.size() - 1).get(1) >= ls.get(i).get(1)
                        && ls1.get(ls1.size() - 1).get(0) <= ls.get(i).get(1)) {
                    t.add(Math.min(ls.get(i).get(1), ls1.get(ls1.size() - 1).get(0)));
                    t.add(Math.max(ls.get(i).get(1), ls1.get(ls1.size() - 1).get(1)));
                    ls1.set(ls1.size() - 1, t);
                }

                else {
                    t.add(ls.get(i).get(0));
                    t.add(ls.get(i).get(1));
                    ls1.add(t);
                }

            }
        }
        int ans[][] = new int[ls1.size()][2];

        for (int i = 0; i < ls1.size(); i++) {
            ans[i][0] = ls1.get(i).get(0);
            ans[i][1] = ls1.get(i).get(1);
        }
        System.out.println(ls1.toString());

    }
}
