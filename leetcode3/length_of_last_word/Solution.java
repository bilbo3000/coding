public class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split("\\s"); 
        int result = 0; 
        int len = words.length; 
        
        return len == 0 ? 0 : words[len - 1].length();  
    }
}