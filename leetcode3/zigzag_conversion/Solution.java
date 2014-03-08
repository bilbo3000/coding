public class Solution {
    public String convert(String s, int nRows) {
        ArrayList<ArrayList<Character>> t = new ArrayList<ArrayList<Character>>(); 
        
        for (int i = 0; i < nRows; i++) {
            t.add(new ArrayList<Character>()); 
        }
        
        boolean flag = true;  // true: down; false: up; 
        int index = 0; 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            t.get(index).add(c);
            
            if (flag) {
                if (index == nRows - 1 && index > 0) {
                    index--; 
                    flag = false; 
                }
                else if (index < nRows - 1) {
                    index++; 
                }
            }
            else {
                if (index == 0 && index < nRows - 1) {
                    index++; 
                    flag = true; 
                }
                else if (index > 0) {
                    index--; 
                }
            }
        }
        
        String result = ""; 
        
        for (int i = 0; i < nRows; i++) {
            ArrayList<Character> row = t.get(i); 
            
            for (Character c : row) {
                result += c; 
            }
        }
        
        return result; 
    }
}
