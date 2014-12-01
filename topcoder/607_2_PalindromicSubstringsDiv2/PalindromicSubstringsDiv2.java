
public class PalindromicSubstringsDiv2 {
    public int count(String[] S1, String[] S2) {
        StringBuilder sb = new StringBuilder("");
        for (String item : S1) {
            sb.append(item);
        }

        for (String item : S2) {
            sb.append(item);
        }

        int len = sb.length();

        if (len == 0) {
            return 0;
        }

        boolean [][] T = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            T[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                T[i][i + 1] = true;
            }
        }

        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (sb.charAt(i) == sb.charAt(j)) {
                    T[i][j] = T[i + 1][j - 1];
                }
            }
        }

        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (T[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
