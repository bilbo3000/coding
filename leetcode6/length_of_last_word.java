/**
 * Find the length of the last word in a string. 
 * The idea was to first trim the string and split the string at spaces "\\s+". 
 * Then return the length of the last word in the resulting array. 
 */ 
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0; 
        }
        
        s = s.trim();
        
        String[] result = s.split("\\s+"); 
        
        return result[result.length - 1].length();
    }
}
