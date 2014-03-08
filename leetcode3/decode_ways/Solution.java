public class Solution {
    public int numDecodings(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return 0; 
        }

        int[] T = new int[len + 1]; 
        T[0] = 1; 
        
        if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
            T[1] = 1; 
        }
        
        for (int i = 1; i < len; i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1); 
            
            if (prev == '1' || (prev == '2' && curr <= '6')) {
                T[i + 1] += T[i - 1]; 
            }
            
            if (curr >= '1' && curr <= '9') {
                T[i + 1] += T[i]; 
            }
        }
        
        return T[len]; 
    }
    
}