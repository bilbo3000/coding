/**
 * Given a list of words and a string. Split the string using the words 
 * from the dictionary. Return all the possible sentences.
 *
 * DP + Backtrack to reconstruct. 
 * The idea was to use DP to memorize all possible split locations that 
 * could lead to current position. Then use recursion to backtrack and 
 * reconstruct the sentences. 
 * 
 * T is a list of lists. T has length n + 1; T[i] contains a list of 
 * prefixes lengths that could lead to a prefix with length i. 
 * Each iteration of i, 0 <= j < i. j is put into T[i] if T[j] is not 
 * empty (meaning prefix of length j can be split) and s.substring(j, i)
 * is in dict. 
 * 
 * Once we have T, it's time to reconstruct recursively. One caveat to 
 * be careful about during reconstruct is to insert a word at the beginning
 * of the current path as we are walking backwards during backtracking. 
 * 
 * Time: O()?
 * Space: O()? 
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res; 
        }
        
        // Convert a list of words in dictionary into a set
        Set<String> dict = new HashSet<>();
        for (String item : wordDict) {
            dict.add(item);
        }
        
        // T[i] is a list, which contains all the length of its prefixes that could 
        // constitute a splits of a prefix of length i. 
        List<List<Integer>> T = new ArrayList<>(); 
        int len = s.length();
        
        // Initialize T with len + 1 empty lists 
        for (int i = 0; i <= len; i++) {
            T.add(new ArrayList<Integer>());
        }
        
        T.get(0).add(0);
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (T.get(j).size() > 0 && dict.contains(s.substring(j, i))) {
                    T.get(i).add(j);
                }
            }
        }
        
        // Reconstruct
        reconstruct(s, len, new ArrayList<String>(), T, res);
        
        return res; 
    }
    
    private void reconstruct(String s, int index, List<String> path, List<List<Integer>> T, List<String> results) {
        if (index == 0) {
            results.add(String.join(" ", path));
            return; 
        }
        
        List<Integer> items = T.get(index); 
        
        for (Integer j : items) {
            path.add(0, s.substring(j, index));
            reconstruct(s, j, path, T, results);
            path.remove(0);
        }
    }
}
