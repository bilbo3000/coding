public class Solution {
    public boolean isNumber(String s) {
        String regex = "\\s*[+-]?(\\d+\\.?|\\d*\\.\\d+)(e[+-]?\\d+)?\\s*";
        
        if (s.matches(regex)) return true; 
        else return false; 
    }
}
