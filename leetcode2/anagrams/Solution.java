public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>(); 
        Set<String> resultKeys = new HashSet<String>(); 
        ArrayList<String> result = new ArrayList<String>(); 
        
        for (int i = 0; i < strs.length; i++) {
            char[] keyarr = strs[i].toCharArray(); 
            Arrays.sort(keyarr); 
            String key = new String(keyarr); 
            
            if (m.containsKey(key)) {
                resultKeys.add(key); 
                m.get(key).add(strs[i]); 
            }
            else {
                ArrayList<String> temp = new ArrayList<String>(); 
                temp.add(strs[i]);
                m.put(key, temp); 
            }
        }
        
        Iterator it = resultKeys.iterator(); 
        
        while (it.hasNext()) {
            String key = (String) it.next(); 
            result.addAll(m.get(key)); 
        }
        
        return result; 
    }
}
