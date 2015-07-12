/**
 * Find the number of unique structures of BST for the given number of nodes. 
 * The dynamic programming approach. Recursive approach is intuitive, but 
 * it times out. The idea of dynamic programming approach is to use an array 
 * to store the number of unique BST for i nodes. 
 * t[i] stores the number of unique BST for nodes with number 1..i. 
 * To construct t[i], it loops through from 1 to i and try to let each node 
 * to be root, and get the count of left and right subtree from the table. 
 * Mutiply the counts if possible (both left and right must not be empty) for 
 * the current root, then accumulate the count for all roots, store it in t[i]. 
 */
public class Solution {
    public int numTrees(int n) {
        int[] t = new int[n + 1]; 
        t[0] = 0; 
        
        if (n > 0) {
            t[1] = 1; 
        }
        
        for (int i = 2; i <= n; i++) {
            int result = 0; 
            
            for (int j = 1; j <= i; j++) {
                int left = j - 1; 
                int right = i - j; 
                
                if (left == 0) {
                    result += t[right]; 
                } else if (right == 0) {
                    result += t[left]; 
                } else {
                    result += t[left] * t[right]; 
                }
            }
            
            t[i] = result; 
        }
        
        return t [n]; 
    }
}
