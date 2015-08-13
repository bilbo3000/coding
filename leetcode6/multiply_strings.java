/**
 * Multiple two numbers represented as strings. 
 * A couple of things need to pay attension: 
 * 1) numbers may have '+' or '-' in front; 
 * 2) numbers may be any large; 
 * 3) Convert both strings to character arrays; 
 * 4) The new array would be int type and have length at most len1 + len2; 
 * 5) Index for new array would be i + j + 1; 
 * 6) sum = product + carry + arr[i + j + 1]; 
 * 7) Need to ignore leaing zeros;
 * 8) Entire result could be zero; 
 * 9) Don't forget to add '-' in the front if needed. 
 */ 
public class Solution {
    public String multiply(String num1, String num2) {
        boolean isNeg1 = false; 
        boolean isNeg2 = false; 
        
        if (num1.charAt(0) == '+' || num1.charAt(0) == '-') {
            if (num1.charAt(1) == '-') {
                isNeg1 = true; 
            }
            
            num1 = num1.substring(1);
        }
        
        if (num2.charAt(0) == '+' || num2.charAt(0) == '-') {
            if (num2.charAt(0) == '-') {
                isNeg2 = true; 
            }
            
            num2 = num2.substring(1);
        }
        
        boolean isNeg = isNeg1 ^ isNeg2; 
        
        char[] arr1 = num1.toCharArray(); 
        char[] arr2 = num2.toCharArray(); 
        int[] arr = new int[arr1.length + arr2.length];
        int j = arr2.length - 1; 
    
        while (j >= 0) {
            int carry = 0; 
            int i = arr1.length - 1; 
            
            while (i >= 0) {
                int digit1 = (int) (arr1[i] - '0');
                int digit2 = (int) (arr2[j] - '0');
                int product = digit1 * digit2; 
                int sum = product + carry + arr[i + j + 1];
                int digit = sum % 10; 
                carry = sum / 10; 
                arr[i + j + 1] = digit;
                i--;
            }
            
            if (carry != 0) {
                arr[i + j + 1] = carry;
            }
            
            j--; 
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        int a = 0; 
        
        while (a < arr.length && arr[a] == 0) {
        	a++; 
        }
        if (a == arr.length) {
        	return "0"; 
        }
        
        while (a < arr.length) {
            sb.append(String.valueOf(arr[a]));
            a++; 
        }
        
        if (isNeg) {
            sb.insert(0, '-');
        }
        
        return sb.toString();
    }
}
