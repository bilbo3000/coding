public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1; 
        int len = digits.length; 
        
        for (int i = len - 1; i >= 0; i--) {
            int digit = digits[i]; 
            int sum = digit + carry; 
            digits[i] = (sum) % 10; 
            carry = sum / 10; 
        }
        
        if (carry == 0) return digits; 
        
        int [] result = new int[len + 1]; 
        
        result[0] = 1; 
        
        for (int i = 0; i < len; i++) {
            result[i + 1] = digits[i]; 
        }
        
        return result; 
    }
}
