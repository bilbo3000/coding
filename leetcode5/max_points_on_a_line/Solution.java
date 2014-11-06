import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int max = 0;

        for (int i = 0; i < points.length; i++) {
            Point origin = points[i];
            Map<String, Integer> m = new HashMap<String, Integer>();
            int x1 = origin.x;
            int y1 = origin.y;
            int overlap = 1;
            int maxx = 0;

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    Point p = points[j];
                    int x2 = p.x;
                    int y2 = p.y;

                    int diffx = x1 - x2;
                    int diffy = y1 - y2;

                    if (diffx == 0 && diffy == 0) {
                        overlap++;
                    }
                    else if (diffx == 0) {
                        if (!m.containsKey("v")) {
                            m.put("v", 1);
                        } else {
                            m.put("v", m.get("v") + 1);
                        }
                        maxx = Math.max(maxx, m.get("v"));
                    }

                    else if (diffy == 0) {
                        if (!m.containsKey("h")) {
                            m.put("h", 1);
                        } else {
                            m.put("h", m.get("h") + 1);
                        }
                        maxx = Math.max(maxx, m.get("h"));
                    }
                    else {
                        int g = gcd(diffx, diffy);
                        diffx /= g;
                        diffy /= g;
                        String key = String.valueOf(diffx) + "_" + String.valueOf(diffy);

                        if (!m.containsKey(key)) {
                            m.put(key, 1);
                        } else {
                            m.put(key, m.get(key) + 1);
                        }
                        maxx = Math.max(maxx, m.get(key));
                    }
                }
            }

            maxx += overlap;
            max = Math.max(max, maxx);
        }

        return max;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
