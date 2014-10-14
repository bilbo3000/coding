import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<List<Integer>> temp = new HashSet<List<Integer>>();

        helper(num, 0, new ArrayList<Integer>(), 0, target, temp);

        result.addAll(temp);

        return result;
    }

    private void helper(int[] num, int index, List<Integer> path, int sum, int target, Set<List<Integer>> result) {
        if (sum == target && !result.contains(path)) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (sum > target || index >= num.length || num[index] > target) {
            return;
        }

        helper(num, index + 1, path, sum, target, result);
        path.add(num[index]);
        helper(num, index + 1, path, sum + num[index], target, result);
        path.remove(path.size() - 1);
    }
}
