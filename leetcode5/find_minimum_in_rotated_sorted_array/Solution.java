public class Solution {
    public int findMin(int[] num) {
        int len = num.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        if (num[0] <= num[len - 1]) {
            return num[0]; 
        }
        
        int i = len - 1; 
        
        while (i > 0 && num[i - 1] <= num[i]) {
            i--; 
        }
        
        return num[i]; 
    }
}
