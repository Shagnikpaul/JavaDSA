package acc2_fat;

import java.util.HashMap;
import java.util.List;

public class Distribution {
    public static boolean canDistribute(List<String> people, List<String> items) {

        HashMap<String, HashMap<String, Integer>> hm = new HashMap<>();
        for (String s : people) {
            hm.put(s, new HashMap<>());
        }

        for (String i : items) {
            boolean isAssigned = false;
            for (String p : people) {
                if (hm.get(p).containsKey(i)) {
                    if (hm.get(p).get(i) < 2) {
                        hm.get(p).put(i, hm.get(p).get(i) + 1);
                        isAssigned = true;
                        break;
                    }

                } else {
                    isAssigned = true;
                    hm.get(p).put(i, 1);
                    break;
                }
            }
            if (!isAssigned)
                return false;
        }
        return true;
    }
}
