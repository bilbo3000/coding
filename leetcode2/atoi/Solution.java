public class Solution {
    public int atoi(String str) {
        long result = 0;
        int i = 0;
        int len = str.length();
        boolean isNeg = false;

        while (i < len && str.charAt(i) == ' ') {
            i++;
        }

        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if (str.charAt(i) == '-') {
                isNeg = true;
            }

            i++;
        }

        while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int digit = (int) (str.charAt(i) - '0');
            result = result * 10 + digit;

            if (isNeg) {
                if (-result <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            else {
                if (result >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }

            i++;
        }

        return isNeg ? -(int)result : (int)result;
    }
}
