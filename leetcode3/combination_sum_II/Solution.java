public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;

        if (len == 0) {
            return result;
        }

        Arrays.sort(num);
        result.addAll(helper(num, 0, target));

        return result;
    }

    private Set<ArrayList<Integer>> helper(int[] num, int index, int target) {
        int len = num.length;
        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();

        for (int i = index; i < len; i++) {
            if (num[i] == target) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(num[i]);
                result.add(temp);
                return result;
            }
            else if (num[i] < target) {
                Set<ArrayList<Integer>> temp = helper(num, i + 1, target - num[i]);

                for (ArrayList<Integer> item : temp) {
                    item.add(0, num[i]);
                }

                result.addAll(temp);
            }
            else {
                return result;
            }
        }

        return result;
    }
}
