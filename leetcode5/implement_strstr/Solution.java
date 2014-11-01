public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }

        int len1 = haystack.length();
        int len2 = needle.length();

        if (len1 == 0 || len2 == 0) {
            if (len2 == 0) {
                return haystack;
            } else {
                return null;
            }
        }

        int m = 0;
        int i = 0;
        int[] pi = suffixTable(needle);

        while (i < len1) {
            if (m == len2) {
                return haystack.substring(i - m);
            }

            while (m > 0 && haystack.charAt(i) != needle.charAt(m)) {
                m = pi[m - 1];
            }

            if (haystack.charAt(i) == needle.charAt(m)) {
                m++;
            }

            i++;
        }

        if (m == len2) {
            return haystack.substring(i - m);
        }

        return null;
    }

    private int[] suffixTable(String needle) {
        int len = needle.length();
        int[] pi = new int[len];

        if (len == 0) {
            return pi;
        }

        pi[0] = 0;
        int m = 0;  // Current match length

        for (int i = 1; i < len; i++) {
            while (m > 0 && needle.charAt(m) != needle.charAt(i)) {
                m = pi[m - 1];
            }

            if (needle.charAt(m) == needle.charAt(i)) {
                pi[i] = m + 1;
                m = m + 1; 
            }
        }

        return pi;
    }
}
