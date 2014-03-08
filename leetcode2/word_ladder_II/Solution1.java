import java.util.*;

public class Solution {
    String start = null;
    String end = null;
    HashSet<String> dict = null;
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    Map<String, Set<String>> m = new HashMap<String, Set<String>>();
    boolean stop = false;
    ArrayList<ArrayList<String>> levels = new ArrayList<ArrayList<String>>(2);
    int lev1 = 0;
    int lev2 = 1;

    public ArrayList<String> getPrevLevel(String s) {
        ArrayList<String> next = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char c = (char)('a' + j);

                if (c != s.charAt(i)) {
                    char[] temp = s.toCharArray();
                    temp[i] = c;
                    String tempStr = String.valueOf(temp);

                    if (dict.contains(tempStr)) {
                        next.add(tempStr);
                    }
                }
            }
        }

        return next;
    }

    public boolean check(String s) {
        if (s.length() != start.length()) return false;

        int diff = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != start.charAt(i)) diff++;
        }

        return diff == 1 ? true : false;
    }

    public void reconstruct(String key, ArrayList<String> currResult) {
        currResult.add(0, key);

        if (key == start) {
            this.result.add(new ArrayList<String>(currResult));
            currResult.remove(0);
            return;
        }

        if (!m.containsKey(key)) {
            currResult.remove(0);
            return;
        }

        for (String item : m.get(key)) {
            reconstruct(item, currResult);
        }

        currResult.remove(0);
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        this.start = start;
        this.end = end;
        this.dict = dict;
        dict.remove(start);
        dict.remove(end);
        levels.add(new ArrayList<String>());
        levels.add(new ArrayList<String>());

        levels.get(lev1).add(end);

        while (!stop) {
            for (int i = 0; i < levels.get(lev1).size(); i++) {
                String item = levels.get(lev1).get(i);

                if (!m.containsKey(item)) {
                    m.put(item, new HashSet<String>());
                }

                if (check(item)) {
                    stop = true;
                    m.get(item).add(start);
                }
                else {
                    ArrayList<String> prevLevel = getPrevLevel(item);
                    m.get(item).addAll(prevLevel);
                    levels.get(lev2).addAll(prevLevel);
                }
            }

            if (levels.get(lev2).size() == 0) {
                stop = true;
            }

            dict.removeAll(levels.get(lev2));

            levels.get(lev1).clear();
            lev1 = lev1 ^ lev2;
            lev2 = lev1 ^ lev2;
            lev1 = lev1 ^ lev2;
        }

        reconstruct(end, new ArrayList<String>());

        return result;
    }
}
