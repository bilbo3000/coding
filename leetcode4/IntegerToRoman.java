public class Solution {
    public String intToRoman(int num) {
        Map<Integer, Character> m = new HashMap<Integer, Character>(); 
        m.put(1, 'I');
        m.put(5, 'V'); 
        m.put(10, 'X');
        m.put(50, 'L');
        m.put(100, 'C');
        m.put(500, 'D');
        m.put(1000, 'M'); 
    
        int base = 1000; 
        String result = ""; 
        
        while (base > 0) {
            int count = num / base; 
            num  = num % base; 
            
            if (count > 0 && count <= 3) {
                for (int i = 0; i < count; i++) {
                    result += m.get(base); 
                }
            } else if (count == 4) {
                result += m.get(base);
                result += m.get(base * 5); 
            } else if (count >= 5 && count < 9) {
                result += m.get(base * 5); 
                
                for (int i = 5; i < count; i++) {
                    result += m.get(base); 
                }
            } else if (count == 9) {
                result += m.get(base); 
                result += m.get(base * 10); 
            }
            
            base /= 10; 
        }
        
        return result; 
    }
}
