public class GameOfStones {
    public int count(int[] stones) {
        int sum = 0;
        int len = stones.length;

        for (int i = 0; i < len; i++) {
            sum += stones[i];
        }

        int remainder = sum % len;

        if (remainder != 0) {
            return -1;
        }

        int avg = sum / len;
        int res = 0;

        for (int i = 0; i < len; i++) {
            if (stones[i] > avg) {
                int diff = stones[i] - avg;

                if (diff % 2 != 0) {
                    return -1;
                }

                res += diff / 2;
            }
        }

        return res;
    }
}
