/**
 * Created by Dongpu on 10/27/14.
 */
public class BalanceNumber {
    public int getBalanceNumber(int[][] mat) {
        int m = mat.length;

        if (m == 0) {
            return 0;
        }

        int n = mat[0].length;

        if (n == 0) {
            return 0;
        }

        int [] rowAbove = new int[m];
        int [] rowBelow = new int[m];
        int [] colLeft = new int[n];
        int [] colRight = new int[n];

        int result = 0;

        for (int i = 0; i < m - 1; i++) {
            int currRow = mat[i][0];

            for (int j = 1; j < n; j++) {
                currRow += mat[i][j];
            }

            rowAbove[i + 1] = rowAbove[i] + currRow;
        }

        for (int i = m - 1; i > 0; i--) {
            int currRow = mat[i][0];

            for (int j = 1; j < n; j++) {
                currRow += mat[i][j];
            }

            rowBelow[i - 1] = rowBelow[i] + currRow;
        }

        for (int j = 0; j < n - 1; j++) {
            int currCol = mat[0][j];

            for (int i = 1; i < m; i++) {
                currCol += mat[i][j];
            }

            colLeft[j + 1] = colLeft[j] + currCol;
        }

        for (int j = n - 1; j > 0; j--) {
            int currCol = mat[0][j];

            for (int i = 1; i < m; i++) {
                currCol += mat[i][j];
            }

            colRight[j - 1] = colRight[j] + currCol;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowAbove[i] == rowBelow[i] && colLeft[j] == colRight[j]) {
                    return mat[i][j];
                }
            }
        }

        return 0;
    }
}
