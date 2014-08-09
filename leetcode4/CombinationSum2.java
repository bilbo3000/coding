public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length == 0) {
            return result;
        }

        Set<List<Integer>> temp = new HashSet<List<Integer>>();
        for (int i = 0; i < num.length; i++) {
            helper(num, i, target, new ArrayList<Integer>(), temp);
        }
        result.addAll(temp);

        return result;
    }

    private void helper(int[] num, int index, int target, List<Integer> path, Set<List<Integer>> result) {
        int len = num.length;

        if (index == len) {
            return;
        }

        for (int i = index; i < len; i++) {
            if (num[index] == target) {
                path.add(num[index]);
                result.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            } else if (num[index] < target) {
                path.add(num[index]);
                helper(num, i + 1, target - num[index], path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
