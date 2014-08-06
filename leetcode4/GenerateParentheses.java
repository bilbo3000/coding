public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<Character> parens = new ArrayList<Character>();
        List<String> result = new ArrayList<String>();
        helper(parens, 0, 0, n, result);

        return result;
    }

    private void helper(ArrayList<Character> parens, int leftCount, int rightCount, int n, List<String> result) {
        if (rightCount == n) {  // add to result
            String temp = "";
            for (Character c : parens) {
                temp += c;
            }
            result.add(temp);
            return;
        }

        if (leftCount > rightCount) {
            parens.add(')');
            helper(parens, leftCount, rightCount + 1, n, result);
            parens.remove(parens.size() - 1);
        }

        if (leftCount < n) {
            parens.add('(');
            helper(parens, leftCount + 1, rightCount, n, result);
            parens.remove(parens.size() - 1);
        }

    }
}
