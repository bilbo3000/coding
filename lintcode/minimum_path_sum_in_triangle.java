public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        int n = triangle.length; 
        
        if (n == 0) {
            return 0; 
        }
        
        List<Integer> row = new ArrayList<>(); 

        for (int i = 0; i < triangle[n - 1].length; i++) {
            row.add(triangle[n - 1][i]);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            int[] arr = triangle[i]; 
            
            for (int j = 0; j <= i; j++) {
                row.set(j, Math.min(row.get(j), row.get(j + 1)) + arr[j]);
            }
        }
        
        return row.get(0);
    }
}

