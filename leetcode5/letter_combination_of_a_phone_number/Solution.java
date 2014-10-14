public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> m = new HashMap<Character, List<Character>>(); 
        m.put('2', new ArrayList<Character>(Arrays.asList('a', 'b', 'c'))); 
        m.put('3', new ArrayList<Character>(Arrays.asList('d', 'e', 'f'))); 
        m.put('4', new ArrayList<Character>(Arrays.asList('g', 'h', 'i'))); 
        m.put('5', new ArrayList<Character>(Arrays.asList('j', 'k', 'l'))); 
        m.put('6', new ArrayList<Character>(Arrays.asList('m', 'n', 'o'))); 
        m.put('7', new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
        m.put('8', new ArrayList<Character>(Arrays.asList('t', 'u', 'v'))); 
        m.put('9', new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z'))); 
        
        List<String> result = new ArrayList<String>(); 
        
        helper(digits, 0, "", m, result); 
        
        return result; 
    }
    
    private void helper(String digits, int index, String curr, Map<Character, List<Character>> m, List<String> result) {
        if (index == digits.length()) {
            result.add(curr);
            
            return; 
        }
        
        List<Character> letters = m.get(digits.charAt(index));
        
        for (Character c : letters) {
            helper(digits, index + 1, curr + c, m, result); 
        }
    }
}
