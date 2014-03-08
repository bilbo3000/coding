public class Solution {
    private Set<ArrayList<Integer>> history = new HashSet<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        return helper(num, 0);
    }

    private ArrayList<ArrayList<Integer>> helper(int[] num, int index) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (index == num.length) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        ArrayList<ArrayList<Integer>> temp = helper(num, index + 1);

        for (int i = 0; i < temp.size(); i++) {
            ArrayList<Integer> perm = temp.get(i);

            for (int j = 0; j < perm.size(); j++) {
                ArrayList<Integer> item = new ArrayList<Integer>(perm);
                item.add(j, num[index]);

                if (!history.contains(item)) {
                    history.add(item);
                    result.add(item);
                }
            }

            ArrayList<Integer> item = new ArrayList<Integer>(perm);
            item.add(num[index]);

            if (!history.contains(item)) {
                history.add(item);
                result.add(item);
            }
        }

        return result;
    }
}
