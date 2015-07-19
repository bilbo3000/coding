/**
 * Verify if a string is valid palindrome or not. 
 * The ideas was to use two pointers traversing towards each other form 
 * two ends, and check each alphanumeric number pair whether they are 
 * the same or not. 
 * Note that
 * (1) empty string is palindrome. 
 * (2) need to ignore leading and trailing empty spaces. 
 */ 
public class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length(); 
        
        if (len == 0 || s.isEmpty()) {
            return true; 
        }
        
        char[] arr = s.toCharArray(); 
        int i = 0; 
        int j = len - 1; 
        
        while (i < len && arr[i] == ' ') {
            i++; 
        }
        
        while (j >= 0 && arr[j] == ' ') {
            j--; 
        }
        
        while (i <= j) {
            while (i < len && (!((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= '0' && arr[i] <= '9') ))) {
                i++; 
            }
            
            while (j >= 0 && (!((arr[j] >= 'a' && arr[j] <= 'z') || (arr[j] >= 'A' && arr[j] <= 'Z') || (arr[j] >= '0' && arr[j] <= '9')))) {
                j--; 
            }
            
            if (i > j) {
                return true; 
            }
            
            if (Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[j])) {
                return false; 
            }
            
            i++; 
            j--; 
        }
        
        return true; 
    }
}
