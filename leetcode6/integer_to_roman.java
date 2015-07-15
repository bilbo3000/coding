/**
 * Convert given integer to corresponding roman numeral. 
 * The idea was to get each digit in the integer during each iteration. 
 * Then discuss the different scenarios when digit fall into 
 * 1-3, 4, 5-8, 9, and use the divisor and its offsets to retrieve correct 
 * letter to append to the result. 
 * Also use string builder to update the string. 
 */ 
public class Solution {
    private Map<Integer, Character> m = new HashMap<>(); 
    
    {
        m.put(1, 'I'); 
        m.put(5, 'V'); 
        m.put(10, 'X'); 
        m.put(50, 'L');
        m.put(100, 'C'); 
        m.put(500, 'D'); 
        m.put(1000, 'M');
    }
    
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder(); 
        int divisor = 1000; 
        
        while (num != 0) {
            int n = num / divisor; 
            
            if (n == 0) {
                divisor /= 10; 
                continue; 
            }
            
            if (n <= 3) {
                for (int i = 0; i < n; i++) {
                    sb.append(m.get(divisor)); 
                }
            } else if (n == 4) {
                sb.append(m.get(divisor));
                sb.append(m.get(divisor * 5)); 
            } else if (n >= 5 && n <= 8) {
                sb.append(m.get(divisor * 5)); 
                
                for (int i = 0; i < n - 5; i++) {
                    sb.append(m.get(divisor)); 
                }
            } else if (n == 9) {
                sb.append(m.get(divisor));
                sb.append(m.get(divisor * 10)); 
            } 
            
            num %= divisor; 
        }
        
        return sb.toString(); 
    }
}
