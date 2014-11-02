import java.util.*;

public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, Set<String>> parents = new HashMap<String, Set<String>>();
        boolean stop = false;
        dict.remove(start);
        dict.remove(end);

        if (start.equals(end)) {
            return result;
        }

        List<Set<String>> levels = new ArrayList<Set<String>>();
        int lev0 = 0;
        int lev1 = 1;
        levels.add(new HashSet<String>());
        levels.add(new HashSet<String>());
        levels.get(lev0).add(start);
        parents.put(start, new HashSet<String>());

        while (!stop && levels.get(lev0).size() != 0) {
            Set<String> curr = levels.get(lev0);
            Set<String> next = levels.get(lev1);

            for (String item : curr) {
                char[] arr = item.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < 26; j++) {
                        char c = (char) ('a' + j);

                        if (arr[i] != c) {
                            char save = arr[i];
                            arr[i] = c;
                            String str = String.valueOf(arr);
                            arr[i] = save;

                            if (str.equals(end) || dict.contains(str)) {
                                if (str.equals(end)) {
                                    stop = true;
                                }

                                if (!parents.containsKey(str)) {
                                    parents.put(str, new HashSet<String>());
                                }

                                parents.get(str).add(item);
                                next.add(str);
                            }
                        }
                    }
                }
            }

            curr.clear();
            dict.removeAll(next);
            lev0 = lev0 ^ lev1;
            lev1 = lev0 ^ lev1;
            lev0 = lev0 ^ lev1;
        }

        // Reconstruct 
        reconstruct(parents, end, new ArrayList<String>(), result);

        return result;
    }

    private void reconstruct(Map<String, Set<String>> m, String key, List<String> path, List<List<String>> result) {
        if (!m.containsKey(key)) {
            return;
        }
        
        if (m.get(key).size() == 0) {
            path.add(0, key);
            result.add(new ArrayList<String>(path));
            path.remove(0);
            return;
        }

        Set<String> parents = m.get(key);

        for (String parent : parents) {
            path.add(0, key);
            reconstruct(m, parent, path, result);
            path.remove(0);
        }
    }
}
