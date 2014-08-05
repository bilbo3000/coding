public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length; 
        int carry = 1; 
        
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + carry; 
            int digit = sum % 10; 
            carry = sum / 10; 
            digits[i] = digit; 
        }
        
        if (carry == 0) {
            return digits; 
        }
        
        int[] temp = new int[len + 1];
        temp[0] = carry; 
        for (int i = 0; i < len; i++) {
            temp[i + 1] = digits[i]; 
        }
        
        return temp; 
    }
}
