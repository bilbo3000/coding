public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> src = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            src.add(i);
        }

        return helper(k, src);
    }

    private String helper(int k, List<Integer> src) {
        if (k == 1) {
            String result = "";

            for (int item : src) {
                result += Integer.toString(item);
            }

            return result;
        }

        int groupCnt = factorial(src.size() - 1);
        int m = (int) Math.ceil(k / (double)groupCnt);
        int digit = src.get(m - 1);
        src.remove(m - 1);
        return Integer.toString(digit) + helper(k - groupCnt * (m - 1), src);
    }

    private int factorial(int n) {
        if (n == 0) {
            return n;
        }

        int result = 1;

        for (int i = n; i > 0; i--) {
            result *= i;
        }

        return result;
    }
}
