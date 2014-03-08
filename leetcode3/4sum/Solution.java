public class Solution {
    private Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            helper(num, target, i);
        }

        return new ArrayList<ArrayList<Integer>>(result);
    }

    private void helper(int[] num, int target, int index) {
        int i = index + 1;
        int len = num.length;

        while (i < len) {
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum = num[index] + num[i] + num[j] + num[k];

                if (sum == target) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[index]);
                    temp.add(num[i]);
                    temp.add(num[j]);
                    temp.add(num[k]);
                    result.add(temp);

                    do {
                        j++;
                    } while (j < k && num[j] == num[j - 1]);

                    do {
                        k--;
                    } while (j < k && num[k] == num[k + 1]);
                }
                else if (sum < target) {
                    do {
                        j++;
                    } while (j < k && num[j] == num[j - 1]);
                }
                else {
                    do {
                        k--;
                    } while (j < k && num[k] == num[k + 1]);
                }
            }

            do {
                i++;
            } while (i < len && num[i] == num[i - 1]);
        }
    }
}
