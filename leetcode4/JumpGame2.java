public class Solution {
    public int jump(int[] A) {
        int len = A.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] T = new int[len]; 
        
        int index = 0; 
        T[0] = 0; 
  
        
        for (int i = 1; i < len; i++) {
            if (i <= A[0]) {
                T[i] = 1; 
                index = i; 
            } else {
                T[i] = -1; 
            }
        }
        
        for (int i = index + 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (T[j] != -1 && A[j] >= (i - j)) {
                    if (T[i] == -1) {
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
