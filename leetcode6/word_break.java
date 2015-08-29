/**
 * Determine if a word can be segmentated into dictionary words. 
 * Solve it using dynamic programming. boolean T[i] means whether s[:i] can be segmentated into 
 * dictionary words. Return T[len - 1] as result. 
 */ 
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length(); 
        boolean[] T = new boolean[len];
        
        for (int i = 0; i < len; i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                T[i] = true; 
                continue; 
            }
            
            int j = i - 1; 
            
            while (j >= 0) {
                if (T[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                    T[i] = true; 
                    break; 
                }
                j--; 
            }
        }
        
        return T[len - 1];
    }
}
