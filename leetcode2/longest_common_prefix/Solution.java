public class Solution {
    class Trie {
        int cnt; 
        Trie[] children;
        
        Trie() {
            cnt = 0; 
            children = new Trie[26]; 
        }
    }
    
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length; 
        
        if (size == 0) return ""; 
        
        // Build trie
        Trie root = new Trie(); 
        
        for (int i = 0; i < size; i++) {
            Trie curr = root; 
            curr.cnt++; 
            String s = strs[i]; 
            
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j); 
                int index = (int)(c - 'a'); 
                
                if (curr.children[index] == null) {
                    curr.children[index] = new Trie(); 
                }
                
                curr = curr.children[index]; 
                curr.cnt++; 
            }
        }
        
        String result = ""; 
        Trie curr = root; 
        
        while (curr != null) {
            int i = 0; 
            while (i < 26) { 
                if (curr.children[i] != null && curr.children[i].cnt == size) {
                    result += (char)('a' + i); 
                    curr = curr.children[i]; 
                    break; 
                }
                
                i++;
            }
            
            if (i == 26) {
                break; 
            }
        }
        
        return result; 
    }
}
