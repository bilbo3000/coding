public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        char[] arr1 = num1.toCharArray();  // i
        char[] arr2 = num2.toCharArray();  // j

        List<Character> al1 = new ArrayList<Character>();
        List<Character> al2 = new ArrayList<Character>();

        for (char c : arr1) {
            al1.add(c);
        }

        for (char c : arr2) {
            al2.add(c);
        }

        Collections.reverse(al1);
        Collections.reverse(al2);

        for (int j = 0; j < len2; j++) {
            int carry = 0;
            for (int i = 0; i < len1; i++) {
                int digit1 = (int)(al1.get(i) - '0');
                int digit2 = (int)(al2.get(j) - '0');
                int sum = digit1 * digit2 + carry + result[j + i];
                int digit = sum % 10;
                carry = sum / 10;
                result[j + i] = digit;
            }

            if (carry != 0) {
                result[j + len1] = carry;
            }
        }

        String product = "";
        int i = len1 + len2 - 1;

        while (i >= 0 && result[i] == 0) {
            i--;
        }

        if (i < 0) {
            return "0";
        }

        while (i >= 0) {
            product += (char)(result[i] + '0');
            i--;
        }

        return product;
    }
}
