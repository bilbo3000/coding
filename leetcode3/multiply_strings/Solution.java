import java.util.*;
public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        char[] carr1 = num1.toCharArray();
        char[] carr2 = num2.toCharArray();

        int[] result = new int[len1 + len2];

        for (int j = 0; j < len2; j++) {
            int curr2 = (int)(carr2[j] - '0');
            int carry = 0;

            for (int i = 0; i < len1; i++) {
                int curr1 = (int)(carr1[i] - '0');
                int digit = carry + curr1 * curr2 % 10;
                carry = curr1 * curr2 / 10;

                result[j + i] += digit;

                if (result[j + i] >= 10) {
                    result[j + i + 1] += result[j + i] / 10;
                    result[j + i] %= 10;
                }
            }

            if (carry != 0) {
                result[j + len1] += carry;

                if (result[j + len1] >= 10) {
                    result[j + len1 + 1] += result[j + len1] / 10;
                    result[j + len1] %= 10;
                }
            }
        }

        String product = "";

        int i = len1 + len2 - 1;

        while (i >= 0 && result[i] == 0) {
            i--;
        }

        while (i >= 0) {
            product += (char)(result[i] + '0');
            i--;
        }

        return product.length() == 0 ? "0" : product;
    }
}