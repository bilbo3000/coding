import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 0;
        }

        int cnt = 0;
        List<List<String>> levels = new ArrayList<List<String>>();
        levels.add(new ArrayList<String>());
        levels.add(new ArrayList<String>());
        int lev0 = 0;
        int lev1 = 1;
        levels.get(lev0).add(start);

        while (levels.get(lev0).size() != 0) {
            List<String> curr = levels.get(lev0);
            List<String> next = levels.get(lev1);

            for (int index = 0; index < curr.size(); index++) {
                char[] arr = curr.get(index).toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < 26; j++) {
                        char c = (char) ('a' + j);

                        if (arr[i] != c) {
                            char save = arr[i];
                            arr[i] = c;
                            String str = String.valueOf(arr);
                            arr[i] = save;

                            if (str.equals(end)) {
                                return cnt + 2;
                            }

                            if (dict.contains(str)) {
                                next.add(str);
                                dict.remove(str);
                            }
                        }
                    }
                }
            }

            cnt++;
            curr.clear();
            lev0 = lev0 ^ lev1;
            lev1 = lev0 ^ lev1;
            lev0 = lev0 ^ lev1;
        }

        return 0;
    }
}
