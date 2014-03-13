import java.util.*;
import java.util.Map.Entry;

public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>(); 
        Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>(); 
        ArrayList<HashSet<String>> levels = new ArrayList<HashSet<String>>(); 
        levels.add(new HashSet<String>());
        levels.add(new HashSet<String>());
        int lev1 = 0; 
        int lev2 = 1; 
        levels.get(lev1).add(start); 
        int len = start.length(); 
        dict.remove(start); 
        dict.remove(end); 
        
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
                            String temp = new String(arr);
                            
                            if (dict.contains(temp) || temp.equals(end)) {
                                next.add(temp);
                                
                                if (!m.containsKey(item)) {
                                    m.put(item, new ArrayList<String>()); 
                                }
                                
                                m.get(item).add(temp); 
                            }
                        }
                    }
                }
            }
            
            dict.removeAll(next);
            curr.clear(); 
            lev1 = lev1 ^ lev2; 
            lev2 = lev1 ^ lev2; 
            lev1 = lev1 ^ lev2; 
            
            if (next.contains(end)) {
                break; 
            }
        }
        
        // Reconstruct
        reconstruct(m, start, end, new ArrayList<String>(), result); 
        
        return result; 
    }
    
    private void reconstruct(Map<String, ArrayList<String>> m, String word, String end, ArrayList<String> curr, ArrayList<ArrayList<String>> result) {
        curr.add(word); 
        
        if (word.equals(end)) {
            result.add(curr);
            return; 
        }
        
        if (!m.containsKey(word)) {
        	return; 
        }
        
        ArrayList<String> children = m.get(word); 
        
        for (String child : children) {
            ArrayList<String> temp = (ArrayList<String>) curr.clone(); 
            reconstruct(m, child, end, temp, result); 
        }
    }
}
