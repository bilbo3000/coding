public class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int len = words.length; 
        
        if (len > 0) {
            return words[len - 1].length();
        } 
        
        return 0; 
    }
}
