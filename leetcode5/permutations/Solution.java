public class Solution {
    public List<List<Integer>> permute(int[] num) {
        return helper(num, 0);
    }

    private List<List<Integer>> helper(int[] num, int index) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (index == num.length) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        List<List<Integer>> temp = helper(num, index + 1);

        for (int j = 0; j < temp.size(); j++) {
            List<Integer> item = temp.get(j);
            for (int i = 0; i < item.size(); i++) {
                List<Integer> perm = new ArrayList<Integer>();   // !
                perm.addAll(item);
                perm.add(i, num[index]);
                result.add(perm);
            }

            List<Integer> perm = new ArrayList<Integer>();
            perm.addAll(item);
            perm.add(num[index]);
            result.add(perm);
        }

        return result;
    }
}
