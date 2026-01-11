package dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Job {
    int deadline;
    int profit;
    int id;

    public Job(int id, int profit, int deadline) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}

class JobComparator implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o2.profit - o1.profit;
    }
}

public class JobSequencing {
    public static void main(String[] args) {
        int[][] jobs = {
                {1, 2, 100},
                {2, 1, 19},
                {3, 2, 27},
                {4, 1, 25},
                {5, 1, 15}
        };

        ArrayList<Job> a = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            Job b = new Job(jobs[i][0], jobs[i][2], jobs[i][1]);
            a.add(b);
        }
        a.sort(new JobComparator());
        int maxDeadline = -1;
        for (Job j : a) {
            maxDeadline = Math.max(maxDeadline, j.deadline);
        }
        int[] available = new int[maxDeadline + 1];
        Arrays.fill(available, -1);
        int profit = 0;
//        for (Job j : a) {
//            System.out.println("Job " + j.id + " with profit = " + j.profit + " dead at " + j.deadline);
//        }
        for (Job j : a) {

            for (int k = j.deadline; k > 0; k--) {
                if (available[k] == -1) {
                    available[k] = j.id;
                    profit += j.profit;
                    break;
                }
            }
        }

        System.out.println("Max profit earned : " + profit);
    }
}
