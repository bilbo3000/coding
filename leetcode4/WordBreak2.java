public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        int len = s.length();

        if (len == 0) {
            new ArrayList<String>();
        }

        ArrayList<ArrayList<Integer>> T = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < len; i++) {
            T.add(new ArrayList<Integer>());
            if (dict.contains(s.substring(0, i + 1))) {
                T.get(i).add(-1);
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dict.contains(s.substring(j + 1, i + 1)) && T.get(j).size() != 0) {
                    T.get(i).add(j);
                }
            }
        }

        // Reconstruct
        List<String> result = new ArrayList<String>();

        reconstruct(s, T, len - 1, new ArrayList<String>(), result);
        return result;
    }

    private void reconstruct(String s, ArrayList<ArrayList<Integer>> T, int index, List<String> path, List<String> result) {
        if (index == -1) {
            if (path.size() > 0) {
                String temp = path.get(0);

                for (int i = 1; i < path.size(); i++) {
                    temp = path.get(i) + " " + temp;
                }

                result.add(temp);
            }
            return;
        }

        ArrayList<Integer> temp = T.get(index);

        for (int item : temp) {
            path.add(s.substring(item + 1, index + 1));
            reconstruct(s, T, item, path, result);
            path.remove(path.size() - 1);
        }
    }
}
