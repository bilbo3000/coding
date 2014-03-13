import java.util.*;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();

        if (len == 0) {
            return false;
        }

        boolean[] T = new boolean[len];

        for (int i = 0; i < len; i++) {
            if (dict.contains(s.substring(0, i + 1))) {
                T[i] = true;
            }
            else {
                for (int j = i - 1; j >= 0; j--) {
                    T[i] |= dict.contains(s.substring(j + 1, i + 1)) && T[j];
                }
            }
        }

        return T[len - 1];
    }
}