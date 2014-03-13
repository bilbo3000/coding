public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>(); 
        int len = s.length(); 
        
        for (int i = 0; i < len; i++) {
            list.add(new ArrayList<String>()); 
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                String str = s.substring(j, i + 1);
                
                if (dict.contains(str)) {
                    list.get(i).add(str); 
                }
            }
        }
        
        ArrayList<String> result = new ArrayList<String>(); 
        reconstruct(list, len - 1, "", result); 
        
        return result; 
    }
    
    private void reconstruct(ArrayList<ArrayList<String>> list, int index, String curr, ArrayList<String> result) {
        if (index == -1) {
            result.add(curr); 
            return; 
        }
        
        ArrayList<String> temp = list.get(index); 
        
        for (int i = 0; i < temp.size(); i++) {
            if (curr.length() != 0) {
                reconstruct(list, index - temp.get(i).length(), temp.get(i) + " " + curr, result); 
            }
            else {
                reconstruct(list, index - temp.get(i).length(), temp.get(i), result);
            }
        }
        
        return; 
    }
}