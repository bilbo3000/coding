public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length; 
        
        if (len == 0 || len == 1 || len == 2) {
            return len; 
        }

        int i = 1; 
        int j = 2;
        int prev2 = A[0]; 
        int prev1 = A[1]; 
        
        while (j < len) {
            if (A[j] != prev1 || A[j] != prev2) {
                A[++i] = A[j]; 
            }
            
            prev2 = prev1; 
            prev1 = A[j]; 
            j++; 
        }
        
        return i + 1;
    }
}
