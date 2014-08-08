public class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length(); 
        int len2 = b.length(); 
        
        if (len1 == 0) {
            return b; 
        }
        
        if (len2 == 0) {
            return a; 
        }
        
        String result = ""; 
        int carry = 0; 
        
        int i = len1 - 1; 
        int j = len2 - 1; 
        
        while (i >= 0 && j >= 0) {
            int digit1 = (int)(a.charAt(i) - '0');
            int digit2 = (int)(b.charAt(j) - '0');
            int digit = digit1 + digit2 + carry; 
            carry = digit / 2; 
            digit = digit % 2; 
            result = (char)(digit + '0') + result; 
            i--; 
            j--; 
        }
        
        if (i >= 0) {
            while (i >= 0) {
                int digit1 = (int)(a.charAt(i) - '0');
                int digit = digit1 + carry; 
                carry = digit / 2; 
                digit = digit % 2; 
                result = (char)(digit + '0') + result;
                i--; 
            }
        } else if (j >= 0) {
            while (j >= 0) {
                int digit2 = (int)(b.charAt(j) - '0');
                int digit = digit2 + carry; 
                carry = digit / 2; 
                digit = digit % 2; 
                result = (char)(digit + '0') + result;
                j--;
            }
        }
        
        if (carry == 1) {
            result = "1" + result; 
        }
        
        return result; 
    }
}
