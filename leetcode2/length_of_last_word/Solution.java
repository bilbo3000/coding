public class Solution {
    public int lengthOfLastWord(String s) {
        String[] temp = s.split(" "); 
        int len = temp.length; 
        
        if (len == 0) return 0; 
        
        return temp[len - 1].length(); 
    }
}
