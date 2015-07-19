/**
 * Determine if a given number is happy number. 
 * Happy number is a number where if we keep iterating and in each 
 * iteration, the number becomes the square sum of all its digits. 
 * The idea was to iterating the number until the number becomes 1. 
 * The tricky part is that we need to maintain a set to keep track 
 * of the history, which is the number we have already seen, to avoid 
 * going around circles.
 */ 
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> history = new HashSet<>(); 
        
        while (n != 1) {
            if (history.contains(n)) {
                return false; 
            }
            
            history.add(n); 
            int result = 0; 
            
            while (n != 0) {
                int digit = n % 10; 
                n = n / 10; 
                result += (int) Math.pow(digit, 2); 
            }
            
            n = result; 
        }
        
        return true; 
    }
}
