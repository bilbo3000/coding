public class Solution {
    public String multiply(String num1, String num2) {
        char[] c1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] c2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;

        if (len1 == 0 || len2 == 0) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len = len1 + len2;
        char[] result = new char[len];

        for (int i = 0; i < len; i++) {
            result[i] = '0';
        }

        int j = 0;

        while (j < len2) {
            int carry = 0;
            int i = 0;

            while (i < len1) {
                int d1 = (int)(c1[i] - '0');
                int d2 = (int)(c2[j] - '0');
                int prod = d1 * d2;
                int sum = prod + carry + (int)(result[i + j] - '0');
                int digit = sum % 10;
                carry = sum / 10;
                result[i + j] = (char)(digit + '0');
                i++;
            }

            if (carry != 0) {
                result[i + j] = (char)(carry + '0');
            }
            j++;
        }

        String r = new StringBuilder(new String(result)).reverse().toString();
        if (r.charAt(0) == '0') {
            return r.substring(1);
        }
        else {
            return r;
        }
    }
}
