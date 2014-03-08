public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>(); 
        ArrayList<Set<String>> levels = new ArrayList<Set<String>>(); 
        levels.add(new HashSet<String>()); 
        levels.add(new HashSet<String>()); 
        int lev1 = 0; 
        int lev2 = 1; 
        levels.get(lev1).add(start); 
        boolean flag = false; 
        dict.add(end); 
        
        while (!flag && levels.get(lev1).size() != 0) { 
            Set<String> curr = levels.get(lev1); 
            Set<String> next = levels.get(lev2); 
            dict.removeAll(curr); 
            Iterator<String> it = curr.iterator(); 
            
            while (it.hasNext()) {
                String word = it.next(); 
                
                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        if (k != word.charAt(j)) {
                            char[] arr = word.toCharArray(); 
                            arr[j] = (char)k; 
                            String temp = new String(arr);
                            
                            if (dict.contains(temp)) {
                                if (temp.equals(end)) {
                                    flag = true; 
                                }
                                
                                if (!m.containsKey(temp)) {
                                    m.put(temp, new ArrayList<String>()); 
                                }
                                
                                m.get(temp).add(word); 
                                next.add(temp); 
                            }
                        }
                    }
                } 
            }
            
            curr.clear(); 
            lev1 = lev1 ^ lev2; 
            lev2 = lev1 ^ lev2; 
            lev1 = lev1 ^ lev2; 
        }
        
        return genPath(end, m, start); 
    }
    
    private ArrayList<ArrayList<String>> genPath(String s, Map<String, ArrayList<String>> m, String start) {    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();   
        if (s.equals(start)) {
            ArrayList<String> temp = new ArrayList<String>(); 
            temp.add(start); 
            result.add(temp);
            result.size(); 
            return result; 
        }
        
        if (!m.containsKey(s)) {
        	return result; 
        }
        
        ArrayList<String> prevs = m.get(s);  // Get ancestors 
        
        for (int i = 0; i < prevs.size(); i++) {
            result.addAll(genPath(prevs.get(i), m, start)); 
        }
        
        for (int i = 0; i < result.size(); i++) {
            result.get(i).add(s); 
        }
        
        return result; 
    }
}
