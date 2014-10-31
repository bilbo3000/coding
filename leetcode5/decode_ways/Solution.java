public class Solution {
    public int numDecodings(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] T = new int[len + 1];
        T[0] = 1; 
        
        if (s.charAt(0) == '0') {
            return 0; 
        }
        
        T[1] = 1; 
        
        for (int i = 1; i < len; i++) {
            char prev = s.charAt(i - 1); 
            char curr = s.charAt(i); 
                
            if (curr == '0') {
                if (prev == '1' || prev == '2') {
                    T[i + 1] = T[i - 1]; 
                } else {
                    return 0; 
                }
            }
             else if (prev == '1' || (prev == '2' && curr <= '6')) {
                T[i + 1] = T[i] + T[i - 1]; 
            } else {
                T[i + 1] = T[i]; 
            }
        }
        
        return T[len]; 
    }
}
