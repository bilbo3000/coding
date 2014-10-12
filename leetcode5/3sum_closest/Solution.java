public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int result = 0; 
        int minDiff = Integer.MAX_VALUE; 
        int len = num.length; 
        
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1; 
            int r = len - 1; 
            
            while (l < r) {
                int sum = num[i] + num[l] + num[r]; 
                
                if (sum == target) {
                    return target; 
                }
                
                if (Math.abs(sum - target) < minDiff) {
                    result = sum; 
                    minDiff = Math.abs(sum - target); 
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
