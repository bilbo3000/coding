import java.util.*;

public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        int len = num.length;

        int i = 0;

        while (i < len - 3) {
            ArrayList<ArrayList<Integer>> temp = threeSum(num, i + 1, target - num[i]);

            for (int j = 0; j < temp.size(); j++) {
                ArrayList<Integer> item = new ArrayList<Integer>(temp.get(j));
                item.add(0, num[i]);
                result.add(item);
            }

            do {
                i++;
            } while (i < len - 3 && num[i] == num[i - 1]);
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num, int i, int target) {
        ArrayList<ArrayList<Integer>> threeResult = new ArrayList<ArrayList<Integer>>();
        int len = num.length;

        while (i < len - 2) {
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum = num[i] + num[j] + num[k];

                if (sum == target) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[j]);
                    temp.add(num[k]);
                    threeResult.add(temp);

                    do {
                        j++;
                    } while (j < k && num[j] == num[j - 1]);

                    do {
                        k--;
                    } while (j < k && num[k] == num[k + 1]);
                }
                else if (sum < target) {
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

        return threeResult;
    }
}
