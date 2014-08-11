public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int len = num.length;
        int sum = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < len - 2; i++) {
            int l = i + 1;
            int r = len - 1;

            while (l < r) {
                int currSum = num[i] + num[l] + num[r];
                int newDiff = Math.abs(currSum - target);

                if (currSum == target) {
                    return currSum;
                } else if (currSum < target) {
                    l++;
                } else {
                    r--;
                }

                if (newDiff < diff) {
                    sum = currSum;
                    diff = newDiff;
                }
            }
        }

        return sum;
    }
}
