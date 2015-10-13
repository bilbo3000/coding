public class Solution {
    class Trie {
        Trie[] children; 
        int count;
        
        public Trie() {
            children = new Trie[52]; 
        } 
    }
    
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     * 
     * Solve it using trie. 
     * 
     * O(n*m) where m is the avg length of words. 
     */
    public String longestCommonPrefix(String[] strs) {
        int k = strs.length; 
        Trie root = new Trie(); 
        
        for (String s : strs) {
            insert(s, root);
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        Trie curr = root; 
        
        while (curr != null) {
            int i = 0; 
            
            while (i < 52) {
                if (curr.children[i] != null && curr.children[i].count == k) {
                    if (i >= 26) {
                        sb.append((char)('A' + (i - 26)));
                    } else {
                        sb.append((char)('a' + i));
                    }
                    curr = curr.children[i]; 
                    break; 
                }
                
                i++; 
            }
            
            if (i == 52) {
                break; 
            }
        }
        
        return sb.toString();
    }
    
    private void insert(String s, Trie root) {
        char[] arr = s.toCharArray(); 
        int len = arr.length;
        Trie curr = root; 
        
        for (int i = 0; i < len; i++) {
            char c = arr[i]; 
            int index = 0; 
            
            if (c >= 'a' && c <= 'z') {
                index = (int) (arr[i] - 'a'); 
            } else {
                index = (int) (arr[i] - 'A') + 26;
            }
            
            if (curr.children[index] == null) {
                curr.children[index] = new Trie();
            }
            
            curr.children[index].count++; 
            curr = curr.children[index]; 
        }
    }
}
