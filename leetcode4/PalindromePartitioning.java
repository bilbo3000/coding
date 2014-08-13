public class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> result = new ArrayList<List<String>>();

        if (len == 0) {
            return result;
        }

        boolean[][] isPalindrome = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
            }
        }

        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        List<List<Integer>> T = new ArrayList<List<Integer>>();

        for (int i = 0; i < len; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = i; j >= 0; j--) {
                if (isPalindrome[j][i]) {
                    temp.add(j - 1);
                }
            }

            T.add(temp);
        }

        reconstruct(s, len - 1, T, new ArrayList<String>(), result);

        return result;
    }

    private void reconstruct(String s, int index, List<List<Integer>> T, List<String> path, List<List<String>> result) {
        if (index == -1) {
            result.add(path);
            return;
        }

        List<Integer> indexList = T.get(index);

        for (int item : indexList) {
            String str = s.substring(item + 1, index + 1);
            List<String> newPath = new ArrayList<String>(path);
            newPath.add(0, str);
            reconstruct(s, item, T, newPath, result);
        }
    }
}
