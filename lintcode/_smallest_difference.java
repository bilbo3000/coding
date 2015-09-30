public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     * 
     * Find the smallest difference between two arrays. 
     * The core idea was that for an element in the first array, the min has to 
     * occur in the abs diff between that last smaller element and the first 
     * larger element. The reason is that all elements before the last smaller 
     * element and all elements that are after the first larger element would 
     * only increase the abs diff. 
     * 
     * Second tricky part is that if both arrays are sorted, we can reduct the 
     * algorithm from O(n^2) down to O(nlogn). Becasue A will be increasing, 
     * thus B will start where it left off each time rather than start from 
     * the beginning. 
     * 
     * O(nlogn)
     */
    public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int res = Integer.MAX_VALUE;
        int j = 0; 
        
        for (int a : A) {
            while (j < B.length - 1 && B[j + 1] <= a) {
                j++; 
            }
            
            // At this point, B[j] <= a, and B[j + 1] > a, 
            // The min diff to 'a' could *only* come from these 
            // two numbers. 
            res = Math.min(res, Math.abs(B[j] - a));
            
            if (j + 1 < B.length) {
                res = Math.min(res, Math.abs(B[j + 1] - a));
            }
        }
        
        return res; 
    }
}

