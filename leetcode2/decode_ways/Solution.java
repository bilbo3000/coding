public class Solution {
    public int numDecodings(String s) {
        int len = s.length(); 
        
        if (len == 0) return 0; 
        
        int[] T = new int[len + 1]; 
        T[0] = 1; 
        
        if (s.charAt(0) != '0') T[1] = 1; 
        
        for (int i = 2; i <= len; i++) {
            int index = i - 1; 
            
            if (s.charAt(index) != '0') {
                T[i] = T[i - 1]; 
            }
            
            if (s.charAt(index - 1) == '1' || (s.charAt(index - 1) == '2' && s.charAt(index) <= '6')) {
                T[i] += T[i - 2]; 
            }
        }
        
        return T[len]; 
    }
}
