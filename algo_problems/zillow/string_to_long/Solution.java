import java.util.*;

public class Solution {
    /*
        Function that converts input string to long.
         The assumption made here is that the value of input string
         would not exceed upper bound Long.MAX_VALUE and lower bound
         Long.MIN_VALUE.
     */
    public long stringToLong(String s) {
        int len = s.length();
        long result = 0;  // Hold the result
        int i = 0;  // Index that walks through the input

        // Ignore leading spaces
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }

        // Process signs, if any
        boolean isNeg = false;

        if (i < len && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                isNeg = true;  // Input is negative
            }

            i++;
        }

        // Calculate the result, ignore all non-digit trailing characters
        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            long digit = (long) (s.charAt(i) - '0');
            result = result * 10 + digit;
            i++;
        }

        if (isNeg) {  // Negative
            result = -result;
        }

        return result;
    }
}
