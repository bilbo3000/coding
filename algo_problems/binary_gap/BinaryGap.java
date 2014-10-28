import java.util.Stack;

/**
 * Created by Dongpu on 10/27/14.
 */
public class BinaryGap {
    public int getBinaryGap(String s) {
        int result = 0;
        int len = s.length();

        if (len == 0) {
            return result;
        }

        Stack<Character> stack = new Stack<Character>();
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == '0' && stack.size() != 0) {
                cnt++;
            } else {
                if (stack.size() == 0) {
                    stack.push(c);
                } else {
                    stack.pop();
                    result = Math.max(result, cnt);
                    cnt = 0;
                }
            }
        }

        return result;
    }
}
