class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     * O(n).
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        Map<Integer, ArrayList<String>> m = new HashMap<Integer, ArrayList<String>>(); 
        int max = 0; 
        
        for (String item : dictionary) {
            int len = item.length(); 
            
            if (len > max) {
                max = len; 
            }
            
            if (!m.containsKey(len)) {
                m.put(len, new ArrayList<String>()); 
            }
            
            m.get(len).add(item);
        }
        
        return m.get(max);
    }
};
