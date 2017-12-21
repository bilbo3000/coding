/**
 * Given a string and a list of words as dictionary. Determine if the given 
 * string can be break into words from dictionary. 
 * 
 * Solve it using DP. Let T[i] be true if prefix of given string s with 
 * length i can be break. Therefore the solution will just be T[s.length()]. 
 *
 * T is initialized with length + 1 cause T[0] is true; 
 * When calculate each T[i], go over previous calculated T[j] and if true, 
 * and meanwhile s.substring(j, i) is in dict, --> T[i] must be true. 
 * 
 * Time: O(n^2), nested loops; 
 * Space: O(n), T; 
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int len = s.length();
        
        // Add all the dictionary in a set
        Set<String> dict = new HashSet<>(); 
        
        for (String item : wordDict) {
            dict.add(item);
        }

        // DP
        // T[i] represents whether prefix of s of length i can be break
        boolean[] T = new boolean[len + 1];
        T[0] = true; 
        
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (T[j] && dict.contains(s.substring(j, i))) {
                    T[i] = true; 
                    break; 
                }
            }
        }
        
        return T[len];
    }
}
