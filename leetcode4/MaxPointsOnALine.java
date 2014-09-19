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
        int len = points.length; 
        
        for (int i = 0; i < len; i++) {
            Map<String, Integer> m = new HashMap<String, Integer>(); 
            int maxx = 0; 
            int overlap = 0; 
            int v_cnt = 0; 
            int h_cnt = 0; 
            
            for (int j = 0; j < len; j++) {
                //if (i != j) {
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        overlap++; 
                    } else {
                        int xdiff = points[j].x - points[i].x;
                        int ydiff = points[j].y - points[i].y; 
                        
                        if (xdiff == 0) {
                            h_cnt++; 
                            maxx = Math.max(maxx, h_cnt); 
                        } else if (ydiff == 0) {
                            v_cnt++; 
                            maxx = Math.max(maxx, v_cnt); 
                        } else {
                            int g = gcd(xdiff, ydiff); 
                            String key = Integer.toString(xdiff / g) + "-" + Integer.toString(ydiff / g); 
                            if (!m.containsKey(key)) {
                                m.put(key, 0); 
                            }
                            
                            m.put(key, m.get(key) + 1); 
                            maxx = Math.max(maxx, m.get(key)); 
                        }
                    }
                //}
            }
            
            maxx = maxx + overlap; 
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
