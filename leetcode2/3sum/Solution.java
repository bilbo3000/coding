public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        int len = num.length;

        int i = 0;

        while (i < len - 2) {
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum = num[i] + num[j] + num[k];

                if (sum == 0) {
                    ArrayList<Integer> item = new ArrayList<Integer>();
                    item.add(num[i]);
                    item.add(num[j]);
                    item.add(num[k]);
                    result.add(item);

                    do {
                        j++;
                    } while (j < k && num[j] == num[j - 1]);

                    do {
                        k--;
                    } while (k > j && num[k] == num[k + 1]);
                }
                else if (sum < 0) {
                    j++;
                }
                else {
                    k--;
                }
            }

            do {
                i++;
            } while (i < len - 2 && num[i] == num[i - 1]);
        }

        return result;
    }
}
