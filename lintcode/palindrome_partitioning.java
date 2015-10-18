public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        boolean[][] T = isPalin(s); 
        List<List<String>> result = new ArrayList<List<String>>(); 
        helper(s, 0, new ArrayList<String>(), result, T);
        
        return result;
    }
    
    private void helper(String s, int index, List<String> sol, List<List<String>> result, boolean[][] T) {
        int len = s.length(); 
        
        if (index == len) {
            result.add(new ArrayList<String>(sol));
            return; 
        }
        
        for (int i = index; i < len; i++) {
            if (T[index][i]) {
                sol.add(s.substring(index, i + 1));
                helper(s, i + 1, sol, result, T);
                sol.remove(sol.size() - 1);
            }
        }
    }
    
    private boolean[][] isPalin(String s) {
        int len = s.length(); 
        char[] arr = s.toCharArray(); 
        boolean[][] m = new boolean[len][len]; 
        
        for (int i = 0; i < len; i++) {
            m[i][i] = true; 
        }
        
        for (int i = 0; i < len - 1; i ++) {
            if (arr[i] == arr[i + 1]) {
                m[i][i + 1] = true; 
            }
        }
        
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (arr[i] == arr[j] && m[i + 1][j - 1]) {
                    m[i][j] = true; 
                }
            }
        }
        
        return m; 
    }
}
