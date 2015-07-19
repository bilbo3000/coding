/**
 * Find the max amount one can rob from a circle of houses, where no two adjacent 
 * houses can be robbed together. 
 * The idea was to use dynamic programming. Different from previous problem is that 
 * the houses are in a circle this time. It means the first and the last houses can 
 * not be robbed together. Thus, we cannot use just one array to store the result 
 * because the value of T[i] will be affected. 
 * The solution was to use two arrays, where
 * T1[i]: when not robbing last house, the max money we could rob if we rob the ith house. 
 * T2[i]: when not robbing first house, the max money we could rob if we rob the ith house. 
 * Use the same DP approach to fill out T1 and T2 individually. Then the max would be the 
 * overall max of the max for each T1[i],T2[i] pair. 
 */ 
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] T1 = new int[len]; // Without last house
        int[] T2 = new int[len]; // Without first house
        
        for (int i = 0; i < len; i++) {
            T1[i] = nums[i]; 
            T2[i] = nums[i]; 
        } 
        
        if (len > 1) {
            T1[len - 1] = 0; 
            T2[0] = 0; 
        }
        
        // Build T1 
        for (int i = 1; i < len - 1; i++) {
            int temp = 0; 
            
            for (int j = i - 2; j >= 0; j--) {
                temp = Math.max(temp, T1[j]); 
            }
            
            T1[i] += temp; 
        }
        
        // Build T2
        for (int i = 2; i < len; i++) {
            int temp = 0; 
            
            for (int j = i - 2; j > 0; j--) {
                temp = Math.max(temp, T2[j]); 
            }
            
            T2[i] += temp; 
        }
        
        int result = 0; 
        
        for (int i = 0; i < len; i++) {
            int temp = Math.max(T1[i], T2[i]); 
            result = Math.max(result, temp); 
        }
        
        return result; 
    }
}
