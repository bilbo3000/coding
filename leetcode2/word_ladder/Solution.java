public class Solution {
    HashSet<String> dict = null;
    String start = null;
    String end = null;
    int cnt = 0;
    int lev1 = 0;
    int lev2 = 1;
    boolean stop = false;
    ArrayList<ArrayList<String>> levels = new ArrayList<ArrayList<String>>();

    public int ladderLength(String start, String end, HashSet<String> dict) {
        this.dict = dict;
        this.start = start;
        this.end = end;
        dict.remove(start);
        dict.remove(end);
        levels.add(new ArrayList<String>());
        levels.add(new ArrayList<String>());
        levels.get(lev1).add(start);

        while (!stop) {
            ArrayList<String> currLevel = levels.get(lev1);
            ArrayList<String> nextLevel = levels.get(lev2);
            cnt++;

            for (int i = 0; i < currLevel.size(); i++) {
                if (check(currLevel.get(i))) {
                    stop = true;
                    cnt++;
                    break;
                }
            }

            if (!stop) {
                for (int i = 0; i < currLevel.size(); i++) {
                    nextLevel.addAll(getNextLevel(currLevel.get(i)));
                }

                if (nextLevel.size() == 0) {
                    stop = true;
                    cnt = 0;
                    break;
                }

                currLevel.clear();
                lev1 = lev1 ^ lev2;
                lev2 = lev1 ^ lev2;
                lev1 = lev1 ^ lev2;
            }
        }

        return cnt;
    }

    public ArrayList<String> getNextLevel(String s) {
        ArrayList<String> nextLevel = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);

                if (s.charAt(i) != c) {
                    char [] arr = s.toCharArray();
                    arr[i] = c;
                    String temp = String.valueOf(arr);

                    if (dict.contains(temp)) {
                        nextLevel.add(temp);
                        dict.remove(temp);
                    }
                }
            }
        }

        return nextLevel;
    }

    public boolean check(String s) {
        if (s.length() != end.length()) return false;

        int diff = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != end.charAt(i)) diff++;
        }

        return diff == 1 ? true : false;
    }
}
