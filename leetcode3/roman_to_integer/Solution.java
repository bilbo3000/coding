public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<Character, Integer>(); 
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
            
            if (i > 0) {
                char prevChar = s.charAt(i - 1);
                int prevVal = m.get(prevChar); 
                
                if (prevVal < m.get(c)) {
                    result -= prevVal * 2; 
                }
            }
        }
        
        return result; 
    }
}
