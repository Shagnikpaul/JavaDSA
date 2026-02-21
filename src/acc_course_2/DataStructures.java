package acc_course_2;

import java.util.*;


class Ball {
    int id;
    String color;

    public Ball(int id, String color) {
        this.id = id;
        this.color = color;
    }
}

public class DataStructures {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        PriorityQueue<Ball> p = new PriorityQueue<>((b1, b2) -> b1.id - b2.id);


        PriorityQueue<Ball> pp = new PriorityQueue<>(new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o1.id + o2.id;
            }
        });
    }
}
