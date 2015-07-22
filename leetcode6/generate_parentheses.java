/**
 * Generate parenthese with n pairs. 
 * Use recursive approach. At each level, first try to push a 
 * "left parenthese"(", then make next recursive call. After it returns, 
 * pop the "(" and try to put a ")" and make next recursive call. Pop ")" 
 * after it returns. Store the result whenever there are n pairs parenthese 
 * in the current list. 
 */ 
public class Solution {
    List<String> result = new ArrayList<>(); 
    List<Character> list = new ArrayList<>(); 
    int n = 0; 
        
    public List<String> generateParenthesis(int n) {
        this.n = n;
        helper(0, 0); 
        
        return result; 
    }
    
    private void helper(int lcnt, int rcnt) {
        if (rcnt == n) {
            StringBuilder sb = new StringBuilder(); 
            
            for (Character c : list) {
                sb.append(c);
            }
            
            result.add(sb.toString());
            
            return; 
        }
        
        if (lcnt < n) {
            list.add('('); 
            helper(lcnt + 1, rcnt); 
            list.remove(list.size() - 1); 
        } 
        
        if (lcnt != 0 && lcnt > rcnt) {
            list.add(')'); 
            helper(lcnt, rcnt + 1); 
            list.remove(list.size() - 1); 
        }
    }
}
