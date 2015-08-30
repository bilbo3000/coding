/**
 * Find all possible splits of a string into concatenation of dictionary words. 
 * Use dynamic programming to track all previous index where from that index to current index 
 * form a dictionary words. Once that is done, recursively reconstruct the result from the 
 * list obtained from previous step. 
 */ 
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        int len = s.length(); 
        List<List<Integer>> list = new ArrayList<List<Integer>>(); 
        
        for (int i = 0; i < len; i++) {
            List<Integer> temp = new ArrayList<>(); 
            
            if (wordDict.contains(s.substring(0, i + 1))) {
                temp.add(-1);
            }
            
            int j = i - 1; 
            
            while (j >= 0) {
                if (list.get(j).size() != 0 && wordDict.contains(s.substring(j + 1, i + 1))) {
                    temp.add(j);
                }
                
                j--; 
            }
            
            list.add(temp);
        }
        
        // Reconstruct 
        return reconstruct(s, list, len - 1);
    }
    
    private List<String> reconstruct(String s, List<List<Integer>> list, int index) {
        if (index == -1) {
            return new ArrayList<String>(); 
        }
        
        List<String> result = new ArrayList<>(); 
        List<Integer> temp = list.get(index);
        
        for (int item : temp) {
            if (item == -1) {
                result.add(s.substring(0, index + 1));
            } else {
                List<String> tempRes = reconstruct(s, list, item);
                String substr = s.substring(item + 1, index + 1);
                for (int i = 0; i < tempRes.size(); i++) {
                    tempRes.set(i, tempRes.get(i) + " " + substr);
                }
                
                result.addAll(tempRes);
            }
        }
        
        return result; 
    }
}
