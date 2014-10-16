public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0; 
        String result = ""; 
        int i = a.length() - 1; 
        int j = b.length() - 1; 
        
        while (i >= 0 && j >= 0) {
            int digit1 = (int) (a.charAt(i) - '0');
            int digit2 = (int) (b.charAt(j) - '0');
            int sum = digit1 + digit2 + carry; 
            int digit = sum % 2; 
            carry = sum / 2; 
            result = ((char) (digit + '0')) + result; 
            i--; 
            j--; 
        }
        
        while (i >= 0) {
            int digit1 = (int) (a.charAt(i) - '0');
            int sum = digit1 + carry; 
            int digit = sum % 2;
            carry = sum / 2; 
            result = ((char) (digit + '0')) + result;
            i--; 
        }
        
        while (j >= 0) {
            int digit2 = (int) (b.charAt(j) - '0'); 
            int sum = digit2 + carry; 
            int digit = sum % 2; 
            carry = sum / 2; 
            result = ((char) (digit + '0')) + result;
            j--; 
        }
        
        if (carry == 1) {
            result = '1' + result; 
        }
        
        return result; 
    }
}
