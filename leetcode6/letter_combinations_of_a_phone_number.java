/**
 * Find letter combinations for given sequence of phone number. 
 * Build a map that maps each digit to its letters. Then solve it recursively. 
 */ 
public class Solution {
    private Map<Character, String> m = new HashMap<Character, String>();
    
    public List<String> letterCombinations(String digits) {
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs"); 
        m.put('8', "tuv");
        m.put('9', "wxyz"); 
        
        return helper(digits, 0); 
    }
    
    private List<String> helper(String digits, int index) {
        int len = digits.length(); 
        List<String> result = new ArrayList<>(); 
        
        if (index == len) {
            return result; 
        }
        
        String str = m.get(digits.charAt(index));
        char[] arr = str.toCharArray(); 
        
        for (char c : arr) {
            if (index == len - 1) {
                result.add(String.valueOf(c)); 
            } else {
                List<String> temp = helper(digits, index + 1);
                
                for (String s : temp) {
                    result.add(c + s);
                }
            }
        }
        
        return result; 
    }
}
