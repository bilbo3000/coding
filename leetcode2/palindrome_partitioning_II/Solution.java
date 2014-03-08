import java.util.*;

public class Solution {
    public int minCut(String s) {
        int n = s.length();

        // Build palindrome table P
        boolean[][] P = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            P[i][i] = true;
        }

        for (int i = 1; i < n; i++) {
            P[i - 1][i] = (s.charAt(i - 1) == s.charAt(i)) ? true : false;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                P[i][j] = (s.charAt(i) == s.charAt(j)) ? P[i + 1][j - 1] : false;
            }
        }

        int[] T = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            T[i] = i;

            for (int j = i; j >= 1; j--) {
                if (P[j - 1][i - 1]) {
                    T[i] =  Math.min(T[i], T[j - 1] + 1);
                }
            }
        }

        return T[n] - 1;
    }
}
