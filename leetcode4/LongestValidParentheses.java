public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int len = s.length();
        int last = -1;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                if (stack.size() != 0) {
                    stack.pop();

                    if (stack.size() != 0) {
                        max = Math.max(max, i - stack.peek());
                    } else {
                        max = Math.max(max, i - last);
                    }
                } else {
                    last = i;
                }
            }
        }

        return max;
    }
}
