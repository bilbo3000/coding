public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1; 
        int len = digits.length; 
        
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + carry; 
            int newDigit = sum % 10; 
            carry = sum / 10; 
            digits[i] = newDigit; 
        }
        
        if (carry == 0) {
            return digits; 
        }
        
        int[] result = new int[len + 1]; 
        
        for (int i = len - 1; i >= 0; i--) {
            result[i + 1] = digits[i]; 
        }
        
        result[0] = 1; 
        
        return result; 
    }
}
