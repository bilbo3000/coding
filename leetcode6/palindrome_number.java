/**
 * Check if a number is palindrome. 
 * The idea was first convert input to long type. Note that negative number 
 * is not palindrome. Then find the max base such that x / base is less than 
 * 10. Each time we trim the digits on both sides via divide base and modulo 
 * 10. To get middle part for next iteration to process, we modulo the base
 * and shift to right. Also don't forget to divide the base by 100 since we 
 * lose two digits. 
 */ 
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false; 
        }
        
        long n = (long) x; 
        long base = 1; 
        
        while (n / base >= 10) {
            base = base * 10; 
        }
        
        while (n != 0 && base != 0) {
            long left = n / base; 
            long right = n % 10; 
            
            if (left != right) {
                return false; 
            }
            
            n = n % base; 
            n = n / 10; 
            
            base = base / 100; 
        }
        
        return true; 
    }
}
