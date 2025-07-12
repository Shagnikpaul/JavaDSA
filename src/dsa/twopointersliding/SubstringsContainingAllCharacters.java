package dsa.twopointersliding;

public class SubstringsContainingAllCharacters {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("aaacb");

        int lastSeen[] = { -1, -1, -1 };

        int r = 0;
        int count = 0;
        for (; r < str.length(); r++) {
            lastSeen[str.charAt(r) - 'a'] = r;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(lastSeen[2], Math.min(lastSeen[0], lastSeen[1]));
            }
        }

        System.out.println("Total count : " + count);
    }

}
