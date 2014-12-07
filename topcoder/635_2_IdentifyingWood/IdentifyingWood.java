public class IdentifyingWood {
    public String check(String s, String t) {
        int m = s.length();
        int n = t.length();

        boolean[][] T = new boolean[m][n];

        if (s.charAt(0) == t.charAt(0)) {
            T[0][0] = true;
        }

        for (int i = 1; i < m; i++) {
            if (T[i - 1][0]) {
                T[i][0] = true;
            } else {
                T[i][0] = s.charAt(i) == t.charAt(0) ? true : false;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    T[i][j] = T[i - 1][j - 1] || T[i - 1][j];
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }

        if (T[m - 1][n - 1]) {
            return "Yep, it's wood.";
        }

        return "Nope.";
    }
}
