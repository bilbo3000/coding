/**
 * Solve using DFS. 
 * The key is to use a map to store intermediate results to shortcut.
 * Key of the map is a string s (suffix to be exact), and value is a 
 * list of sentences s can form. 
 * Upon sub dfs calls return, it simply prepend current dict word to 
 * each of the returned sentences. 
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
        
        return dfs(s, new HashMap<String, List<String>>(), dict);
    }
    
    private List<String> dfs(String s, Map<String, List<String>> m, Set<String> dict) {
        List<String> res = new ArrayList<>();
        
        if (s == null || s.length() == 0) {
            res.add("");
            return res; 
        }
        
        if (m.containsKey(s)) {
            return m.get(s);
        }
        
        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> sub = dfs(s.substring(word.length()), m, dict);
                for (String item : sub) {
                    if (item.length() > 0) {
                        res.add(word + " " + item);
                    } else {
                        res.add(word);
                    }
                }
            }
        }
        
        m.put(s, res);
        return res;
    }
}
