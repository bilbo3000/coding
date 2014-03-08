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
    public int gcd(int a, int b) {
        if (a == 0) return b; 
        if (b == 0) return a; 
        
        return gcd(b, a % b); 
    }
    
    public int maxPoints(Point[] points) {
        int maxx = 0; 
        
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> m = new HashMap<String, Integer>(); 
            int k = 1;  // Number of points same as current points 
            int max = 0; 
            
            for (int j = i + 1; j < points.length; j++) {
                int xdiff = points[i].x - points[j].x; 
                int ydiff = points[i].y - points[j].y; 
                int g = gcd(xdiff, ydiff);
                
                if (g == 0) {
                    k++; 
                }
                else {
                    String key = Integer.toString(xdiff / g) + " " + Integer.toString(ydiff / g); 
                    
                    if (m.containsKey(key)) {
                        m.put(key, m.get(key) + 1); 
                    }
                    else {
                        m.put(key, 1); 
                    }
                    
                    if (m.get(key) > max) max = m.get(key);
                }
            }
            
            if (max + k > maxx) maxx = max + k; 
        }
        
        return maxx; 
    }
}
