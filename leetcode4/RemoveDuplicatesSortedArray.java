public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length; 
        
        for (int i = 2; i < len; i++) {
            if (A[i] == A[i - 1] && A[i] == A[i - 2]) {
                for (int j = i + 1; j < len; j++) {
                    A[j - 1] = A[j]; 
                }
                
                len--; 
                i--; 
            }
        }
        
        return len; 
    }
}
