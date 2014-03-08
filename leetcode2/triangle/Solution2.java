public class Solution2 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int h = triangle.size();
        ArrayList<Integer> p = new ArrayList<Integer>(Collections.nCopies(h + 1, 0));

        while (h > 0) {
            h--;

            for (int i = 0; i <= h; i++) {
                int item = triangle.get(h).get(i);
                p.set(i, item + Math.min(p.get(i), p.get(i + 1)));
            }
        }

        return p.get(0);
    }
}
