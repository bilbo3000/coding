public class Solution {
    public boolean isNumber(String s) {
        String pattern = "\\s*[+-]?(\\d+\\.?|\\d*\\.\\d+)(e[+-]?\\d+)?\\s*";

        if (s.matches(pattern)) return true;
        return false;
    }
}
