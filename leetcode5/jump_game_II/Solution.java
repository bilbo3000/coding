public class Solution {
    public int jump(int[] A) {
        int len = A.length; 
        int[] T = new int[len];  // T[i]: minimal number of jumps to position i
        
        T[0] = 0; 
        
        for (int i = 1; i <= A[0]; i++) {
            if (i < len) {
                T[i] = 1; 
            } else {
                break; 
            }
        }
        
        for (int i = A[0] + 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] >= i - j) {
                    
                    if (T[i] == 0) {
                        T[i] = T[j] + 1; 
                    } else {
                        T[i] = Math.min(T[i], T[j] + 1); 
                    }
                }
            }
        }
        
        return T[len - 1]; 
    }
}
