public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int height = triangle.size();

        if (height == 0) {
            return 0;
        }

        ArrayList<Integer> result = new ArrayList<Integer>(triangle.get(height - 1));

        for (int i = height - 2; i >= 0; i--) {
            ArrayList<Integer> row = triangle.get(i);

            for (int j = 0; j < row.size(); j++) {
                int newVal = row.get(j) + Math.min(result.get(j), result.get(j + 1));
                result.set(j, newVal);
            }
        }

        return result.get(0);
    }
}
