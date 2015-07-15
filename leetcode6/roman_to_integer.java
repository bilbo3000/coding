/**
 * Convert roman numeral to integer. 
 * The idea was to walk through the input and add the value of each 
 * letter to the result. Then check whether current letter is larger 
 * than the previous letter, if so, minus the value of previous letter 
 * twice. 
 * The reason we need to substract twice is that we added the previous 
 * letter value extra two times. One was via the letter itself. The other 
 * one was via the current letter. 
 */ 
public class Solution {
    private Map<Character, Integer> m = new HashMap<>(); 
    
    public int romanToInt(String s) {
        m.put('I', 1); 
        m.put('V', 5); 
        m.put('X', 10); 
        m.put('L', 50);
        m.put('C', 100); 
        m.put('D', 500); 
        m.put('M', 1000); 
        
        int result = 0; 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            result += m.get(c); 
            
            if (i > 0 && m.get(s.charAt(i - 1)) < m.get(c)) {
                result -= m.get(s.charAt(i - 1)) * 2; 
            }
        }
        
        return result; 
    }
}
