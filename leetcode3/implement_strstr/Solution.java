public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return haystack; 
        }
        
        if (needle.length() == 0) {
            return haystack;
        }
        
        if (haystack.length() == 0) {
            return null; 
        }

        int[] pi = buildPrefixTable(needle);
        int m = 0;

        for (int i = 0; i < haystack.length(); i++) {
            while (m != 0 && needle.charAt(m) != haystack.charAt(i)) {
                m = pi[m - 1];
            }

            if (needle.charAt(m) == haystack.charAt(i)) {
                m++;

                if (m == needle.length()) {
                    return haystack.substring(i - m + 1);
                }
            }
        }

        return null;
    }

    private int[] buildPrefixTable(String needle) {
        int len = needle.length();

        if (len == 0) {
            return null;
        }

        int[] pi = new int[len];
        pi[0] = 0;
        int k = pi[0];

        for (int i = 1; i < len; i++) {
            while (k != 0 && needle.charAt(k) != needle.charAt(i)) {
                k = pi[k - 1];
            }

            if (needle.charAt(k) == needle.charAt(i)) {
                pi[i] = ++k;
            }
        }

        return pi;
    }
}
