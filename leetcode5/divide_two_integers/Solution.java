public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNeg = false;

        if (((dividend >>> 31) ^ (divisor >>> 31)) != 0) {
            isNeg = true;
        }

        long d1 = Math.abs((long) dividend);
        long d2 = Math.abs((long) divisor);

        if (d1 < d2) {
            return 0;
        }

        long curr = d1;
        long base = d2;
        long result = 0;
        long cnt = 1;

        while ((curr - d2) >= 0) {
            if (curr - base >= 0) {
                curr -= base;
                result += cnt;
                base = (base << 1);
                cnt = (cnt << 1);
            } else {
                base = d2;
                cnt = 1;
            }
        }

        if (isNeg) {
            return (int)(-result);
        }

        return (int) result;
    }
}
