public class Solution {
    public int candy(int[] ratings) {
        int result = 0; 
        int len = ratings.length; 
        int[] candy = new int[len];
        
        for (int i = 0; i < len; i++) {
            candy[i] = 1; 
        }
        
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1; 
            }
        }
        
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1; 
            }
        }
        
        for (int i = 0; i < len; i++) {
            result += candy[i]; 
        }
        
        return result; 
    }
}
