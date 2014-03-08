public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (k > n) {
            return result;
        }

        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        for (int i = n; i >= k; i--) {
            ArrayList<ArrayList<Integer>> temp = combine(i - 1, k - 1);

            for (ArrayList<Integer> item : temp) {
                item.add(i);
            }

            result.addAll(temp);
        }

        return result;
    }
}
