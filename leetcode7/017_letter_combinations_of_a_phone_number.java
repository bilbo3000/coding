/*
Find all letter combinations of a phone number. 

Solve using recursion. 

The time complexity is O(4^n) where n is the number of digits. 
(Makes sense cause each digit will expand into at most 4 recursive calls). 

Space complexity is O(n), the longest call stack path. 
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> m = new HashMap<>(); 
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");
        
        List<String> results = new ArrayList<String>(); 
        
        if (digits == null || digits.length() == 0) {
            return results; 
        }
        
        helper(digits, 0, "", results, m);
        
        return results; 
    }
    
    private void helper(String digits, int index, String curr, List<String> results, Map<Character, String> m) {
        if (index == digits.length()) {
            results.add(curr);
            return; 
        }
        
        char c = digits.charAt(index);
        String letters = m.get(c);
        
        for (int i = 0; i < letters.length(); i++) {
            helper(digits, index + 1, curr + letters.charAt(i), results, m);
        }
    }
}
