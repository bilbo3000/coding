/**
 * Convert the given string in zigzag fashion. 
 * The idea was to maintain a boolean to indicate whether to move down or up. 
 * We need to reverse the direction once we reaches the top or bottom row. 
 * Also, we could only move up or down if there is one more row above or below. 
 */ 
public class Solution {
    public String convert(String s, int numRows) {
        List<List<Character>> list = new ArrayList<List<Character>>(); 
        
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<Character>()); 
        }
        
        int row = 0; 
        boolean isDown = true; 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            list.get(row).add(c); 
            
            if (isDown) {
                if (row < numRows - 1) {
                    row++; 
                } else if (row > 0) {
                    row--; 
                    isDown = false; 
                }
            } else {
                if (row > 0) {
                    row--;
                } else if (row < numRows - 1){
                    row++;
                    isDown = true;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        for (int i = 0; i < numRows; i++) {
            List<Character> item = list.get(i);
            
            for (Character c : item) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
