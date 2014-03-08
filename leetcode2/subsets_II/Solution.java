public class Solution {
    int cnt = 0;

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        return helper(0, num);
    }

    ArrayList<ArrayList<Integer>> helper(int index, int [] num) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> result;

        if (index == len) {
            result = new ArrayList<ArrayList<Integer>>();
            result.add(new ArrayList<Integer>());
            cnt = 1;

            return result;
        }

        result = helper(index + 1, num);
        int n = result.size();
        int x = num[index];

        if (index < len - 1 && num[index] == num[index + 1]) {
            for (int i = n - cnt; i < n; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(result.get(i));
                temp.add(0, x);
                result.add(temp);
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(result.get(i));
                temp.add(0, x);
                result.add(temp);
            }
            cnt = n;
        }
        return result;
    }
}
