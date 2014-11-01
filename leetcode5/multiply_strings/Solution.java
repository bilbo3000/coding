public class Solution {
    public String multiply(String num1, String num2) {
        char[] n1 = num1.toCharArray(); 
        char[] n2 = num2.toCharArray(); 
        
        int len1 = n1.length; 
        int len2 = n2.length; 
        
        if (len1 == 0 || len2 == 0) {
            return "0"; 
        }
        
        int[] result = new int[len1 + len2]; 
        
        for (int j = len2 - 1; j >= 0; j--) {
            int carry = 0; 
            int i = len1 - 1; 
            
            while (i >= 0) {
                int d1 = (int) (n1[i] - '0'); 
                int d2 = (int) (n2[j] - '0'); 
                
                int sum = d1 * d2 + result[i + j + 1] + carry;
                carry = sum / 10; 
                int digit = sum % 10; 
                result[i + j + 1] = digit; 
                i--; 
            }
            
            if (carry != 0) {
                result[i + j + 1] += carry; 
            }
        }
        
        StringBuilder builder = new StringBuilder(""); 
        int i = 0; 
        
        while (i < result.length && result[i] == 0) {
            i++; 
        }
        
        if (i == result.length) {
            return "0";     
        }
        
        while (i < result.length) {
            builder.append((char) (result[i] + '0')); 
            i++; 
        }
        
        return builder.toString(); 
    }
}
