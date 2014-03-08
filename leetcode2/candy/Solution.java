public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length; 
        int result = 0; 
        int[] c = new int[n]; 
        
        // Each kid has one candy first 
        for (int i = 0; i < n; i++) {
            c[i] = 1; 
        }
        
        // First pass from left to right 
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                c[i] = c[i - 1] + 1;
            } 
        }
        
        // Second pass from right to left 
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && c[i] <= c[i + 1]) 
            {
                c[i] = c[i + 1] + 1;
            } 
        }
        
        for (int i = 0; i < n; i++) {
            result += c[i]; 
        }
        
        return result; 
    }
}
