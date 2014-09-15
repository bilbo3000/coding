public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        int i = 0;
        int j = 0;
        int saved1 = -1;
        int saved2 = -1;

        while (i <= len1 && j <= len2) {
            if (i == len1) {
                while (j < len2 && p.charAt(j) == '*') {
                    j++;
                }

                if (j == len2) {
                    return true;
                } else {
                    return false;
                }
            }

            if (j == len2) {
                if (saved1 == -1 || saved1 > len1 || saved2 == -1 || saved2 > len2) {
                    return false;
                } else {
                    i = saved1;
                    j = saved2;
                }
            }

            if (i < len1 && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else {
                if (p.charAt(j) != '*') {  // Mismatch
                    if (saved1 != -1 && saved2 != -1) {
                        i = saved1;
                        j = saved2;
                    } else {
                        return false;
                    }
                } else { // *
                    saved1 = i + 1;
                    saved2 = j;
                    j++;
                }
            }
        }

        return false;
    }
}
