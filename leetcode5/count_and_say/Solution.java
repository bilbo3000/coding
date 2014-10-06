public class Solution {
    public String countAndSay(int n) {
        if (n == 0) {
            return ""; 
        }
        
        String result = "1"; 
        
        while (n > 1) {
            List<Character> digits = new ArrayList<Character>(); 
            List<Integer> cnt = new ArrayList<Integer>(); 
            
            for (int i = 0; i < result.length(); i++) {
                char c = result.charAt(i); 
                
                if (digits.size() == 0) {
                    digits.add(c);
                    cnt.add(1); 
                } else {
                    if (c == digits.get(digits.size() - 1)) {
                        int len = cnt.size(); 
                        cnt.set(len - 1, cnt.get(len - 1) + 1); 
                    } else {
                        digits.add(c);
                        cnt.add(1); 
                    }
                }
            }
            
            result = ""; 
            
            for (int i = 0; i < digits.size(); i++) {
                result += (char)(cnt.get(i) + '0'); 
                result += digits.get(i); 
            }
            
            n--; 
        }
        
        return result; 
    }
}
