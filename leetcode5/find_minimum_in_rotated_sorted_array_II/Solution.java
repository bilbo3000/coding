public class Solution {
    public int findMin(int[] num) {
        int len = num.length; 
        
        if (len == 1) {
            return num[0]; 
        }
        
        if (num[0] < num[len - 1]) {
            return num[0]; 
        }
        
        int i = len - 1; 
        
        while (i > 0 && num[i] >= num[i - 1]) {
            i--; 
        }
        
        return num[i]; 
    }
}
