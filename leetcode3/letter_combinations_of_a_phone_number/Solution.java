public class Solution {
    private Map<Character, String> m = new HashMap<Character, String>(); 
    
    public ArrayList<String> letterCombinations(String digits) {
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
    
    private ArrayList<String> helper(String digits, int index) {
        ArrayList<String> result = new ArrayList<String>(); 
        
        if (index == digits.length()) {
            result.add("");
            return result; 
        }
        
        ArrayList<String> temp = helper(digits, index + 1); 
        String val = m.get(digits.charAt(index));
        
        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            
            for (String item : temp) {
                result.add(c + item); 
            }
        }
        
        return result; 
    }
}
