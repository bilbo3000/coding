public class Solution {
    public int singleNumber(int[] A) {
        int one = 0; 
        int two = 0; 
        int three = 0; 
        
        for (int x : A) {
            two |= one & x; 
            one ^= x;
            three = two & one; 
            one &= ~three; 
            two &= ~three; 
        }
        
        return one; 
    }
}
