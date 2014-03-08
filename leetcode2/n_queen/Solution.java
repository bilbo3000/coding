public class Solution {
    private ArrayList<String[]> result = new ArrayList<String[]>();

    public ArrayList<String[]> solveNQueens(int n) {
        if (n == 0) return result;

        int[] rowcol = new int[n];  // Row index for each column
        String[] curr = new String[n];

        helper(curr, 0, rowcol, n);

        return result;
    }

    void helper(String[] curr, int row, int[] rowcol, int n) {
        if (row == n) {
            result.add(curr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(row, i, rowcol)) {
                char[] temp = new char[n];

                for (int j = 0; j < n; j++) {
                    temp[j] = j == i ? 'Q' : '.';
                }

                String[] currNext = curr.clone();
                currNext[row] = String.valueOf(temp);
                int[] rowcolNext = rowcol.clone();
                rowcolNext[row] = i;

                helper(currNext, row + 1, rowcolNext, n);
            }
        }
    }

    boolean check (int row, int col, int[] rowcol) {
        for (int i = row - 1; i >= 0; i--) {
            if (rowcol[i] == col) return false;

            if (Math.abs(col - rowcol[i]) == Math.abs(i - row)) return false;
        }

        return true;
    }
}
