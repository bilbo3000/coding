public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length; 
        
        int i = len - 1; 
        
        while (i > 0 && num[i] <= num[i - 1]) {
            i--; 
        }
        
        if (i <= 0) {
            reverse(num, 0, len - 1); 
            return; 
        }
        
        int j = len - 1; 
        
        while (j >= i && num[j] <= num[i - 1]) {
            j--; 
        }
        
        int temp = num[i - 1]; 
        num[i - 1] = num[j]; 
        num[j] = temp; 
        
        reverse(num, i, len - 1); 
    }
    
    void reverse(int[] num, int i, int j) {
        while (i < j) {
            int temp = num[i]; 
            num[i] = num[j]; 
            num[j] = temp; 
            i++; 
            j--; 
        }
    }
}
