public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character> > m = new HashMap<Character, List<Character> >(); 
        m.put('2', new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
        m.put('3', new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
        m.put('4', new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
        m.put('5', new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
        m.put('6', new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
        m.put('7', new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
        m.put('8', new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
        m.put('9', new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z')));
        
        return helper(digits, m); 
    }
    
    private List<String> helper(String digits, Map<Character, List<Character> > m) {
        int len = digits.length(); 
        
        if (len == 0) {
            return new ArrayList<String>(Arrays.asList("")); 
        }
        
        List<String> temp = helper(digits.substring(1), m);
        List<String> result = new ArrayList<String>(); 
        
        for (String s : temp) {
            for (Character c : m.get(digits.charAt(0))) {
                result.add(c + s);  
            }
        }
        
        return result; 
    }
}
