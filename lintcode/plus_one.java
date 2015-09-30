public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     * 
     * O(n)
     */
    public int[] plusOne(int[] digits) {
        int carry = 1; 
        int len = digits.length; 
        int i = len - 1; 
        
        while (i >= 0) {
            int sum = digits[i] + carry; 
            carry = sum / 10; 
            digits[i] = sum % 10; 
            i--; 
        }
        
        if (carry != 0) {
            int[] result = new int[len + 1]; 
            result[0] = carry; 
            
            for (int j = 0; j < len; j++) {
                result[j + 1] = digits[j];
            }
            
            return result; 
        } 
        
        return digits; 
    }
}
