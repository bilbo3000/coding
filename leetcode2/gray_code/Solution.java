public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        ArrayList<String> temp = helper(n); 
        
        for (int i = 0; i < temp.size(); i++) {
            result.add(binaryToInt(temp.get(i))); 
        }
        
        return result; 
    }
    
    private ArrayList<String> helper(int n) {
        ArrayList<String> result; 
        
        if (n == 0) {
            result = new ArrayList<String>(); 
            result.add("0"); 
        }
        else if (n == 1) {
            result = new ArrayList<String>(); 
            result.add("0"); 
            result.add("1"); 
        }
        else {
            result = helper(n - 1);
            
            for (int i = result.size() - 1; i >= 0; i--) {
                String temp = result.get(i); 
                result.add("1" + temp); 
                result.set(i, "0" + temp); 
            }
        }
        
        return result; 
    }
    
    private int binaryToInt(String s) {
        int result = 0; 
        int len = s.length(); 
        
        for (int i = 0; i < len; i++) {
            result *= 2; 
            if (s.charAt(i) == '1') {
                result += 1; 
            }
        }
        
        return result; 
    }
}
