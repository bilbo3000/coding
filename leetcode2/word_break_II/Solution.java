public class Solution {
    private Set<String> dict = new HashSet<String>();
    private ArrayList<String> result = new ArrayList<String>();
    ArrayList<ArrayList<Integer> > T = new ArrayList<ArrayList<Integer> >();

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        this.dict.addAll(dict);

        for (int i = 0; i < s.length(); i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            T.add(temp);
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                String sub = s.substring(j, i + 1);

                if (dict.contains(sub)) {
                    T.get(i).add(j);
                }
            }
        }

        // Reconstruct
        reconstruct(s, s.length() - 1, "");

        return result;
    }

    public void reconstruct(String s, int currIndex, String currSen) {
        ArrayList<Integer> l = T.get(currIndex);

        for (int i = 0; i < l.size(); i++) {
            int index = l.get(i);
            if (index == 0) {
                this.result.add(s.substring(0, currIndex + 1) + currSen);
            }
            else {
                reconstruct(s, index - 1, " " + s.substring(index, currIndex + 1) + currSen);
            }
        }
    }
}
