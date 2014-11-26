import java.util.ArrayList;
import java.util.List;

public class PilingRectsDiv2 {
    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int getmax(int[] X, int[] Y, int limit) {
        List<Pair> min = new ArrayList<Pair>();
        List<Integer> count = new ArrayList<Integer>();

        for (int i = 0; i < X.length; i++) {
            if (X[i] * Y[i] < limit) {
                continue;
            }

            for (int j = min.size() - 1; j >= 0; j--) {
                // Check whether able to add to that list
                Pair minPair = min.get(j);

                // Look at rotation first
                int minX1 = Math.min(minPair.x, Y[i]);
                int minY1 = Math.min(minPair.y, X[i]);

                if (minX1 * minY1 >= limit) {
                    min.add(new Pair(minX1, minY1));
                    count.add(1);
                }

                // Look at un-rotated
                int minX = Math.min(minPair.x, X[i]);
                int minY = Math.min(minPair.y, Y[i]);

                if (minX * minY >= limit) {
                    minPair.x = minX;
                    minPair.y = minY;
                    count.set(j, count.get(j) + 1);
                }
            }

            if (X[i] * Y[i] >= limit) {
                min.add(new Pair(X[i], Y[i]));
                count.add(1);
                min.add(new Pair(Y[i], X[i]));
                count.add(1);
            }
        }

        int max = 0;

        for (Integer item : count) {
            if (item > max) {
                max = item;
            }
        }

        return max == 0 ? -1 : max;
    }
}
