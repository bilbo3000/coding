public class Solution {
    public int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long prev = 0;
        long curr = 1;

        while (curr * curr < x) {
            prev = curr;
            curr = curr * 2;
        }

        while (curr >= prev) {
            long mid = (curr + prev) / 2;

            if (mid * mid == x) {
                return (int) mid;
            }

            if (mid * mid > x) {
                curr = mid - 1;
            } else {
                prev = mid + 1;
            }
        }

        return (int) curr;
    }
}
