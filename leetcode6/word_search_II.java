/**
 * Find a list of words from the board that in a dict. 
 * The idea was to traverse the board via DFS and backtracking guided by a trie. The reason to use 
 * trie is becasue trie can determine whether we need to go down certain point. e.g. if a node does not 
 * in trie, we don need to go down that path. 
 * Note that in trie, values are represened by edges, not nodes. Use the 27th cell to mark the end of a 
 * word. 
 */ 
public class Solution {
    class TrieNode {
        // The 27th cell mark the end of a word
        TrieNode[] child = new TrieNode[27];
    }
    
    private Set<String> result = new HashSet<>(); 
    private int m = 0; 
    private int n = 0; 
    
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length; 
        n = board[0].length; 
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = (int) (board[i][j] - 'a'); 
                
                if (root.child[index] != null) {
                    helper(board, i, j, new ArrayList<Character>(), root.child[index]);
                }
            }
        }
        
        List<String> res = new ArrayList<>(); 
        res.addAll(result);
        return res; 
    }
    
    private void helper(char[][] board, int i, int j, List<Character> list, TrieNode node) {
        char temp = board[i][j]; 
        list.add(temp);
        
        if (node.child[26] != null) {
            // Found a word
            StringBuilder sb = new StringBuilder(); 
            for (char c : list) {
                sb.append(c);
            }
            
            result.add(sb.toString());
        }
        
        board[i][j] = '.'; 
        
        // check up 
        if (i > 0 && board[i - 1][j] != '.') {
            int index = (int) (board[i - 1][j] - 'a');
            
            if (node.child[index] != null) {
                helper(board, i - 1, j, list, node.child[index]);
            }
        }
        
        // check right 
        if (j < n - 1 && board[i][j + 1] != '.') {
            int index = (int) (board[i][j + 1] - 'a');
            
            if (node.child[index] != null) {
                helper(board, i, j + 1, list, node.child[index]); 
            }
        }
        
        // check down
        if (i < m - 1 && board[i + 1][j] != '.') {
            int index = (int) (board[i + 1][j] - 'a');
            
            if (node.child[index] != null) {
                helper(board, i + 1, j, list, node.child[index]); 
            }
        }
        
        // check left 
        if (j > 0 && board[i][j - 1] != '.') {
            int index = (int) (board[i][j - 1] - 'a');
            
            if (node.child[index] != null) {
                helper(board, i, j - 1, list, node.child[index]);
            }
        }
        
        board[i][j] = temp; 
        list.remove(list.size() - 1);
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode(); 

        for (String word : words) {
            TrieNode curr = root; 
            char[] arr = word.toCharArray(); 
            
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i]; 
                int index = (int) (c - 'a');
                
                if (curr.child[index] == null) {
                    curr.child[index] = new TrieNode();
                }
                
                curr = curr.child[index]; 
            }
            
            if (curr.child[26] == null) {
                curr.child[26] = new TrieNode();
            }
        }
        
        return root; 
    }
}
