public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        int one = 0; 
        int two = 0; 
        int three = 0; 
        
        for (int i = 0; i < A.length; i++) {
            two |= one & A[i]; 
            one = one ^ A[i];
            three = two & one; 
            one &= ~three; 
            two &= ~three; 
        }
        
        return one; 
    }
}
