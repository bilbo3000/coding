public class TrianglesContainOriginEasy {
    public int count(int[] x, int[] y) {
        int len = x.length;
        int result = 0;

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    int x1 = x[i];
                    int y1 = y[i];
                    int x2 = x[j];
                    int y2 = y[j];
                    int x3 = x[k];
                    int y3 = y[k];

                    int c1 = dotProduct(x2 - x1, y2 - y1, -x1, -y1);
                    int c2 = dotProduct(x3 - x2, y3 - y2, -x2, -y2);
                    int c3 = dotProduct(x1 - x3, y1 - y3, -x3, -y3);

                    if ((c1 > 0 && c2 > 0 && c3 > 0) || (c1 < 0 && c2 < 0 && c3 < 0)) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private int dotProduct(int x1, int y1, int x2, int y2) {
        return x1 * y2 - x2 * y1;
    }
}
