public class Solution {
    ArrayList<String> result = new ArrayList<String>();

    public ArrayList<String> restoreIpAddresses(String s) {
        helper(s, "", 0);

        return result;
    }

    void helper(String s, String curr, int sec) {
        int len = s.length();
        
        if (len > 12) return; 

        if (len == 0) {
            if (sec == 4) {
                result.add(curr.substring(0, curr.length() - 1));
            }

            return;
        }

        if (s.charAt(0) == '0') {
            helper(s.substring(1, len), curr + "0.", sec + 1);
            return;
        }

        int n = Math.min(len, 3);

        for (int i = 1; i <= n; i++) {
            String str = s.substring(0, i);

            if (check(str)) {
                helper(s.substring(i, len), curr + str + ".", sec + 1);
            }
        }
    }

    boolean check(String s) {
        int len = s.length();

        if (len > 3) return false;

        int result = 0;

        for (int i = 0; i < len; i++) {
            int digit = (int)(s.charAt(i) - '0');
            result = result * 10 + digit;
        }

        if (result <= 255) {
            return true;
        }
        else {
            return false;
        }
    }
}
