public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 0;
        }

        dict.remove(start);
        dict.remove(end);
        int length = 1;
        ArrayList<Set<String>> levels = new ArrayList<Set<String>>();
        levels.add(new HashSet<String>());
        levels.add(new HashSet<String>());
        int lev0 = 0;
        int lev1 = 1;
        int wordLen = start.length();

        levels.get(0).add(start);

        while (levels.get(lev0).size() != 0) {
            Set<String> curr = levels.get(lev0);
            Set<String> next = levels.get(lev1);

            for (String item : curr) {
                for (int i = 0; i < wordLen; i++) {
                    for (int j = 0; j < 26; j++) {
                        char[] charArr = item.toCharArray();

                        if (charArr[i] != (char)('a' + j)) {
                            charArr[i] = (char)('a' + j);
                            String itemNew = String.valueOf(charArr);

                            if (itemNew.equals(end)) {
                                return length + 1;
                            } else if (dict.contains(itemNew)){
                                next.add(itemNew);
                            }
                        }
                    }
                }
            }

            length++;
            dict.removeAll(curr);
            curr.clear();
            lev0 = lev0 ^ lev1;
            lev1 = lev0 ^ lev1;
            lev0 = lev0 ^ lev1;
        }

        return 0;
    }
}
