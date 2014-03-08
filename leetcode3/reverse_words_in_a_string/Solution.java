public class Solution {
    public String reverseWords(String s) {
        String result = "";
        int len = s.length();
        Stack<String> stack = new Stack<String>();
        int i = 0;
        int j = 0;

        while (j < len) {
            while (i < len && s.charAt(i) == ' ' ) {
                i++;
            }

            j = i + 1;

            while (j < len && s.charAt(j) != ' ') {
                j++;
            }

            if (i < len) {
                stack.push(s.substring(i, j));
            }

            i = j;
        }

        while (stack.size() != 0) {
            if (result.length() == 0) {
                result += stack.pop();
            }
            else {
                result += " " + stack.pop();
            }
        }

        return result;
    }
}