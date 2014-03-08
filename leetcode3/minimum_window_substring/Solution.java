import java.util.*;
public class Solution {
    public String minWindow(String S, String T) {
        Map<Character, Integer> needToFind = new HashMap<Character, Integer>();
        Map<Character, Integer> hasFound = new HashMap<Character, Integer>();
        int count = 0;  // Used to find first window 

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);

            if (!needToFind.containsKey(c)) {
                needToFind.put(c, 1);
            }
            else {
                needToFind.put(c, needToFind.get(c) + 1);
            }
        }

        // Find first window 
        int left = 0;
        int right = 0;

        while (right < S.length()) {
            char c = S.charAt(right); 
            if (!hasFound.containsKey(c)) {
                hasFound.put(c, 0);
            }

            hasFound.put(c, hasFound.get(c) + 1);

            if (needToFind.containsKey(c) && hasFound.get(c) <= needToFind.get(c)) {
                count++;
            }

            if (count == T.length()) {
                break;
            }

            right++;
        }

        if (right == S.length()) {
            return "";
        }

        while (left <= right && 
                (!needToFind.containsKey(S.charAt(left)) || hasFound.get(S.charAt(left)) > needToFind.get(S.charAt(left)))
                ) {
            hasFound.put(S.charAt(left), hasFound.get(S.charAt(left)) - 1);
            left++;
        }

        int l = left;
        int r = right;

        while (right < S.length() - 1) {
            right++;
            char c = S.charAt(right);

            if (!hasFound.containsKey(c)) {
                hasFound.put(c, 0);
            }

            hasFound.put(c, hasFound.get(c) + 1);

            while (left <= right &&
                    (!needToFind.containsKey(S.charAt(left)) || hasFound.get(S.charAt(left)) > needToFind.get(S.charAt(left)))
                    ) {
                hasFound.put(S.charAt(left), hasFound.get(S.charAt(left)) - 1);
                left++;
            }

            if ((right - left) < (r - l)) {
                r = right;
                l = left;
            }
        }

        return S.substring(l, r + 1);
    }
}
