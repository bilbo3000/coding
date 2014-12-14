public class ChristmasTreeDecorationDiv2 {
    public int solve(int[] col, int[] x, int[] y) {
        int len = x.length;
        int result = 0;

        for (int i = 0; i < len; i++) {
            int star1 = x[i];
            int star2 = y[i];

            if (col[star1 - 1] != col[star2 - 1]) {
                result++;
            }
        }

        return result;
    }
}
