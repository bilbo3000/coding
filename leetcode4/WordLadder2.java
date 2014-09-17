public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        dict.remove(start);
        dict.remove(end);

        Map<String, HashSet<String>> m = new HashMap<String, HashSet<String>>();
        m.put(start, null);
        ArrayList<Set<String>> levels = new ArrayList<Set<String>>();
        levels.add(new HashSet<String>());
        levels.add(new HashSet<String>());
        int lev0 = 0;
        int lev1 = 1;
        levels.get(0).add(start);
        int wordLength = start.length();

        while (levels.get(lev0).size() != 0) {
            Set<String> curr = levels.get(lev0);
            Set<String> next = levels.get(lev1);

            for (String item : curr) {
                for (int i = 0; i < wordLength; i++) {
                    for (int j = 0; j < 26; j++) {
                        char[] charArr = item.toCharArray();

                        if (charArr[i] != (char)('a' + j)) {
                            charArr[i] = (char)('a' + j);
                            String itemNew = String.valueOf(charArr);

                            if (itemNew.equals(end) || dict.contains(itemNew)) {
                                if (!m.containsKey(itemNew)) {
                                    m.put(itemNew, new HashSet<String>());
                                }

                                m.get(itemNew).add(item);
                                next.add(itemNew);
                            }
                        }
                    }
                }
            }

            dict.removeAll(next);
            curr.clear();
            lev0 = lev0 ^ lev1;
            lev1 = lev0 ^ lev1;
            lev0 = lev0 ^ lev1;
            
            if (next.contains(end)) {
                break; 
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();
        reconstruct(end, m, new ArrayList<String>(), result);

        return result;
    }

    private void reconstruct(String word, Map<String, HashSet<String>> m, List<String> path, List<List<String>> result) {
        if (m.containsKey(word)) {
            path.add(0, word);
            Set<String> parents = m.get(word);

            if (parents == null) {
                result.add(path);
            } else {
                for (String item : parents) {
                    List<String> newPath = new ArrayList<String>();
                    newPath.addAll(path);
                    reconstruct(item, m, newPath, result);
                }
            }
        }
    }
}
