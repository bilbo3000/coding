public class Solution {
    private ArrayList<String[]> result = new ArrayList<String[]>();

    public ArrayList<String[]> solveNQueens(int n) {
        helper(new String[n], new int[n], 0, n);

        return result;
    }

    private void helper(String[] board, int[] rowcol, int row, int len) {
        if (row == len) {
            result.add(board);
            return;
        }


        for (int col = 0; col < len; col++) {
            if (check(rowcol, row, col)) {
                String[] tempBoard = board.clone();
                char[] tempRow = new char[len];

                for (int i = 0; i < len; i++) {
                    if (i == col) {
                        tempRow[i] = 'Q';
                    }
                    else {
                        tempRow[i] = '.';
                    }
                }

                tempBoard[row] = new String(tempRow);
                int[] tempRowcol = rowcol.clone();
                tempRowcol[row] = col;

                helper(tempBoard, tempRowcol, row + 1, len);
            }
        }
    }

    boolean check(int[] rowcol, int row, int col) {
        for (int i = row -1; i >= 0; i--) {
            if (rowcol[i] == col) {
                return false;
            }

            if (Math.abs(row - i) == Math.abs(col - rowcol[i])) {
                return false;
            }
        }

        return true;
    }
}
