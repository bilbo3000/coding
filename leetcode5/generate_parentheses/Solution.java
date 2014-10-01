public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>(); 
        
        if (n == 0) {
            return result; 
        }
        
        helper(result, "", 0, 0, n); 
        
        return result; 
    }
    
    private void helper(List<String> result, String paren, int left, int right, int n) {
        if (right == n) {
            result.add(paren);
            return; 
        }
        
        if (left < n) {
            helper(result, paren + "(", left + 1, right, n); 
        }
        
        if (right < left) {
            helper(result, paren + ")", left, right + 1, n); 
        }
    }
}
