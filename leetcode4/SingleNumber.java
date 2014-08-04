public class Solution {
    public int singleNumber(int[] A) {
        int len = A.length; 
        int result = A[0]; 
        
        for (int i = 1; i < len; i++) {
            result = result ^ A[i]; 
        }
        
        return result; 
    }
}
