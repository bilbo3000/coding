public class Solution {
    public String convert(String s, int nRows) {
        ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>(); 
        int curr = 0; 
        int flag = 0;  // 0: down; 1: up; 
        
        for (int i = 0; i < nRows; i++) {
            result.add(new ArrayList<Character>()); 
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            result.get(curr).add(c); 
            
            if (curr < nRows - 1 && flag == 0) {  // Move down
                curr++; 
            }
            else if (curr > 0 && flag == 1) {  // Move up
                curr--; 
            }
            
            if (curr == 0) {
                flag = 0; 
            }
            else if (curr == nRows - 1) {
                flag = 1; 
            }
        }
        
        String str = ""; 
        
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                str += result.get(i).get(j); 
            }
        }
        
        return str; 
    }
}
