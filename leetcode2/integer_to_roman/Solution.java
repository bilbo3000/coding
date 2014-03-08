public class Solution {
    Map<Integer, Character> m = new HashMap<Integer, Character>(); 
    
    public String intToRoman(int num) {
        buildMap(); 
        String result = ""; 
        
        while (num != 0) {
            int divisor = 1; 
            
            while (num / divisor > 9) {
                divisor *= 10; 
            }
            
            int digit = num / divisor; 
            num = num % divisor; 
            
            switch(digit) {
                case 1: case 2: case 3: 
                    for (int i = 0; i < digit; i++) {
                        result += m.get(divisor); 
                    }
                    break; 
                case 4: 
                    result += m.get(divisor); 
                    result += m.get(divisor * 5); 
                    break; 
                case 5: case 6: case 7: case 8:
                    result += m.get(divisor * 5);
                    
                    for (int i = 0; i < digit - 5; i++) {
                        result += m.get(divisor); 
                    }
                    break; 
                case 9: 
                    result += m.get(divisor); 
                    result += m.get(divisor * 10); 
                    break; 
            }
        }
        
        return result; 
    }
    
    private void buildMap() {
        m.put(1, 'I');
        m.put(5, 'V');
        m.put(10, 'X');
        m.put(50, 'L');
        m.put(100, 'C');
        m.put(500, 'D');
        m.put(1000, 'M');
    }
}
