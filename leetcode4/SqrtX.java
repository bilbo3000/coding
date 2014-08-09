public class Solution {
    public int sqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }

        long prevBase = 1;
        long currBase = 2;

        while (currBase * currBase < x) {
            prevBase = currBase;
            currBase *= 2;
        }

        return (int) binarySearch(prevBase, currBase, x);
    }

    private long binarySearch(long l, long r, long target) {
        if (l > r) {
            return r;
        }

        long mid = (l + r) / 2;

        if (mid * mid == target) {
            return mid;
        } else if (mid * mid < target) {
            return binarySearch(mid + 1, r, target);
        } else {
            return binarySearch(l, mid - 1, target);
        }
    }
}
