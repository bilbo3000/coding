/**
 * Find the shortest length of word ladder that transform the begin word to end word where all 
 * the words in the path must be in the dictionary. 
 * Solve is using BFS that will give the shortest path. 
 */ 
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        int result = 0; 
        List<Set<String>> levels = new ArrayList<Set<String>>(); 
        levels.add(new HashSet<String>());
        levels.add(new HashSet<String>());
        int lev0 = 0; 
        int lev1 = 1; 
        levels.get(lev0).add(beginWord);
        Set<String> history = new HashSet<>(); 
        history.add(beginWord);
        
        while (levels.get(lev0).size() != 0) {
            result++; 
            Set<String> curr = levels.get(lev0);
            Set<String> next = levels.get(lev1);
            
            for (String item : curr) {
                for (int i = 0; i < item.length(); i++) {
                    for (int j = 0; j < 26; j++) {
                        char[] arr = item.toCharArray(); 
                        char c = (char) ('a' + j);
                        
                        if (arr[i] != c) {
                            arr[i] = c; 
                            String str = String.valueOf(arr);
                            
                            if (str.equals(endWord)) {
                                return result + 1; 
                            }
                            
                            if (!history.contains(str) && wordDict.contains(str)) {
                                next.add(str);
                            }
                        }
                    }
                }
            }
            
            history.addAll(next);
            curr.clear(); 
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
        }
        
        return 0; 
    }
}
