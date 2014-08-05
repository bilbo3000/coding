public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>(); 
        
        if (n == 0) {
            result.add(0); 
            return result; 
        }
        
        ArrayList<String> binary = new ArrayList<String>();
        binary.add("0");
        binary.add("1"); 
        
        for (int i = 1; i < n; i++) {
            int len = binary.size(); 
            for (int j = len - 1; j >= 0; j--) {
                String binaryStr = binary.get(j); 
                binary.set(j, "0" + binaryStr); 
                binary.add("1" + binaryStr); 
            }
        }
        
        for (int i = 0; i < binary.size(); i++) {
            result.add(binaryToInt(binary.get(i))); 
        }
        
        return result; 
    }
    
    private int binaryToInt(String s) {
        int val = 0; 
        for (int i = 0; i < s.length(); i++) {
            val *= 2; 
            if (s.charAt(i) == '1') {
                val += 1; 
            }
        }
        
        return val; 
    }
}
