import java.util.Arrays;

public class WinterAndMandarins {
    public int getNumber(int[] bags, int K) {
        int result = Integer.MAX_VALUE;
        int len = bags.length;
        Arrays.sort(bags);

        for (int i = 0; i <= len - K; i++) {
            int l = bags[i];
            int r = bags[i + K - 1];

            result = Math.min(result, r - l);
        }

        return result;
    }
}
