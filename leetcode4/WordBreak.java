public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] T = new boolean[len + 1];  // T[i]: whether substring ends with s[i] can be break into words

        if (len == 0) {
            return false;
        }

        T[0] = true;

        for (int i = 1; i < len + 1; i++) {  // i: index to T
            for (int j = i - 1; j >= 0; j--) {
                if (T[j] && dict.contains(s.substring(j, i))) {
                    T[i] = true;
                    break; 
                }
            }
        }

        return T[len];
    }
}
