/**
 * Count the number of binary tree with unique structure for the given number of nodes. 
 * This is the recursive approach. For the given number of nodes, it loop through each 
 * node and try to make each node to be root. Then recursive process left and right 
 * subtree (if possible), then multiply the results returned from left and right subtree
 * and add to total result. 
 * However, this approach exceeds the time limit. 
 */
public class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n; 
        }
        
        int result = 0; 
        
        for (int i = 0; i < n; i++) {
            int left = i; 
            int right = n - i - 1; 
            
            if (left == 0) {
                result += numTrees(right); 
            } else if (right == 0) {
                result += numTrees(left); 
            } else {
                result += numTrees(left) * numTrees(right);  
            }
        }
        
        return result; 
    }
}
