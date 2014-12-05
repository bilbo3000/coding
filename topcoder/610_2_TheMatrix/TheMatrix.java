/**
 * Created by Dongpu on 12/4/14.
 */
public class TheMatrix {
    public int MaxArea(String[] board) {
        int result = 0;
        int m = board.length;
        int n = board[0].length();

        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            String line = board[i];

            if (i != 0) {
                for (int j = 0; j < n; j++) {
                    if (line.charAt(j) != board[i - 1].charAt(j)) {
                        h[j]++;
                    } else {
                        h[j] = 1;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                // Push to the left
                int l = j - 1;

                while (l >= 0 && line.charAt(l) != line.charAt(l + 1) && h[l] >= h[j]) {
                    l--;
                }

                // Push to the right
                int r = j + 1;
                while (r < n && line.charAt(r) != line.charAt(r - 1) && h[r] >= h[j]) {
                    r++;
                }

                result = Math.max(result, h[j] * (r - l - 1));
            }
        }

        return result;
    }
}
