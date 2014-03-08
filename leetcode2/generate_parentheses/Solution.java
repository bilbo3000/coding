public class Solution {
    ArrayList<String> result = new ArrayList<String>(); 
    
    public ArrayList<String> generateParenthesis(int n) {
        helper("", n, 0, 0, n); 
        
        return result; 
    }
    
    private void helper(String curr, int cnt, int leftCnt, int rightCnt, int n) {
        if (cnt == 0) {
            result.add(curr); 
            return; 
        }
        
        if (leftCnt < n) {
            helper(curr + "(", cnt, leftCnt + 1, rightCnt, n); 
        }
        
        if (leftCnt > rightCnt) {
            helper(curr + ")", cnt - 1, leftCnt, rightCnt + 1, n); 
        }
    }
}
