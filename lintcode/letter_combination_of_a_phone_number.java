public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>(); 
        }
        
        Map<Character, String> m = new HashMap<Character, String>(); 
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");
        
        ArrayList<String> result = new ArrayList<>(); 
        helper(m, digits, 0, "", result);
        
        return result; 
    }
    
    private void helper(Map<Character, String> m, String digits, int index, String res, ArrayList<String> list) {
        if (index == digits.length()) {
            list.add(res);
            return; 
        }
        
        char c = digits.charAt(index); 
        char[] arr = m.get(c).toCharArray();
        
        for (char item : arr) {
            helper(m, digits, index + 1, res + item, list);
        }
    }
}
