public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();

        if (n == 0) return false;

        Boolean[] T = new Boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            T[i] = false;
        }

        T[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                String sub = s.substring(j - 1, i);

                if (dict.contains(sub)) {
                    T[i] = T[i] || T[j - 1];
                }
            }
        }

        return T[n];
    }
}
