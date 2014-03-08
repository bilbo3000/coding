public class Solution {
    public int singleNumber(int[] A) {
        int one = 0; 
        int two = 0; 
        int three = 0; 
        
        for (int i = 0; i < A.length; i++) {
            two |= one & A[i];  // Update two
            one = one ^ A[i];   // Update one 
            three = one & two;  // Update three 
            one &= ~three;      // Reset
            two &= ~three; 
        }
        
        return one; 
    }
}
