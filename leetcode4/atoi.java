public class Solution {
    public int atoi(String str) {
        int len = str.length();
        int i = 0;
        long result = 0;

        while (i < len && str.charAt(i) == ' ') {
            i++;
        }

        boolean isNeg = false;

        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if (str.charAt(i) == '-') {
                isNeg = true;
            }

            i++;
        }

        while (i < len && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            result = result * 10 + (long) (str.charAt(i) - '0');
            i++;
        }

        result = isNeg ? result * -1 : result; 
        if (result >= (long) Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result <= (long) Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
