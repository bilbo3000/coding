public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int result = 0; 
        int h = triangle.size(); 
        
        if (h == 0) return result; 
        
        for (int i = 1; i < h; i++) {
            for (int j = 0; j <= i; j++) {
                int item = triangle.get(i).get(j);
                
                if (j == 0) {
                    triangle.get(i).set(j, item + triangle.get(i - 1).get(j)); ;  
                }
                else if (j == i) {
                    triangle.get(i).set(j, item + triangle.get(i - 1).get(j - 1)); 
                }
                else {
                    triangle.get(i).set(j, item + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j))); 
                }
            }
        }
        
        ArrayList<Integer> lastLevel = triangle.get(h - 1);
        result = lastLevel.get(0);
        
        for (int i = 1; i < lastLevel.size(); i++) {
            if (lastLevel.get(i) < result) {
                result = lastLevel.get(i); 
            }
        }
        
        
        return result; 
    }
}
