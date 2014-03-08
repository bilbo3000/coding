public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (S.length() == 0 || L.length == 0) return result;

        int len = L[0].length();
        int cnt = L.length;
        Map<String, Integer> m = new HashMap<String, Integer>();

        for (int i = 0; i < cnt; i++) {
            if (m.containsKey(L[i])) {
                m.put(L[i], m.get(L[i]) + 1);
            }
            else {
                m.put(L[i], 1);
            }
        }

        for (int i = 0; i <= S.length() - len * cnt; i++) {
            if (m.containsKey(S.substring(i, i + len))) {
                if (check(S, i, m, len, cnt)) {
                    result.add(i);
                }
            }
        }

        return result;
    }

    boolean check(String S, int index, Map<String, Integer> m, int len, int cnt) {
        Map<String, Integer> temp = new HashMap<String, Integer>(m);

        for (int i = 0; i < cnt; i++) {
            String sub = S.substring(index, index + len);

            if (temp.containsKey(sub) && temp.get(sub) > 0) {
                temp.put(sub, temp.get(sub) - 1);
                index += len;
            }
            else {
                return false;
            }
        }

        return true;
    }
}
