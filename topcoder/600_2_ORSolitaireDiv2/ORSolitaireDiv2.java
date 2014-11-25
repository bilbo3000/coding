public class ORSolitaireDiv2 {
    public int getMinimum(int[] numbers, int goal) {
        int len = numbers.length;

        int[][] numberBits = new int[len][32];
        int[] goalBits = new int[32];
        int[] tempBits = new int[32];
        int x = 0;

        while (goal != 0) {
            goalBits[x] = goal % 2;
            goal = goal / 2;
            x++;
        }

        for (int i = 0; i < len; i++) {
            int digit = numbers[i];
            int pos = 0;

            while (digit != 0) {
                int bit = digit % 2;
                numberBits[i][pos] = bit;
                digit = digit / 2;
                pos++;
            }

            boolean add = true;

            for (int index = 0; index < 32; index++) {
                if (goalBits[index] == 0 && numberBits[i][index] != 0) {
                    add = false;
                    break;
                }
            }

            if (add) {
                for (int index = 0; index < 32; index++) {
                    tempBits[index] += numberBits[i][index];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 32; i++) {
            if (goalBits[i] == 1 && tempBits[i] < min) {
                min = tempBits[i];
            }
        }

        if (min == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min;
        }
    }
}
