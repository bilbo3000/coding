public class Solution {
    public String countAndSay(int n) {
        if (n == 0) {
            return ""; 
        }
        
        String result = "1"; 
        
        for (int i = 1; i < n; i++) {
            String temp = ""; 
            int len = result.length(); 
            int j = 0; 
            
            while (j < len) {
                int digit = result.charAt(j) - '0'; 
                int cnt = 1; 
                
                int k = j + 1; 
                while (k < len && result.charAt(k) == result.charAt(j)) {
                    cnt++; 
                    k++; 
                }
                
                temp += (char)(cnt + '0'); 
                temp += (char)(digit + '0'); 
                j = k; 
            }
            
            result = temp; 
        }
        
        return result; 
    }
}
