/**
 * Add two binary numbers represented as strings. 
 * The idea was to convert the input to character array first. Then walk through 
 * the arrays backwards and add each digit. Also need to maintain a carry along 
 * the way. Note that the length of two inputs could be different, thus need to 
 * process the remaining parts. Also, at the end, the carry could be non-zero, 
 * which require one more space. 
 */ 
public class Solution {
    public String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray(); 
        char[] arr2 = b.toCharArray(); 
        int len1 = arr1.length; 
        int len2 = arr2.length; 
        int carry = 0; 
        int i = len1 - 1; 
        int j = len2 - 1; 
        char[] output = null; 
        int k = 0; 
        
        if (len1 > len2) {
            output = arr1;
            k = i; 
        } else {
            k = j; 
            output = arr2; 
        }
        
        while (i >= 0 && j >= 0) {
            int sum = Character.getNumericValue(arr1[i]) + Character.getNumericValue(arr2[j]) + carry; 
            int digit = sum % 2; 
            carry = sum / 2; 
            output[k] = (char)(digit + '0');
            i--; 
            j--; 
            k--; 
        }
        
        while (i >= 0) {
            int sum = Character.getNumericValue(arr1[i]) + carry; 
            int digit = sum % 2; 
            carry = sum / 2; 
            output[k] = (char)(digit + '0');
            i--; 
            k--; 
        }
        
        while (j >= 0) {
            int sum = Character.getNumericValue(arr2[j]) + carry; 
            int digit = sum % 2; 
            carry = sum / 2; 
            output[k] = (char)(digit + '0');
            j--; 
            k--; 
        }
        
        if (carry == 0) {
            return String.valueOf(output); 
        }
        
        char[] result = new char[output.length + 1];
        result[0] = '1'; 
        
        for (int index = 0; index < output.length; index++) {
            result[index + 1] = output[index]; 
        }
        
        return String.valueOf(result);
    }
}
