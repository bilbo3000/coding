/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    protected TrieNode[] children; 
    protected boolean isEnd = false; 
    
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26]; 
    }
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] arr = word.toCharArray(); 
        TrieNode curr = root; 
        
        for (int i = 0; i < arr.length; i++) {
            int index = (int) (arr[i] - 'a');
            
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode(); 
            }
            
            curr = curr.children[index]; 
        }
        
        curr.isEnd = true; 
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] arr = word.toCharArray(); 
        TrieNode curr = root; 
        
        for (int i = 0; i < arr.length; i++) {
            int index = (int) (arr[i] - 'a');
            
            if (curr.children[index] == null) {
                return false; 
            }
            
            curr = curr.children[index]; 
        }
        
        return curr.isEnd; 
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray(); 
        TrieNode curr = root; 
        
        for (int i = 0; i < arr.length; i++) {
            int index = (int) (arr[i] - 'a');
            
            if (curr.children[index] == null) {
                return false; 
            }
            
            curr = curr.children[index]; 
        }
        
        return true; 
    }
}
