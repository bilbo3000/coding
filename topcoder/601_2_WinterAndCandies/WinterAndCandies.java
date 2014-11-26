public class WinterAndCandies {
    public int getNumber(int[] type) {
        int len = type.length;
        int result = 0;
        int[] ca = new int[50];

        for (int i = 0; i < len; i++) {
            int index = type[i] - 1;
            ca[index]++;
        }

        result = ca[0];
        int prev = ca[0];

        for (int k = 1; k < len; k++) {
            if (ca[k] == 0) {
                break;
            }

            prev = ca[k] * prev;
            result += prev;
        }

        return result;
    }
}
