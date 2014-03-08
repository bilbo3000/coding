public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0; 
        int cnt = 0; 
        Map<Character, Integer> hasFound = new HashMap<Character, Integer>(); 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            
            if (!hasFound.containsKey(c)) {
                hasFound.put(c, 1);
                cnt++; 
                max = Math.max(max, cnt); 
            }
            else {
                if (hasFound.get(c) == 0) {
                    hasFound.put(c, 1); 
                    cnt++; 
                    max = Math.max(max, cnt); 
                }
                else{
                    hasFound.put(c, hasFound.get(c) + 1); 
                    cnt++; 
                    int j = i - cnt + 1; 
                    
                    while (hasFound.get(c) > 1) {
                        char temp = s.charAt(j); 
                        hasFound.put(temp, hasFound.get(temp) - 1);
                        cnt--; 
                        j++; 
                    }
                    
                    max = Math.max(max, cnt); 
                }
            }
        }
        
        return max; 
    }
}
