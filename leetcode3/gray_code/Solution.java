public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<String> temp = helper(n); 
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        
        for (String s : temp) {
            result.add(binaryToInt(s)); 
        }
        
        return result; 
    }

    private ArrayList<String> helper(int n) {
        ArrayList<String> result = new ArrayList<String>(); 
        
        if (n == 0) {
            result.add("0"); 
            return result; 
        }
        
        if (n == 1) {
            result.add("0"); 
            result.add("1"); 
            return result; 
        }
        
        result = helper(n - 1); 
        int size = result.size(); 
        
        for (int i = size - 1; i >= 0; i--) {
            result.add("1" + result.get(i));
            result.set(i, "0" + result.get(i)); 
        }
        
        return result; 
    }
    
    private int binaryToInt(String s) {
        int result = 0; 
        
        for (int i = 0; i < s.length(); i++) {
            result *= 2; 
            
            if (s.charAt(i) == '1') {
                result += 1; 
            }
        }
        
        return result; 
    }
}
