public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] T = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            T[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                T[i][i + 1] = true;
            }
        }

        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                T[i][j] = T[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        int l = 0;
        int r = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (T[i][j]) {
                    if (j - i > r - l) {
                        l = i;
                        r = j;
                    }
                }
            }
        }

        return s.substring(l, r + 1);
    }
}
