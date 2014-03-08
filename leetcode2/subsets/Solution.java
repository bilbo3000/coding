public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        return helper(S, 0);
    }

    ArrayList<ArrayList<Integer>> helper(int [] S, int index) {
        int len = S.length;
        ArrayList<ArrayList<Integer>> result;

        if (index == len) {
            result = new ArrayList<ArrayList<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }

        int x = S[index];
        result = helper(S, index + 1);
        int n = result.size();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(result.get(i));
            temp.add(x);
            Collections.sort(temp);
            result.add(temp);
        }

        return result;
    }
}
