public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<List<Integer>> temp = helper(num, 0);
        for (List<Integer> item : temp) {
            result.add(item);
        }

        return result;
    }

    private Set<List<Integer>> helper(int[] num, int index) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        int len = num.length;
        if (index == len) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        Set<List<Integer>> temp = helper(num, index + 1);
        for (List<Integer> item : temp) {
            for (int i = 0; i < item.size(); i++) {
                List<Integer> newItem = new ArrayList<Integer>(item);
                newItem.add(i, num[index]);
                result.add(newItem);
            }

            item.add(num[index]);
            result.add(item);
        }

        return result;
    }
}
