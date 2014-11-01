public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        int len = s.length();
        List<String> result = new ArrayList<String>();
        List<List<Integer>> T = new ArrayList<List<Integer>>();

        for (int i = 0; i < len; i++) {
            List<Integer> temp = new ArrayList<Integer>();

            if (dict.contains(s.substring(0, i + 1))) {
                temp.add(-1);
            }

            int j = i - 1;

            while (j >= 0) {
                if (T.get(j).size() != 0 && dict.contains(s.substring(j + 1, i + 1))) {
                    temp.add(j);
                }

                j--;
            }

            T.add(temp);
        }

        // Reconstruct 
        reconstruct(T, len - 1, s, new ArrayList<String>(), result);

        return result;
    }

    private void reconstruct(List<List<Integer>> T, int index, String s, List<String> path, List<String> result) {
        if (index == -1) {
            if (path.size() > 0) {
                String temp = path.get(0);

                for (int i = 1; i < path.size(); i++) {
                    temp += " " + path.get(i);
                }

                result.add(temp);
            }
            return;
        }

        if (index < T.size()) {
            List<Integer> level = T.get(index);

            for (int item : level) {
                path.add(0, s.substring(item + 1, index + 1));
                reconstruct(T, item, s, path, result);
                path.remove(0);
            }
        }
    }
}
