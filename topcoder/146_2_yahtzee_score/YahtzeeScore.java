public class YahtzeeScore {
    public int maxPoints(int [] toss) {
        int max = 0;
        int[] arr = new int[6];

        for (int i = 0; i < toss.length; i++) {
            arr[toss[i] - 1]++;
            max = Math.max(max, toss[i] * arr[toss[i] - 1]);
        }

        return max;
    }
}
