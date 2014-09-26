public class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split("\\s+"); 
        int len = arr.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        return arr[len - 1].length(); 
    }
}
