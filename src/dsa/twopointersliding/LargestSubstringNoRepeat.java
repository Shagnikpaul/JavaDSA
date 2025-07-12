package dsa.twopointersliding;

import java.util.HashMap;

public class LargestSubstringNoRepeat {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(s);
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxLength = -1;
        for (; r < s.length(); r++) {
            //System.out.println("Contains " + s.charAt(r) + "? = " + map.containsKey(s.charAt(r)));
            if (map.containsKey(s.charAt(r))) {
                if (map.get(s.charAt(r)) >= l) {

                    l = map.get(s.charAt(r)) + 1;
                    //System.out.println("L = " + l + " r = " + r);
                }
            }
            if ((r - l + 1) > maxLength) {
                maxLength = r - l + 1;
            }
            map.put(s.charAt(r), r);
           

        }

    }
}
