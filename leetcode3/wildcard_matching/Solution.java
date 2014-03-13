import java.util.*;

public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        int i = 0;
        int j = 0;
        int nexti = -1;
        int nextj = -1;

        while (true) {
            if (i == slen && j == plen) {
                return true;
            }

            if (j == plen && i != slen) {
                if (nexti != -1 && nextj != -1) {
                    i = nexti;
                    j = nextj;
                }
                else {
                    return false;
                }
            }

            if (i == slen) {
                while (j < plen && p.charAt(j) == '*') {
                    j++;
                }

                return j == plen ? true : false;
            }

            if (p.charAt(j) == '*') {
                nexti = i + 1;
                nextj = j;
                j++;
            }
            else {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    i++;
                    j++;
                }
                else {
                    if (nexti != -1 && nextj != -1) {
                        i = nexti;
                        j = nextj;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
    }
}