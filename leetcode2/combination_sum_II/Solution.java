public class Solution {
    private Set<ArrayList<Integer>> history = new HashSet<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        helper(num, 0, new ArrayList<Integer>(), target);
        return result;
    }

    private void helper(int [] num, int index, ArrayList<Integer> curr, int target) {
        if (index == num.length || target < 0) {
            return;
        }

        for (int i = index; i < num.length; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);

            if (num[i] == target) {
                temp.add(num[i]);

                if (!history.contains(temp)) {
                    result.add(temp);
                    history.add(temp); 
                    return;
                }
            }
            else if (num[i] < target) {
                temp.add(num[i]);

                helper(num, i + 1, temp, target - num[i]);
            }
        }
    }
}
