/**
 * Find all passes from start to end where words in the pass must in the dictionary. 
 * Solve is using BFS that gives the shortest path. 
 */ 
public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>(); 
        Map<String, Set<String>> m = new HashMap<String, Set<String>>(); 
        List<Set<String>> levels = new ArrayList<Set<String>>(); 
        levels.add(new HashSet<String>());
        levels.add(new HashSet<String>());
        int lev0 = 0; 
        int lev1 = 1; 
        levels.get(lev0).add(start);
        Set<String> history = new HashSet<>(); 
        history.add(start);
        m.put(start, new HashSet<String>());
        boolean stop = false; 
        
        while (!stop && levels.get(lev0).size() != 0) {
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
                            
                            if (str.equals(end)) {
                                stop = true; 
                                
                                if (!m.containsKey(str)) {
                                    m.put(str, new HashSet<String>());
                                }
                                
                                m.get(str).add(item);
                            }
                            else if (!history.contains(str) && dict.contains(str)) {
                                next.add(str);
                                
                                if (!m.containsKey(str)) {
                                    m.put(str, new HashSet<String>());
                                }
                                
                                m.get(str).add(item);
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
        
        if (!stop) {
            return result; 
        }
        
        // Reconstruct 
        reconstruct(end, new ArrayList<String>(), result, m);
        return result;
    }
    
    private void reconstruct(String word, List<String> list, List<List<String>> result, Map<String, Set<String>> m) {
        if (m.get(word).size() == 0) {
            list.add(0, word);
            result.add(new ArrayList<String>(list));
            list.remove(0);
            return; 
        } else {
            list.add(0, word);
            
            for (String item : m.get(word)) {
                reconstruct(item, list, result, m);
            }
            
            list.remove(0);
        }
    }
}
