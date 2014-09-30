public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length; 
        int[] T = new int[len]; 
        
        for (int i = 0; i < len; i++) {
            T[i] = 1; 
        }
        
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                T[i] = T[i - 1] + 1; 
            }
        }
        
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && T[i] <= T[i + 1]) {
                T[i] = T[i + 1] + 1; 
            }
        }
        
        int result = 0; 
        
        for (int i = 0; i < T.length; i++) {
            result += T[i]; 
        }
        
        return result; 
    }
}
