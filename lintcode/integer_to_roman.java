public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
        Map<Integer, Character> m = new HashMap<>(); 
        m.put(1, 'I');
        m.put(5, 'V');
        m.put(10, 'X');
        m.put(50, 'L'); 
        m.put(100, 'C');
        m.put(500, 'D');
        m.put(1000, 'M');
        
        int base = 1000; 
        StringBuilder sb = new StringBuilder(); 
        
        while (n > 0) {
            int d = n / base; 
            
            if (d <= 3) {
                for (int i = 0; i < d; i++) {
                    sb.append(m.get(base));
                }
            } else if (d == 4) {
                sb.append(m.get(base));
                sb.append(m.get(base * 5));
            } else if (d <= 8) {
                sb.append(m.get(base * 5));
                
                for (int i = 0; i < d - 5; i++) {
                    sb.append(m.get(base)); 
                }
            } else {
                sb.append(m.get(base));
                sb.append(m.get(base * 10));
            }
            
            n = n % base; 
            base = base / 10; 
        }
        
        return sb.toString(); 
    }
}
