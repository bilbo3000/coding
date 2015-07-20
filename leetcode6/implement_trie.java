/**
 * Implement Trie. 
 * The tricky part is that in Trie, values are stored in edges, not in nodes. 
 * Use the 27th slot in children to mark the end of word if there is any. 
 */
class TrieNode {
    // Initialize your data structure here.
    public TrieNode() {
    }
    
    TrieNode[] children = new TrieNode[27];
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int len = word.length(); 
        
        if (len == 0) {
            return; 
        }
        
        char[] arr = word.toCharArray(); 
        TrieNode curr = root; 
        
        for (int i = 0; i < len; i++) {
            int index = (int) (arr[i] - 'a'); 
            
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            
            curr = curr.children[index]; 
        }
        
        // Mark the end of word
        curr.children[26] = new TrieNode(); 
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int len = word.length(); 
        
        if (len == 0) {
            return false; 
        }
        
        char[] arr = word.toCharArray(); 
        
        return searchHelper(root, arr, 0); 
    }
    
    private boolean searchHelper(TrieNode curr, char[] arr, int i) {
        if (curr == null) {
            return false; 
        }
        
        if (i == arr.length) {
            if (curr.children[26] == null) {
                return false; 
            } else {
                return true; 
            }
        }
        
        int index = (int) (arr[i] - 'a');
        
        if (curr.children[index] == null) {
            return false; 
        } else {
            return searchHelper(curr.children[index], arr, i + 1); 
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int len = prefix.length(); 
        
        if (len == 0) {
            return false; 
        }
        
        char[] arr = prefix.toCharArray(); 
        
        return startsWithHelper(root, arr, 0); 
    }
    
    private boolean startsWithHelper(TrieNode curr, char[] arr, int i) {
        if (curr == null) {
            return false; 
        }
        
        if (arr.length == i) {
            return true; 
        }
        
        int index = (int) (arr[i] - 'a'); 
        
        if (curr.children[index] == null) {
            return false; 
        } else {
            return startsWithHelper(curr.children[index], arr, i + 1); 
        }
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
