public class Solution {
    public int jump(int[] A) {
        int len = A.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] T = new int[len]; 
        T[0] = 0; 
        int i = 1; 
        
        while (i <= A[0] && i < len) {
            T[i] = 1; 
            i++; 
        }
        
        while (i < len) {
            T[i] = Integer.MAX_VALUE;
            
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] >= (i - j)) {
                    T[i] = Math.min(T[i], T[j] + 1); 
                }
            }
            
            i++; 
        }
        
        return T[len - 1]; 
    }
}
