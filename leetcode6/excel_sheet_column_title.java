/**
 * Convert given integer to corresponding Excel column title. 
 * Think the problem as converting 10 based number to 26 based number. The tricky 
 * part is that we want to have each position to be 0-25 instead of 1-26, thus we need to minus 1 from 
 * n each time. 
 */ 
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder(); 
        
        while (n > 0) {
            n = n - 1; 
            int digit = n % 26; 
            char c = (char) ('A' + digit); 
            sb.insert(0, c); 
            
            n = n / 26; 
        }
        
        return sb.toString(); 
    }
}
