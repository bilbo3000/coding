public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();

        if (len == 0) {
            return false;
        }

        if (dict.contains(s)) {
            return true;
        }

        boolean[] T = new boolean[len + 1];
        T[0] = true;

        for (int i = 0; i < len; i++) {
            int index = i;

            while (index >= 0) {
                if (T[index] && dict.contains(s.substring(index, i + 1))) {
                    T[i + 1] = true;
                    break;
                }

                index--;
            }
        }

        return T[len];
    }
}
