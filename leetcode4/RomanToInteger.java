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
        int len = s.length(); 
        int result = 0; 
        
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i); 
            if (i > 0) {
                char prev = s.charAt(i - 1);
                if (m.get(curr) > m.get(prev)) {
                    result = result - m.get(prev) * 2; 
                }
            }
            
            result += m.get(curr); 
        }
        
        return result; 
    }
}
