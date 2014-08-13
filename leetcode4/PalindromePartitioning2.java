public class Solution {
    public int minCut(String s) {
        int len = s.length();

        if (len == 0) {
            return 0;
        }

        boolean[][] isPalin = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            isPalin[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalin[i][i + 1] = true;
            }
        }

        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && isPalin[i + 1][j - 1]) {
                    isPalin[i][j] = true;
                }
            }
        }

        int[] T = new int[len];

        for (int i = 0; i < len; i++) {
            T[i] = Integer.MAX_VALUE;

            for (int j = i; j >= 0; j--) {
                if (isPalin[j][i]) {
                    if (j == 0) {
                        T[i] = 0;
                    } else {
                        T[i] = Math.min(T[i], T[j - 1] + 1);
                    }
                }
            }
        }

        return T[len - 1];
    }
}
