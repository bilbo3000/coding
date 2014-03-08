public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNeg = false;

        if (((dividend >>> 31) ^ (divisor >>> 31)) == 1) {
            isNeg = true;
        }

        long dividendl = Math.abs((long)dividend);
        long divisorl = Math.abs((long)divisor);
        long prev = 0;
        long curr = 1;

        while (curr * divisorl < dividendl) {
            prev = curr;
            curr = curr * 2;
        }

        while (prev <= curr) {
            long mid = (prev + curr) / 2;
            long temp = (mid * divisorl);

            if (temp == dividendl) {
                return isNeg ? -(int)mid : (int)mid;
            }

            if (temp < dividendl) {
                prev = mid + 1;
            }
            else {
                curr = mid - 1;
            }
        }

        return isNeg ? -(int)curr : (int)curr;
    }
}
