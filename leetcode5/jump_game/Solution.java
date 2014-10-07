public class Solution {
    public boolean canJump(int[] A) {
        int len = A.length; 
        boolean[] T = new boolean[len]; // T[i]: whether can jump to i
        T[0] = true; 
        
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (T[j] && A[j] >= i - j) {
                    T[i] = true; 
                    break; 
                }
            }
        }
        
        return T[len - 1]; 
    }
}
