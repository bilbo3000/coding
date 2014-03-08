/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */
class Solution {
public:
    int gcd(int a, int b) {
        if (a == 0) return b; 
        if (b == 0) return a; 
        
        return gcd(b, a % b); 
    }

    int maxPoints(vector<Point> &points) {
        int result = 0; 
        
        for (int i = 0; i < points.size(); i++) {
            int k = 1;  // Duplicate points 
            int tempMax = 0; 
            unordered_map<string, int> hash; 
            
            for (int j = i + 1; j < points.size(); j++) {
                int x = points[i].x - points[j].x; 
                int y = points[i].y - points[j].y;
                int g = gcd(x, y); 
                
                if (g == 0) {  // Same point 
                    k++; 
                    continue; 
                }
                
                x /= g; 
                y /= g; 
                string key = to_string(x) + " " + to_string(y); 
                hash[key]++; 
                tempMax = max(tempMax, hash[key]); 
            }
            
            result = max(result, tempMax + k);  // Remember to add same points 
        }
        
        return result; 
    }
};
