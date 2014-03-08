public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int result = 0; 
        int minDiff = Integer.MAX_VALUE; 
        int len = num.length; 
        
        if (len < 3) return 0; 
        
        Arrays.sort(num); 
        
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1; 
            int r = len - 1; 
            
            while (l < r) {
                int sum = num[i] + num[l] + num[r]; 
                int diff = Math.abs(sum - target); 
                
                if (diff < minDiff) {
                    result = sum; 
                    minDiff = diff; 
                }
                
                if (sum < target) {
                    l++; 
                }
                else {
                    r--; 
                }
            }
        }
        
        return result; 
    }
}
