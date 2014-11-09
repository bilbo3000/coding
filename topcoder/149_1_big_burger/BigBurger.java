public class BigBurget {
    public int maxWait(int[] arrival, int[] service) {
        int max = 0;
        int currWait = 0;
        int len = arrival.length;

        if (len == 0) {
            return max;
        }

        for (int i = 1; i < len; i++) {
            int time = currWait + service[i - 1] + arrival[i - 1];
            currWait = time - arrival[i];
            max = Math.max(max, currWait);
        }

        return max;
    }
}
