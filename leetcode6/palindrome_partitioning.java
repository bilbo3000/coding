/**
 * Given a string, partition it into palindrome substrings. Find all possible ways. 
 * First, use dynamic programming to build a matrix to keep track of whether substring 
 * from i to j is a palindrome. Then according to that information, build a recursive 
 * function. Each level, try all palindrome prefix and recursively process the remaining 
 * part. Insert the palindrome prefix at the beginning of each returned list, and then 
 * return. Use a hashset to get rid of duplicates. 
 */ 
public class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length(); 
        List<List<String>> result = new ArrayList<List<String>>();
        
        
        if (len == 0) {
            return result; 
        }
        
        char[] arr = s.toCharArray();
        boolean[][] T = new boolean[len][len]; 
        
        for (int i = 0; i < len; i++) {
            T[i][i] = true; 
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                T[i][i + 1] = true; 
            }
        }
        
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                T[i][j] = T[i + 1][j - 1] && (arr[i] == arr[j]);
            }
        }
        
        Set<List<String>> tempSet = helper(s, 0, T); 

        for (List<String> item : tempSet) {
            result.add(item);
        }
        
        return result; 
    }
    
    private Set<List<String>> helper(String s, int index, boolean[][] T) {
        int len = s.length(); 
        Set<List<String>> result = new HashSet<List<String>>();
        
        if (index >= len) {
            result.add(new ArrayList<String>());
            return result; 
        }
        
        if (index == len - 1) {
            List<String> temp = new ArrayList<>(); 
            temp.add(s.substring(index)); 
            result.add(temp);
            return result; 
        }
        
        for (int i = index; i < len; i++) {
            if (T[index][i]) {
                Set<List<String>> tempSet = helper(s, i + 1, T); 
                
                for (List<String> item : tempSet) {
                    item.add(0, s.substring(index, i + 1));
                    result.add(item);
                }
            }
        }
        
        return result; 
    }
}
