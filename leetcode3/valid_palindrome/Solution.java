public class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();

        if (len == 0) {
            return true;
        }

        int left = 0;
        int right = len - 1;
        s = s.toLowerCase();

        while (left <= right) {
            while (left < len && !((s.charAt(left) >= 'a' && s.charAt(left) <= 'z') || (s.charAt(left) >= '0' && s.charAt(left) <= '9'))) {
                left++;
            }

            while (right >= 0 && !((s.charAt(right) >= 'a' && s.charAt(right) <= 'z') || (s.charAt(right) >= '0' && s.charAt(right) <= '9'))) {
                right--;
            }

            if (left < right && s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
