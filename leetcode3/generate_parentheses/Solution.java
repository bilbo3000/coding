public class Solution {
    private ArrayList<String> result = new ArrayList<String>(); 
    
    public ArrayList<String> generateParenthesis(int n) {
        helper("", 0, 0, n); 
        
        return result; 
    }
    
    private void helper(String paren, int left, int right, int n) {
        if (right == n) {
            result.add(paren); 
            return; 
        }
        
        if (left < n) {
            String temp = new String(paren); 
            helper(temp + "(", left + 1, right, n); 
        }
        
        if (right < left) {
            String temp = new String(paren); 
            helper(temp + ")", left, right + 1, n); 
        }
    }
}