import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dongpu on 11/30/14.
 */
public class PowerOfThreeEasy {
    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String ableToGet(int x, int y) {
        if (x == 0 && y == 0) {
            return "Possible";
        }

        List<List<Pair>> levels = new ArrayList<List<Pair>>();
        levels.add(new ArrayList<Pair>());
        levels.add(new ArrayList<Pair>());
        int lev0 = 0;
        int lev1 = 1;
        levels.get(0).add(new Pair(0, 1));
        levels.get(0).add(new Pair(1, 0));
        int step = 1;

        while (levels.get(lev0).size() != 0) {
            List<Pair> curr = levels.get(lev0);
            List<Pair> next = levels.get(lev1);

            for (Pair item : curr) {
                if (item.x == x && item.y == y) {
                    return "Possible";
                }

                if (item.x + (int) Math.pow(3, step) <= x && item.y <= y) {
                    next.add(new Pair(item.x + (int) Math.pow(3, step), item.y));
                }

                if (item.x <= x && item.y + (int) Math.pow(3, step) <= y) {
                    next.add(new Pair(item.x, item.y + (int) Math.pow(3, step)));
                }
            }

            curr.clear();
            step++;
            lev0 = lev0 ^ lev1;
            lev1 = lev0 ^ lev1;
            lev0 = lev0 ^ lev1;
        }

        return "Impossible";
    }
}
