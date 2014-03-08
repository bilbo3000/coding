public class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 && j >= 0) {
            int digit_a = (int)(a.charAt(i) - '0');
            int digit_b = (int)(b.charAt(j) - '0');
            int sum = digit_a + digit_b + carry;
            carry = sum / 2;
            int digit = sum % 2;
            result = (char)(digit + '0') + result;
            i--;
            j--;
        }

        while (i >= 0) {
            int digit_a = (int)(a.charAt(i) - '0');
            int sum = digit_a + carry;
            carry = sum / 2;
            int digit = sum % 2;
            result = (char)(digit + '0') + result;
            i--;
        }

        while (j >= 0) {
            int digit_b = (int)(b.charAt(j) - '0');
            int sum = digit_b + carry;
            carry = sum / 2;
            int digit = sum % 2;
            result = (char)(digit + '0') + result;
            j--;
        }

        if (carry == 1) {
            result = "1" + result;
        }

        return result;
    }
}
