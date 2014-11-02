public class Solution {
    public String reverseWords(String s) {
        s = s.trim(); 
        
        if (s.length() == 0) {
            return ""; 
        }
        
        String[] arr = s.split("\\s+"); 
        int len = arr.length; 
        
        if (len == 0) {
            return ""; 
        }
        
        StringBuilder builder = new StringBuilder(arr[len - 1]);
        
        for (int i = len - 2; i >= 0; i--) {
            builder.append(" " + arr[i]); 
        }
        
        return builder.toString(); 
    }
}
