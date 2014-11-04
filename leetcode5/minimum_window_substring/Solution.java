import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        String result = "";

        if (len1 == 0 || len2 == 0) {
            return result;
        }

        Map<Character, Integer> needToFind = new HashMap<Character, Integer>();
        Map<Character, Integer> hasFound = new HashMap<Character, Integer>();
        int cnt = 0;

        // Build needToFind
        for (int i = 0; i < len2; i++) {
            char c = T.charAt(i);

            if (!needToFind.containsKey(c)) {
                needToFind.put(c, 1);
            } else {
                needToFind.put(c, needToFind.get(c) + 1);
            }
        }

        int l = 0;
        int r = 0;

        // Find first segment 
        while (r < len1) {
            char c = S.charAt(r);

            if (!hasFound.containsKey(c)) {
                hasFound.put(c, 1);
            } else {
                hasFound.put(c, hasFound.get(c) + 1);
            }

            if (needToFind.containsKey(c) && hasFound.get(c) <= needToFind.get(c)) {
                cnt++;
            }

            if (cnt == len2) {
                break;
            }

            r++;
        }

        if (cnt < len2) {
            return result;
        }

        result = S.substring(0, r + 1);

        while (r < len1) {
            // Push l to the right as far as possible 
            char c = S.charAt(l);

            while (!needToFind.containsKey(c) || hasFound.get(c) > needToFind.get(c)) {
                hasFound.put(c, hasFound.get(c) - 1);
                l++;

                if (l < len1) {
                    c = S.charAt(l);
                }
            }

            if ((r - l + 1) < result.length()) {
                result = S.substring(l, r + 1);
            }

            r++;

            if (r < len1) {
                char temp = S.charAt(r);

                if (!hasFound.containsKey(temp)) {
                    hasFound.put(temp, 1);
                } else {
                    hasFound.put(temp, hasFound.get(temp) + 1);
                }
            }
        }

        return result;
    }
}
