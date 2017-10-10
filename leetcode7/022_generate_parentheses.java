/*
Generate valid parentheses pairs with total n pairs of parentheses. 

Solve using recursion. 
Each iteration: 
1) if there are still left paren need to be placed, place a (; 
2) if there are still unmatched left paren need to be matched, match a ); 
If all placed and all matched, put into the result, which has been passed along.

Time: ???
Space: O(n): the deepest call stack, which is n left paren and n right paren; 
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(); 
        if (n <= 0) {
            return result; 
        }
        helper(n, 0, "", result);
        return result; 
    }
    
    private void helper(int remainingLeftParen, int unmatchedLeftParen, String curr, List<String> result) {
        if (remainingLeftParen == 0 && unmatchedLeftParen == 0) {
            result.add(curr);
            return; 
        }
        
        if (remainingLeftParen > 0) {
            helper(remainingLeftParen - 1, unmatchedLeftParen + 1, curr + "(", result);
        }
        
        if (unmatchedLeftParen > 0) {
            helper(remainingLeftParen, unmatchedLeftParen - 1, curr + ")", result);
        }
    }
}
