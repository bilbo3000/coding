/**
 * Find the total number of ones in the all the positive numbers that are less than the given number. 
 * Solve it recursively. The idea was to split the number into sections and calculate each section. 
 * If the left most digit is 1, it means the count would be the sum of 1) the number if first digit: n % base + 1; 
 * 2) the number of ones in remainder: f(n % base); and 3) The number of ones in all previous numbers that with one 
 * less digit: f(base - 1). 
 * However, if the left most digit is not 1, then the count would be the sum of 1) the count of numbers starting 
 * with 1 and all previous numbers: f(2 * base - 1); 2) numbers in between: (left - 2) * f(base - 1); 3) the remainder: 
 * f(n % base); 
 */ 
public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0; 
        }
        
        if (n < 10) {
            return 1; 
        }
        
        int base = 1; 
        
        while (n / base > 9) {
            base = base * 10; 
        }
        
        int left = n / base; 
        
        if (left == 1) {
            return countDigitOne(n % base) + (n % base + 1) + countDigitOne(base - 1);
        } else {
            return countDigitOne(2 * base - 1) + (left - 2) * countDigitOne(base - 1) + countDigitOne(n % base);
        }
    }
}
