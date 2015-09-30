public class Solution {
    /**
     * @param n a number
     * @return Gray code
     * 
     * O(2^n), geometric series with q = 2
     */
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>(); 
        if (n == 0) {
            result.add(0);
            return result; 
        }
        
        ArrayList<String> list = new ArrayList<>(); 
        list.add("0");
        list.add("1");
        
        while (n > 1) {
            int i = list.size() - 1; 
            
            while (i >= 0) {
                String s = list.get(i);
                list.set(i, "0" + s);
               list.add("1" + s);
               i--;  
            }
            
            n--; 
        }
        
        for (String item : list) {
            result.add(binaryToInteger(item));
        }
        
        return result; 
    }
    
    private int binaryToInteger(String s) {
        int result = 0; 
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result = result * 2 + 1; 
            } else {
                result = result * 2; 
            }
        }
        
        return result; 
    }
}
