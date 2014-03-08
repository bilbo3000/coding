public class Solution {
    private int cnt = 0;
    private int[][] mat;
    private int n = 0;

    public int[][] generateMatrix(int n) {
        this.n = n;
        mat = new int[n][n];

        for (int level = 0; level < (n + 1) / 2; level++) {
            moveRight(level, level, level);
        }

        return mat;
    }

    private void moveRight(int x, int y, int level) {
        cnt++;
        mat[y][x] = cnt;

        if (x < n - 1 - level) {
            moveRight(x + 1, y, level);
        }
        else if (y < n - 1 - level) {
            moveDown(x, y + 1, level);
        }
    }

    private void moveDown(int x, int y, int level) {
        cnt++;
        mat[y][x] = cnt;

        if (y < n - 1 - level) {
            moveDown(x, y + 1, level);
        }
        else if (x > level) {
            moveLeft(x - 1, y, level);
        }
    }

    private void moveLeft(int x, int y, int level) {
        cnt++;
        mat[y][x] = cnt;

        if (x > level) {
            moveLeft(x - 1, y, level);
        }
        else if (y > level + 1) {
            moveUp(x, y - 1, level);
        }
    }

    private void moveUp(int x, int y, int level) {
        cnt++;
        mat[y][x] = cnt;

        if (y > level + 1) {
            moveUp(x, y - 1, level);
        }
    }
}
