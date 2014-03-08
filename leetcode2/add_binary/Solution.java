public class Solution {
    public String addBinary(String a, String b) {
        char[] c1 = a.toCharArray(); 
        char[] c2 = b.toCharArray(); 
        int len1 = c1.length; 
        int len2 = c2.length; 
        int len = Math.max(len1, len2); 
        char[] result = new char[len]; 
        int carry = 0; 
        
        int i = len1 - 1; 
        int j = len2 - 1; 
        int k = len - 1; 
        
        while (i >= 0 && j >= 0) {
            int digit1 = (int)(c1[i] - '0'); 
            int digit2 = (int)(c2[j] - '0'); 
            int sum = digit1 + digit2 + carry; 
            result[k] = (char)(sum % 2 + '0'); 
            carry = sum / 2; 
            i--; 
            j--; 
            k--; 
        }
        
        while (i >= 0) {
            int digit1 = (int)(c1[i] - '0'); 
            int sum = digit1 + carry; 
            result[k] = (char)(sum % 2 + '0'); 
            carry = sum / 2; 
            i--; 
            k--;           
        }
        
        while (j >= 0) {
            int digit2 = (int)(c2[j] - '0'); 
            int sum = digit2 + carry; 
            result[k] = (char) (sum % 2 + '0') ; 
            carry = sum / 2; 
            j--; 
            k--;            
        }
        
        String resultStr = String.valueOf(result); 
        
        if (carry == 1) {
            resultStr = "1" + resultStr; 
        }
        
        return resultStr; 
    }
}
