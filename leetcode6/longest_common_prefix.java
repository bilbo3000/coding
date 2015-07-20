/**
 * Find the longest common prefix for the given list of strings.
 * The idea was to use Trie as the underlying data structure. Walk 
 * through the list and insert each string into the trie. Also, each 
 * trie node has a count of the number of times it got hit. Then, 
 * walk though the trie always follow the branch that is hit by 
 * all strings in the list, until it cannot find such branch in 
 * the trie. Return the prefix up to that point as the result. 
 */ 
public class Solution {
    public class TrieNode {
        int count = 0; 
        TrieNode[] children = new TrieNode[26]; 
    }
    
    private TrieNode root = new TrieNode(); 
    
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length; 
        
        for (String item : strs) {
            insert(item); 
        }
        
        StringBuilder sb = new StringBuilder(); 
        TrieNode curr = root; 
        
        while (true) {
            int i = 0;
            
            while (i < 26) {
                if (curr.children[i] != null && curr.children[i].count == len) {
                    sb.append((char)('a' + i)); 
                    curr = curr.children[i]; 
                    break; 
                }
                
                i++; 
            }
            
            if (i == 26) {
                break; 
            }
        }
        
        return sb.toString(); 
    }
    
    private void insert(String word) {
        if (word.length() == 0) {
            return; 
        }
        
        char[] arr = word.toCharArray(); 
        TrieNode curr = root; 
        
        for (int i = 0; i < arr.length; i++) {
            int index = (int) (arr[i] - 'a'); 
            
            if (curr.children[index] == null){
                curr.children[index] = new TrieNode(); 
            }
            
            curr = curr.children[index]; 
            curr.count++; 
        }
    }
}
