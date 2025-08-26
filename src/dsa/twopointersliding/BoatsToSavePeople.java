package dsa.twopointersliding;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {1, 2};
        int limit = 3;

        Arrays.sort(people);
        //System.out.println("People " + Arrays.toString(people));
        int l = 0;
        int r = -1;
        int boatCount = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            if (people[i] < limit) {
                r = i;
                break;
            } else {
                boatCount++;
            }
        }
        // boats

        if (r == -1) {
            System.out.println("No of boats req. = " + people.length);
            return;
        }

        while (l < r) {
            boatCount++;
            if ((people[l] + people[r]) <= limit) {
                l++;
            }
            r--;
        }

        if (l == r) {
            boatCount++;
        }
        System.out.println("No of boats required : " + boatCount);
    }
}
