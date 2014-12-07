public class QuadraticLaw {
    public long getTime(long d) {
        long upper = d;
        long lower = 0;
        long result = 0;

        while (lower <= upper) {
            long mid = (upper + lower) / 2;

            if (Math.pow(mid, 2.0) + mid <= d) {
                result = mid;
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }

        return result;
    }
}
