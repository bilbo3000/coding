public class AliceGameEasy {
    private long min = Long.MAX_VALUE;
    private boolean found = false; 

    public  long findMinimumValue(long x, long y) {
        helper(x, y, 1, 0);

        if (!found) {
            return -1; 
        }
        
        return min;
    }

    private void helper(long x, long y, int curr, int cnt) {
        System.out.println(" " + x + " " + y + " ");
        if (x == 0 && y == 0) {
            found = true; 
            min = Math.min(min, cnt);
            return;
        }

        if (x < 0 || y < 0) {
            return;
        }

        if (x >= curr) {
            helper(x - curr, y, curr + 1, cnt + 1);
        }

        if (y >= curr) {
            helper(x, y - curr, curr + 1, cnt);
        }
    }
}
