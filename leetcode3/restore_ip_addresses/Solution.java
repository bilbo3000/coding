c class Solution {
    private ArrayList<String> result = new ArrayList<String>();

    public ArrayList<String> restoreIpAddresses(String s) {
        helper(s, "", 0, 0);

        return result;
    }

    private void helper(String s, String curr, int index, int sec) {
        if (index == s.length() && sec == 4) {
            result.add(curr);
            return;
        }

        if (sec == 4 && index != s.length() || index == s.length() && sec != 4) {
            return;
        }

        // single char
        String next = curr.length() == 0 ? s.substring(index, index + 1) : curr + "." + s.substring(index, index + 1);
        helper(s, next, index + 1, sec + 1);

        // Two char
        if (index <= s.length() - 2) {
            int temp = Integer.parseInt(s.substring(index, index + 2));

            if (temp >= 10) {
                next = curr.length() == 0 ? s.substring(index, index + 2) : curr + "." + s.substring(index, index + 2);
                helper(s, next, index + 2, sec + 1);
            }
        }

        // Three char
        if (index <= s.length() - 3) {
            int temp = Integer.parseInt(s.substring(index, index + 3));
            if (temp <= 255 && temp >= 100) {
                next = curr.length() == 0 ? s.substring(index, index + 3) : curr + "." + s.substring(index, index + 3);
                helper(s, next, index + 3, sec + 1);
            }
        }
    }
}
