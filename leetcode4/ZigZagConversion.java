public class Solution {
    public String convert(String s, int nRows) {
        List<List<Character>> rows = new ArrayList<List<Character>>(); 
        
        for (int i = 0; i < nRows; i++) {
            rows.add(new ArrayList<Character>()); 
        }
        
        int curr = 0; 
        boolean down = true; 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            rows.get(curr).add(c);
            
            if (down) {
                if (curr == nRows - 1 && curr != 0) {
                    down = false; 
                    curr--; 
                } else if (curr < nRows - 1){
                    curr++; 
                }
            } else {
                if (curr == 0 && curr != nRows - 1) {
                    down = true; 
                    curr++; 
                } else if (curr > 0) {
                    curr--; 
                }
            }
        }
        
        String result = ""; 
        
        for (int i = 0; i < rows.size(); i++) {
            for (Character item : rows.get(i)) {
                result += item; 
            }
        }
        
        return result; 
    }
}
