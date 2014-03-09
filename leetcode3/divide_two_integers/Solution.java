import java.util.*;
public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNeg = false;
        long top = (long) dividend;
        long bot = (long) divisor;

        if (top < 0 || bot < 0) {
            if (!(top < 0 && bot < 0)) {
                isNeg = true;
            }

            top = Math.abs(top);
            bot = Math.abs(bot);
        }

        if (top == 0 || top < bot) {
            return 0;
        }

        if (top == bot) {
            return isNeg ? -1 : 1;
        }

        if (bot == 1) {
            return dividend;
        }

        long result = 0;
        long cnt = 0;

        while (top >= bot) {
            while (top - (bot << cnt) >= 0) {
                top -= (bot << cnt);
                result += (1 << cnt);
                cnt++;
            }

            cnt = 0;
        }

        return isNeg ? (int) (0 - result) : (int) result;
    }
}