/**
 * Given a string and a dictionary. Break the string using the words from 
 * the dictionary. Return all possible sentences. 
 *
 * This is a recursion algorithm. It carries the current splits and solution list
 * along the way. Once no remaining characters to split, it joins the current
 * splits and put into the solution list. 
 * 
 * This solution times out. 
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
        
        helper(s, 0, new ArrayList<String>(), res, dict);
        
        return res; 
    }
    
    private void helper(String s, int index, List<String> path, List<String> res, Set<String> dict) {
        if (index == s.length()) {
            // path would contain the solution, join each word in path with spaces
            res.add(String.join(" ", path));
            return; 
        }
        
        for (int i = index; i < s.length(); i++) {
            if (dict.contains(s.substring(index, i + 1))) {
                path.add(s.substring(index, i + 1));
                // Recursive call 
                helper(s, i + 1, path, res, dict);
                path.remove(path.size() - 1);
            }
        }
    }
}
