public class TypoCoderDiv2 {
    public int count(int[] rating) {
        int result = 0;
        int len = rating.length;

        if (rating[0] >= 1200) {
            result++;
        }

        for (int i = 1; i < len; i++) {
            if (rating[i - 1] < 1200 && rating[i] >= 1200 || rating[i - 1] >= 1200 && rating[i] < 1200) {
                result++;
            }
        }

        return result;
    }
}
