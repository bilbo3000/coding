public class Solution {
    public String strStr(String haystack, String needle) {
        int[] pi = buildSuffixArray(needle);
        int m = 0;
        int len1 = haystack.length();
        int len2 = needle.length();

        if (len1 == 0 && len2 == 0) {
            return "";
        }

        if (len2 == 0) {
            return haystack;
        }

        if (len1 == 0) {
            return null;
        }

        String result = null;

        int i = 0;
        while (i < len1) {
            while (m > 0 && haystack.charAt(i) != needle.charAt(m)) {
                m = pi[m - 1];
            }

            if (haystack.charAt(i) == needle.charAt(m)) {
                m = m + 1;

                if (m == len2) {
                    result = haystack.substring(i - m + 1);
                    break;
                }
            }

            i++;
        }

        return result;
    }

    private int[] buildSuffixArray(String needle) {
        int len = needle.length();

        if (len == 0) {
            return null;
        }

        int[] pi = new int[len];
        pi[0] = 0;
        int k = 0;

        for (int i = 1; i < len; i++) {
            while (k > 0 && needle.charAt(k) != needle.charAt(i)) {
                k = pi[k - 1];
            }

            if (needle.charAt(k) == needle.charAt(i)) {
                k++;
                pi[i] = k;
            }
        }

        return pi;
    }
}
