public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int len = num.length; 
        int min = Integer.MAX_VALUE; 
        Arrays.sort(num); 
        int i = 0; 
        int result = 0; 
        
        while (i < len) {
            int j = i + 1; 
            int k = len - 1; 
            
            while (j < k) {
                int sum = num[i] + num[j] + num[k]; 
                int diff = Math.abs(sum - target); 
                
                if (sum == target) {
                    return sum; 
                }
                else if (sum < target) {
                    do {
                        j++; 
                    } while (j < k && num[j] == num[j - 1]); 
                }
                else {
                    do {
                        k--; 
                    } while (j < k && num[k] == num[k + 1]); 
                }
                
                if (diff < min) {
                    result = sum; 
                    min = diff;  
                }
            }
            
            do {
                i++; 
            } while (i < len && num[i] == num[i - 1]); 
        }
        
        return result; 
    }
}
