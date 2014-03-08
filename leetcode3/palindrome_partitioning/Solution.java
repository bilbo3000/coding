public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        int len = s.length();
        boolean[][] palin = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            palin[i][i] = true;
        }

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                palin[i - 1][i] = true;
            }
            else {
                palin[i - 1][i] = false;
            }
        }

        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    palin[i][j] = false;
                }
                else {
                    palin[i][j] = palin[i + 1][j - 1];
                }
            }
        }

        ArrayList<ArrayList<Integer>> T = new ArrayList<ArrayList<Integer>>();

        for (int j = 0; j < len; j++) {
            T.add(new ArrayList<Integer>());

            for (int i = j; i >= 0; i--) {
                if (palin[i][j]) {
                    T.get(j).add(i);
                }
            }
        }

        // Reconstruct
        return reconstruct(T, palin, len - 1, s);
    }

    private ArrayList<ArrayList<String>> reconstruct(ArrayList<ArrayList<Integer>> T, boolean[][] palin, int index, String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if (index < 0) {
            result.add(new ArrayList<String>());
            return result;
        }

        ArrayList<Integer> temp = T.get(index);

        for (int i = 0; i < temp.size(); i++) {
            int left = temp.get(i);

            if (palin[left][index]) {
                ArrayList<ArrayList<String>> tempResult = reconstruct(T, palin, left - 1, s);
                String substr = s.substring(left, index + 1);

                for (int j = 0; j < tempResult.size(); j++) {
                    tempResult.get(j).add(substr);
                }

                result.addAll(tempResult);
            }
        }

        return result;
    }
}
