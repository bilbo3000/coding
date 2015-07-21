/**
 * Find the gray code with the given length. 
 * The idea was, when generating gray code for next bit, reverse 
 * all current code and append to the current code. Then append '0'
 * in front of the first half and append '1' in front of the second
 * half. 
 * Note that when input is zero, the gray code would be "0". 
 */ 
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(); 
        List<String> code = new ArrayList<>(); 
        
        if (n == 0) {
            result.add(0); 
            return result; 
        }
        
        code.add("0"); 
        code.add("1"); 
        
        for (int i = 1; i < n; i++) {
            int len = code.size(); 
            List<String> temp = new ArrayList<>(code); 
            Collections.reverse(temp);
            
            for (int j = 0; j < len; j++) {
            	temp.set(j, "1" + temp.get(j)); 
            	code.set(j, "0" + code.get(j));
            }

            code.addAll(temp); 
        }
        
        for (String s : code) {
            result.add(convert(s)); 
        }
        
        return result; 
    }
    
    private int convert(String s) {
        int result = 0; 
        char[] arr = s.toCharArray(); 
        int len = arr.length; 
        
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                result += Math.pow(2, len - 1 - i); 
            }
        }
        
        return result; 
    }
}
