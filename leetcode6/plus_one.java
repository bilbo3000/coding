/**
 * A 10-base number where its digits are stored in an array from left to right,
 * add one to the number. 
 * The idea was to initialize carry to be one. Then iterate though the array from 
 * right to left. Once it reaches the end and carry is not zero, create a new array 
 * with one more slot, set carry to be the first element and copy the rest of the 
 * array. 
 */ 
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1; 
        int len = digits.length; 

        for (int i = len - 1; i >= 0; i--) {
            int digit = digits[i]; 
            int sum = digits[i] + carry; 
            digits[i] = sum % 10; 
            carry = sum / 10; 
        }
        
        if (carry == 0) {
            return digits; 
        }
        
        int[] temp = new int[len + 1]; 
        
        for (int i = 0; i < len; i++) {
            temp[i + 1] = digits[i]; 
        }
        
        temp[0] = carry; 
        
        return temp; 
    }
}
