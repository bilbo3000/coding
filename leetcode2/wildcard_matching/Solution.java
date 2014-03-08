public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        int i = 0;
        int j = 0;
        int store = -1;
        int star = -1;

        while (true) {
            if (i == len1 || j == len2) {
                if (i == len1 && j == len2) {
                    return true;
                }

                if (i == len1) {
                    if (p.charAt(j) == '*') {
                        j++;
                    }
                    else {
                        return false;
                    }
                }
                else if (j == len2) {
                    if (star < 0) {
                        return false;
                    }
                    else {
                        j = star;
                        i = store;
                    }
                }
            }
            else{
                char c1 = s.charAt(i);
                char c2 = p.charAt(j);

                if (c1 == c2 || c2 == '?') {
                    i++;
                    j++;
                }
                else if (c2 == '*') {
                    store = i + 1;
                    star = j;
                    j++;  // Try to skip
                }
                else {
                    if (star < 0) {
                        return false;
                    }
                    else {
                        i = store;
                        j = star;
                    }
                }
            }
        }
    }
}
