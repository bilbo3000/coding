public class Solution {
    class Trie {
        int cnt; 
        Trie[] children = new Trie[26]; 
    }
    
    public String longestCommonPrefix(String[] strs) {
        String result = ""; 
        int len = strs.length; 
        Trie root = new Trie(); 
        
        for (int i = 0; i < len; i++) {
            Trie curr = root; 
            
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j); 
                int index = c - 'a'; 
                
                if (curr.children[index] == null) {
                    curr.children[index] = new Trie(); 
                }
                
                curr = curr.children[index]; 
                curr.cnt++; 
            }
        }
        
        boolean stop = false; 
        Trie curr = root; 
        
        while (!stop) {
            int i = 0; 
            
            while (i < 26) {
                Trie child = curr.children[i]; 
                
                if (child != null && child.cnt == len) {
                    result += (char)('a' + i); 
                    curr = child; 
                    break; 
                }
                
                i++; 
            }
            
            if (i == 26) {
                stop = true; 
            }
        }
        
        return result; 
    }
}
