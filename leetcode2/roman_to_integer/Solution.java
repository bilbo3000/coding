public class Solution {
    Map<Character, Integer> m = new HashMap<Character, Integer>();
    
    public int romanToInt(String s) {
        int result = 0; 
        int len = s.length(); 
        buildMap(); 
         
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i); 
            int currVal = m.get(curr); 
            result += currVal; 
            
            if (i < len - 1) {
                char next = s.charAt(i + 1);
                int nextVal = m.get(next); 
                
                if (currVal < nextVal) {
                    result -= currVal * 2; 
                }
            }
        }
        
        return result; 
    }
    
    private void buildMap() {
        m.put('I', 1); 
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
    }
}
