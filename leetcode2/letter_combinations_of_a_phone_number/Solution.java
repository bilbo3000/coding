public class Solution {
    private Map<Character, String> map = new HashMap<Character, String>();

    public ArrayList<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return helper(digits, 0);
    }

    private ArrayList<String> helper(String digits, int index) {
        ArrayList<String> result = new ArrayList<String>();

        if (index == digits.length()) {
            result.add("");
            return result;
        }

        ArrayList<String> temp = helper(digits, index + 1);
        String letters = map.get(digits.charAt(index));

        for (int i = 0; i < letters.length(); i++) {
            for (int j = 0; j < temp.size(); j++) {
                result.add(letters.charAt(i) + temp.get(j));
            }
        }

        return result;
    }
}
