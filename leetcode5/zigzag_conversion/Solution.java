public class Solution {
    public String convert(String s, int nRows) {
        List<List<Character>> rows = new ArrayList<List<Character>>(); 
        
        for (int i = 0; i < nRows; i++) {
            rows.add(new ArrayList<Character>()); 
        }
        
        int index = 0; 
        boolean up = false; 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            rows.get(index).add(c);
            
            if (!up) {
                if (index < nRows - 1) {
                    index++; 
                } else if (index > 0) {
                    up = true; 
                    index--; 
                }
            } else {
                if (index > 0) {
                    index--; 
                } else if (index < nRows - 1) {
                    up = false; 
                    index++; 
                }
            }
        }
        
        String result = ""; 
        
        for (int i = 0; i < nRows; i++) {
            List<Character> row = rows.get(i); 
            
            for (Character c : row) {
                result += c; 
            }
        }
        
        return result; 
    }
}
