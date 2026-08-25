package hackathon;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class TripPlanne {

    /**
     * A traveller.
     */
    static class User {
        String name;
        int budget;
        int energy;
        Set<String> tags;
        boolean active = true;

        User(String n, int b, int e, Set<String> t) {
            name = n;
            budget = b;
            energy = e;
            tags = t;
        }
    }

    /**
     * A candidate activity.
     */
    static class Activity {
        int id;
        String name;
        int cost;
        int duration;
        int energy;
        String tag;

        Activity(int id, String n, int c, int d, int e, String t) {
            this.id = id;
            this.name = n;
            this.cost = c;
            this.duration = d;
            this.energy = e;
            this.tag = t;
        }
    }

    /**
     * Parsed input bundle handed to the candidate's solve(...) method.
     */
    static class Input {
        int N, D, H;
        List<User> users;
        Map<Integer, Activity> activities;
        List<String> events;        // verbatim event lines, for echoing
    }

    /**
     * Reads the entire stdin into the Input structure described in problem.md.
     */
    static Input readInput() throws FileNotFoundException {
        Scanner sc = new Scanner(new java.io.File("input.txt"));
        Input in = new Input();
        in.N = sc.nextInt();
        in.D = sc.nextInt();
        in.H = sc.nextInt();

        in.users = new ArrayList<>();
        for (int i = 0; i < in.N; i++) {
            String name = sc.next();
            int budget = sc.nextInt();
            int energy = sc.nextInt();
            int k = sc.nextInt();
            Set<String> tags = new HashSet<>();
            for (int j = 0; j < k; j++) tags.add(sc.next());
            in.users.add(new User(name, budget, energy, tags));
        }

        int A = sc.nextInt();
        in.activities = new LinkedHashMap<>();
        for (int i = 0; i < A; i++) {
            int id = sc.nextInt();
            String aName = sc.next();
            int cost = sc.nextInt();
            int duration = sc.nextInt();
            int eCost = sc.nextInt();
            String tag = sc.next();
            in.activities.put(id, new Activity(id, aName, cost, duration, eCost, tag));
        }

        int E = sc.nextInt();
        sc.nextLine();
        in.events = new ArrayList<>();
        for (int i = 0; i < E; i++) in.events.add(sc.nextLine().trim());
        return in;
    }

    /**
     * Format a single day line exactly per spec. Use REST if ids is empty.
     */
    static String formatDay(int day, List<Integer> ids, int cost, int sat) {
        if (ids == null || ids.isEmpty())
            return "Day " + day + ": REST | cost=0 satisfaction=0";
        List<Integer> sorted = new ArrayList<>(ids);
        Collections.sort(sorted);
        StringBuilder sb = new StringBuilder("Day ").append(day).append(": ");
        for (int i = 0; i < sorted.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(sorted.get(i));
        }
        sb.append(" | cost=").append(cost).append(" satisfaction=").append(sat);
        return sb.toString();
    }
    // NOTE: class Main is intentionally left OPEN here.
    // The Body adds solve(...) and the Tail adds main(...) + the closing brace.

    // =====================================================================
    // YOUR CODE GOES HERE.
    //
    // Implement solve(Input in) and return the FULL output string
    // (including the trailing newline) that the judge will diff against
    // the expected output.
    //
    // Helpers available from the Head section:
    //   - formatDay(day, ids, cost, sat)  -> a properly formatted "Day X: ..." line
    //   - in.users        : List<User>            ({name, budget, energy, tags, active})
    //   - in.activities   : Map<Integer,Activity> ({id, name, cost, duration, energy, tag})
    //   - in.events       : List<String>          verbatim event lines, e.g.
    //                       "DROP 2 Bob", "WEATHER 3 NATURE",
    //                       "FATIGUE 2 Alice 5", "BUDGET 4 Alice 20"
    // =====================================================================


    static class DayResult {
        List<Integer> ids;
        int cost;
        int sat;

        DayResult(List<Integer> ids, int cost, int sat) {
            this.ids = ids;
            this.cost = cost;
            this.sat = sat;
        }
    }

    static class DayPlan {
        List<Integer> ids;
        int cost;
        int sat;
    }

    static boolean isBetter(DayResult a, DayResult b) {
        if (a.sat != b.sat)
            return a.sat > b.sat;

        if (a.cost != b.cost)
            return a.cost < b.cost;

        int n = Math.min(a.ids.size(), b.ids.size());

        for (int i = 0; i < n; i++) {
            if (!a.ids.get(i).equals(b.ids.get(i)))
                return a.ids.get(i) < b.ids.get(i);
        }

        return a.ids.size() < b.ids.size();
    }

    static DayResult solveDay(Input in, List<Activity> list, boolean[] used) {

        int A = list.size();

        int minBudget = Integer.MAX_VALUE;
        int minEnergy = Integer.MAX_VALUE;

        for (User u : in.users) {
            if (!u.active) continue;
            minBudget = Math.min(minBudget, u.budget);
            minEnergy = Math.min(minEnergy, u.energy);
        }

        DayResult best = null;

        for (int mask = 0; mask < (1 << A); mask++) {

            int cost = 0;
            int duration = 0;
            int energy = 0;
            int sat = 0;

            List<Integer> ids = new ArrayList<>();
            boolean valid = true;

            for (int i = 0; i < A; i++) {

                if ((mask & (1 << i)) == 0) continue;
                if (used[i]) {
                    valid = false;
                    break;
                }

                Activity a = list.get(i);

                cost += a.cost;
                if (cost > minBudget) {
                    valid = false;
                    break;
                }

                duration += a.duration;
                if (duration > in.H) {
                    valid = false;
                    break;
                }

                energy += a.energy;
                if (energy > minEnergy) {
                    valid = false;
                    break;
                }

                ids.add(a.id);

                for (User u : in.users) {
                    if (u.active && u.tags.contains(a.tag)) {
                        sat++;
                    }
                }
            }

            if (!valid) continue;

            Collections.sort(ids);

            DayResult cur = new DayResult(ids, cost, sat);

            if (best == null || isBetter(cur, best)) {
                best = cur;
            }
        }

        return best;
    }

    static int indexOf(Input in, int id) {
        int i = 0;
        for (Activity a : in.activities.values()) {
            if (a.id == id) return i;
            i++;
        }
        return -1;
    }

    static int getEventDay(String event) {
        String[] p = event.split(" ");
        for (String s : p) {
            try {
                int val = Integer.parseInt(s);
                if (val >= 1) return val;
            } catch (Exception ignored) {
            }
        }
        return 1;
    }

    static String solve(Input in) {

        StringBuilder out = new StringBuilder();
        out.append("=== PLAN ===\n");

        int A = in.activities.size();
        boolean[] used = new boolean[A];

        List<Activity> list = new ArrayList<>(in.activities.values());
        list.sort(Comparator.comparingInt(a -> a.id));
        List<DayPlan> plan = new ArrayList<>();

        Map<Integer, Integer> idToIndex = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            idToIndex.put(list.get(i).id, i);
        }


        for (int day = 1; day <= in.D; day++) {

            DayResult res = solveDay(in, list, used);

            if (res.ids.isEmpty()) {
                out.append("Day ").append(day)
                        .append(": REST | cost=0 satisfaction=0\n");
                continue;
            }

            for (int id : res.ids) {
                used[idToIndex.get(id)] = true;
            }

            out.append(formatDay(day, res.ids, res.cost, res.sat)).append('\n');
        }

        // ---------------- EVENTS ----------------
        for (int i = 0; i < in.events.size(); i++) {

            String event = in.events.get(i);

            out.append("=== EVENT ").append(i + 1)
                    .append(": ").append(event).append(" ===\n");

            String[] parts = event.split(" ");
            String type = parts[0];

            int startDay = 1;

            if (type.equals("WEATHER")) {
                startDay = Integer.parseInt(parts[1]);
            } else if (type.equals("DROP")) {
                String name = parts[2];
                for (User u : in.users) {
                    if (u.name.equals(name)) u.active = false;
                }
            } else if (type.equals("FATIGUE")) {
                String name = parts[2];
                int val = Integer.parseInt(parts[3]);
                for (User u : in.users) {
                    if (u.name.equals(name)) u.energy = val;
                }
            } else if (type.equals("BUDGET")) {
                String name = parts[2];
                int val = Integer.parseInt(parts[3]);
                for (User u : in.users) {
                    if (u.name.equals(name)) u.budget = val;
                }
            }


            for (int d = startDay; d <= in.D; d++) {

                DayResult res = solveDay(in, list, used);

                if (res.ids.isEmpty()) {
                    out.append("Day ").append(d)
                            .append(": REST | cost=0 satisfaction=0\n");
                    continue;
                }

                for (int id : res.ids) {
                    used[idToIndex.get(id)] = true;
                }
                

                out.append(formatDay(d, res.ids, res.cost, res.sat)).append('\n');
            }
        }

        return out.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Input in = readInput();
        System.out.print(solve(in));
    }
}
