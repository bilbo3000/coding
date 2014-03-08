public class Solution {
    public boolean canJump(int[] A) {
        int len = A.length; 
        boolean[] T = new boolean[len]; 
        T[0] = true; 
        
        for (int i = 1; i < len; i++) {
            int j = i - 1; 
            
            while (j >= 0) {
                if (A[j] >= (i - j)) {
                    T[i] = T[j]; 
                    break; 
                }
                
                j--; 
            }
            
            if (j < 0) T[i] = false; 
        }
        
        return T[len - 1]; 
    }
}
