public class Solution {
    public int sqrt(int x) {
        long prev = 0;
        long curr = 1;

        while (curr * curr < x) {
            prev = curr;
            curr = curr * 2;
        }

        while (prev <= curr) {
            long mid = (prev + curr) / 2;
            long temp = mid * mid;
            if (temp == x) return (int)mid;

            if (temp < x) {
                prev = mid + 1;
            }
            else {
                curr = mid - 1;
            }
        }

        return (int)curr;
    }
}
