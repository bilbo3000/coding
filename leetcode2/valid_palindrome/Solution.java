public class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        if (n == 0) return true;

        int i = 0;
        int j = n - 1;

        while (i <= j) {
            while(i < n && !check(s.charAt(i))) {
                i++;
            }

            while (j >= 0 && !check(s.charAt(j))) {
                j--;
            }

            if (i == n || j < 0) return true;

            char left = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j));

            if (left != right) return false;

            i++;
            j--;
        }

        return true;
    }

    public boolean check(char c) {
        int x = (int)(Character.toLowerCase(c) - 'a');

        if (x >= 0 && x < 26) return true;

        x = (int)(c - '0');

        if (x >= 0 && x <= 9) return true;

        return false;
    }
}
