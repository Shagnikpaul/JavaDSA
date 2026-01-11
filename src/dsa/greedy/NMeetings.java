package dsa.greedy;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting o1, Meeting o2) {
        return o1.end - o2.end;
    }
}


class Meeting {
    int start;
    int end;
    int number;

    public Meeting(int s, int e, int n) {
        this.start = s;
        this.end = e;
        this.number = n;
    }
}


public class NMeetings {

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 5, 7, 9, 9};
        ArrayList<Meeting> a = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            Meeting m = new Meeting(start[i], end[i], i + 1);
            a.add(m);
        }
        Collections.sort(a, new MeetingComparator());
        ArrayList<Integer> meetingOrder = new ArrayList<>();
        int currentTime = 0;

        for (Meeting i : a) {
            if (i.start >= currentTime) {
                currentTime = i.end;
                meetingOrder.add(i.number);
            } else {
                //System.out.println("Did not take " + i.number + " since current time is " + currentTime + " and start time is " + i.start);
            }
        }
        System.out.println(meetingOrder);
    }
}
