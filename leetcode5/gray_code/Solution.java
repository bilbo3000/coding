public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>(); 
        List<String> temp = new ArrayList<String>(); 
        
        if (n == 0) {
            result.add(0); 
            return result; 
        }
        
        temp.add(""); 
        
        for (int i = 0; i < n; i++) {
            int size = temp.size(); 
            
            for (int j = size - 1; j >= 0; j--) {
                temp.add(temp.get(j)); 
            }
            
            for (int j = 0; j < temp.size(); j++) {
                if (j < temp.size() / 2) {
                    temp.set(j, "0" + temp.get(j)); 
                } else {
                    temp.set(j, "1" + temp.get(j)); 
                }
            }
        }
        
        for (int i = 0; i < temp.size(); i++) {
            result.add(binaryToInt(temp.get(i))); 
        }
        
        return result; 
    }
    
    private int binaryToInt(String s) {
        int result = 0; 
        int len = s.length(); 
        
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                result += Math.pow(2, len - 1 - i); 
            }
        }
        
        return result; 
    }
}
