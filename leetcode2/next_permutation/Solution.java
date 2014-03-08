public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length;

        int i = len - 2;

        while (i >= 0 && num[i] >= num[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = len - 1;

            while (j > i && num[j] <= num[i]) {
                j--;
            }

            if (j > i) {
                int temp = num[j];
                num[j] = num[i];
                num[i] = temp;
            }
        }

        Arrays.sort(num, i + 1, len);
    }
}
