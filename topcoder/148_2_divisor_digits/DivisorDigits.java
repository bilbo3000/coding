public class DivisorDigits {
    public int howMany(int number) {
        int temp = number;
        int result = 0;

        while (temp != 0) {
            int digit = temp % 10;
            if (digit != 0) {
                if (number % digit == 0) {
                    result++;
                };
            }
            temp = temp / 10;
        }

        return result;
    }
}
