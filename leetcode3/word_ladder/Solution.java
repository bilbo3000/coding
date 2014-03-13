import java.util.*; 

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int cnt = 0; 
        int len = start.length(); 
        ArrayList<Set<String>> levels = new ArrayList<Set<String>>();
        levels.add(new HashSet<String>()); 
        levels.add(new HashSet<String>()); 
        int lev1 = 0; 
        int lev2 = 1; 
        levels.get(lev1).add(start); 
        
        while (levels.get(lev1).size() != 0) {
            Set<String> curr = levels.get(lev1); 
            Set<String> next = levels.get(lev2); 
            
            for (String item : curr) {
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < 26; j++) {
                        char[] arr = item.toCharArray(); 
                        char c = (char)('a' + j); 
                        if (c != arr[i]) {
                            arr[i] = c; 
                            String s = new String(arr); 
                            
                            if (s.equals(end)) {
                            	return cnt + 2; 
                            }
                            
                            if (dict.contains(s)) {
                                next.add(s); 
                            }
                        }
                    }
                }
            }
            
            cnt++; 
            curr.clear(); 
            for (String item : next) {
            	dict.remove(item); 
            }
            
            lev1 = lev1 ^ lev2; 
            lev2 = lev1 ^ lev2; 
            lev1 = lev1 ^ lev2; 
        }
        
        return 0; 
    }
}
