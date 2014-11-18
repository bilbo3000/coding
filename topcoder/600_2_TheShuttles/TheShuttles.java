import java.util.Arrays;

public class TheShuttles {
    public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(cnt);
        int len = cnt.length;

        if (len > 0) {
            int min = cnt[0];
            int max = cnt[len - 1];

            for (int x = min; x <= max; x++) {
                int temp = 0;

                for (int i = 0; i < len; i++) {
                    int n = (int) Math.ceil((cnt[i] * 1.0) / x);
                    temp += n * (baseCost + x * seatCost);
                }

                result = Math.min(result, temp);
            }
        }
        return result;
    }
}
