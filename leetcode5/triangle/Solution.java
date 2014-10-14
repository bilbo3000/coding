public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0; 
        }
        
        List<Integer> temp = triangle.get(0);
        
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> curr = triangle.get(i);
            int currSize = curr.size(); 
            int tempSize = temp.size(); 
            
            temp.add(temp.get(tempSize - 1) + curr.get(currSize - 1));
            
            for (int j = tempSize - 1; j >= 0; j--) {
                if (j > 0) {
                    temp.set(j, Math.min(temp.get(j - 1), temp.get(j)) + curr.get(j)); 
                } else {
                    temp.set(j, temp.get(j) + curr.get(j)); 
                }
            }
        }
        
        int min = temp.get(0);
        
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i) < min) {
                min = temp.get(i); 
            }
        }
        
        return min; 
    }
}
