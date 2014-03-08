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
    int max = 0; 
    
    public int maxPoints(Point[] points) {
        for (Point o : points) {
            int maxx = 0;
            int k = 0;  // Number of overlap points 
            Map<String, Integer> m = new HashMap<String, Integer>(); 
            
            for (Point p : points) {
                int x_diff = p.x - o.x; 
                int y_diff = p.y - o.y; 
                int g = gcd(x_diff, y_diff); 
                
                if (g == 0) {
                    if (x_diff == 0 && y_diff == 0) {
                        k++; 
                    }
                    else if (x_diff == 0){  // Vertical
                        if (!m.containsKey("v")) {
                            m.put("v", 0); 
                        }
                        
                        int val = m.get("v") + 1;
                        maxx = Math.max(maxx, val); 
                        m.put("v", val); 
                    }
                    else {  // Horizontal 
                        if (!m.containsKey("h")) {
                            m.put("h", 0); 
                        }
                        
                        int val = m.get("h") + 1;
                        maxx = Math.max(maxx, val); 
                        m.put("h", val); 
                    }
                }
                else {
                    String key = (char) (x_diff / g) + "_" + (char) (y_diff / g); 
                    
                    if (!m.containsKey(key)) {
                        m.put(key, 0); 
                    }

                    int val = m.get(key) + 1;
                    maxx = Math.max(maxx, val);
                    m.put(key, val); 
                }
            }
            
            max = Math.max(max, maxx + k); 
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
