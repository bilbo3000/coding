class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     * 
     * Solve is recursively. 
     * Find the peak for a row. If that's the peak, then return. Otherwise, find 
     * the larger neighbor and recursive on that row. (or could further binary
     * cut in that half)
     * 
     * O(nlogn)
     */
    public List<Integer> findPeakII(int[][] A) {
        List<Integer> result = new ArrayList<>(); 
        int m = A.length; 
        int n = A[0].length; 
        int row = m / 2;
        boolean find = false; 
        
        while (!find) {
            int col = findMax(row, A);
            
            // Find a peak
            if (A[row][col] > A[row - 1][col] && A[row][col] > A[row][col + 1]
            && A[row][col] > A[row + 1][col] && A[row][col] > A[row][col - 1]) {
                result.add(row);
                result.add(col);
                
                return result; 
            }
            
            if (A[row][col] < A[row - 1][col]) {
                row--; 
            } else {
                row++; 
            }
        }
        
        return result; 
    }
    
    // Find a peak in a given row
    private int findMax(int row, int[][] A) {
        int index = 0; 
        
        for (int j = 1; j < A[row].length; j++) {
            if (A[row][j] > A[row][index]) {
                index = j; 
            }
        }
        
        return index; 
    }
}

