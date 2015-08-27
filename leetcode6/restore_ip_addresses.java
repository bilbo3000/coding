import java.util.ArrayList;
import java.util.List;

/**
 * Restore IP address from given string. 
 * 1) Total 4 segment. 2) input length must between 4 and 12; 3) each segment must be 0~255; 
 * 3) 0 cannot start a segment exception 0 alone; 4) each segment could be 1, 2, 3 digits. 
 */ 
public class Solution {
    private List<String> result = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return result; 
        }
        
        helper(new ArrayList<String>(), 0, s);
        
        return result; 
    }
    
    private void helper(List<String> list, int index, String s) {
        if (s.length() == index) {
            if (list.size() == 4) {
                // Found one
                StringBuilder sb = new StringBuilder(); 
                sb.append(list.get(0));
                
                for (int i = 1; i < 4; i++) {
                    sb.append(".");
                    sb.append(list.get(i));
                }
                
                result.add(sb.toString());
            }
            
            return; 
            }
        
        if (s.charAt(index) == '0') {
            list.add("0");
            helper(list, index + 1, s);
            list.remove(list.size() - 1);
        } else {
            int j = index + 1; 
            
            while (j <= s.length() && j <= index + 3) {
                String str = s.substring(index, j);
                int val = Integer.parseInt(str);
                
                if (val <= 255) {
                    list.add(str);
                    helper(list, j, s);
                    list.remove(list.size() - 1);
                }
                
                j++; 
            }
        }
    }
}
