public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNeg = false;

        if (((dividend >>> 31) ^ (divisor >>> 31)) == 1) {
            isNeg = true;
        }

        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);

        if (dividendLong < divisorLong) {
            return 0;
        }

        if (dividend == divisor) {
            return isNeg ? -1 : 1;
        }

        long result = 0;
        long cnt = 0;

        while (dividendLong - divisorLong >= 0) {
            cnt = 1;
            result += cnt;
            dividendLong -= divisorLong;

            while (dividendLong - (divisorLong << cnt) >= 0) {
                dividendLong -= (divisorLong << cnt);
                cnt = (1 << cnt);
                result += cnt;
            }

            cnt = 0;
        }

        return isNeg ? (int)result * -1 : (int)result;
    }
}
