public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length; 
        
        int i = len - 2; 
        
        while (i >= 0) {
            if (num[i] < num[i + 1]) {
                break; 
            }
            
            i--; 
        }
        
        if (i < 0) {
            reverse(num, 0, len - 1);
            return; 
        }
        
        int j = len - 1; 
        
        while (j > i) {
            if (num[j] > num[i]) {
                int temp = num[i]; 
                num[i] = num[j]; 
                num[j] = temp; 
                
                reverse(num, i + 1, len - 1); 
                
                return; 
            } 
            
            j--; 
        }
    }
    
    private void reverse(int[] num, int i, int j) {
        while (i < j) {
            int temp = num[i]; 
            num[i] = num[j]; 
            num[j] = temp; 
            i++; 
            j--; 
        }
    }
}
