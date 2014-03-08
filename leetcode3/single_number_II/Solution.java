public class Solution {
    public int singleNumber(int[] A) {
        int one = 0; 
        int two = 0; 
        int three = 0; 
        
        for (int i = 0; i < A.length; i++) {
            two |= one & A[i]; 
            one ^= A[i]; 
            three = two & one; 
            two &= ~three; 
            one &= ~three; 
        }
        
        return one; 
    }
}
