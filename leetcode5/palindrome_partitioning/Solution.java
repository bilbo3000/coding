public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        helper(s, 0, new ArrayList<String>(), result);

        return result;
    }

    private void helper(String s, int index, List<String> path, List<List<String>> result) {
        int len = s.length();

        if (index == len) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int j = index + 1; j <= len; j++) {
            String str = s.substring(index, j);

            if (isPalin(str)) {
                path.add(str);
                helper(s, j, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalin(String s) {
        int len = s.length();

        if (len == 0) {
            return false;
        }

        int i = 0;
        int j = len - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
