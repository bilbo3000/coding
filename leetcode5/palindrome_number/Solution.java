public class Solution {
    public boolean isPalindrome(int xx) {
        long x = xx;
        if (x < 0) {
            return false;
        }

        long base = 1;

        while (x / base > 0) {
            base *= 10;
        }

        base /= 10;

        if (base == 0) {
            return true;
        }
        
        while (x > 0) {
            long leftDigit = x / base;
            long rightDigit = x % 10;

            if (leftDigit != rightDigit) {
                return false;
            }

            x %= base;
            x /= 10;
            base /= 100;
        }

        return true;
    }
}
