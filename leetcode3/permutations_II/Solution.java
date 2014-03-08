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

        ArrayList<ArrayList<Integer>> tempResult = helper(num, index + 1);

        for (int i = 0; i < tempResult.size(); i++) {
            ArrayList<Integer> temp = tempResult.get(i);

            for (int j = 0; j < temp.size(); j++) {
                ArrayList<Integer> perm = (ArrayList<Integer>) temp.clone();
                perm.add(j, num[index]);

                if (!history.contains(perm)) {
                    result.add(perm);
                    history.add(perm);
                }
            }

            ArrayList<Integer> perm = (ArrayList<Integer>) temp.clone();
            perm.add(num[index]);

            if (!history.contains(perm)) {
                result.add(perm);
                history.add(perm);
            }
        }

        return result;
    }
}
