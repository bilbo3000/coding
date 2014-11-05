public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length; 
        
        if (len <= 2) {
            return len; 
        }
        
        int pos = 1; 
        int save = A[pos]; 
        
        for (int i = 2; i < len; i++) {
            if (i - 2 != pos) {
                if (A[i] != A[i - 2]) {
                    pos++; 
                    save = A[pos]; 
                    A[pos] = A[i]; 
                }
            } else {
                if (A[i] != save) {
                    pos++; 
                    save = A[pos]; 
                    A[pos] = A[i]; 
                }
            }
        }
        
        return pos + 1; 
    }
}
