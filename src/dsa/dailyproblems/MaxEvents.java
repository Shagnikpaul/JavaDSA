package dsa.dailyproblems;

import java.util.ArrayList;

import java.util.Comparator;

public class MaxEvents {
    public static void main(String[] args) {
        int[][] events = { { 1, 2 }, { 1, 2 }, { 3, 3 }, { 1, 5 }, { 1, 5 } };

        ArrayList<Event> listOfEvents = new ArrayList<>();
        for (int i = 0; i < events.length; i++) {
            listOfEvents.add(new Event(events[i][0], events[i][1]));
        }

        listOfEvents.sort(new CustomEventComparator());
        int c = 0;
        int day = 1;

        for (Event i : listOfEvents) {
            System.out.println("Start : " + i.startDay + " End = " + i.endDay);
        }

        for (Event i : listOfEvents) {
            if (day >= i.startDay && day <= i.endDay) {
                c++;
                day++;
            }

        }
        System.out.println("Max count " + c);
    }
}

class CustomEventComparator implements Comparator<Event> {

    @Override
    public int compare(Event e1, Event e2) {

        int res = e1.startDay - e2.startDay;

        if (res == 0) {
            return e1.endDay - e2.endDay;
        } else
            return res;
    }
}

class Event {
    int startDay;
    int endDay;

    public Event(int s, int e) {
        this.startDay = s;
        this.endDay = e;
    }
}
