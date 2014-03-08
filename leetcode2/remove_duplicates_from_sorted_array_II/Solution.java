public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length; 
        int cnt = 1; 
        
        for (int i = 1; i < len; i++) {
            if (A[i] == A[i - 1]) {
                if (cnt == 1) {
                    cnt++; 
                } 
                else {
                    for (int j = i + 1; j < len; j++) {
                        A[j - 1] = A[j]; 
                    }
                    
                    len--; 
                    i--; 
                }
            }
            else {
                cnt = 1; 
            }
        }
        
        return len; 
    }
}
