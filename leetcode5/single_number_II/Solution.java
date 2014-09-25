public class Solution {
    public int singleNumber(int[] A) {
        int one = 0; 
        int two = 0; 
        int three = 0; 
        
        for (int item : A) {
            two |= item & one; 
            one ^= item; 
            three = two & one; 
            one &= ~three; 
            two &= ~three; 
        }
        
        return one; 
    }
}
