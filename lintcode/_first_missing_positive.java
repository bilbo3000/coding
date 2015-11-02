public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     * 
     * Swap number to its right position (if possible). i.e. 1->0, 2->1, ...
     * O(n)
     */
    public int firstMissingPositive(int[] A) {
        int len = A.length; 
        int i = 0; 
        
        while (i < len) {
            if (A[i] > 0 && A[i] - 1 != i && A[i] - 1 < len && A[A[i] - 1] != A[i]) {
                swap(A, i, A[i] - 1);
                i--; 
            }
            
            i++; 
        }
        
        int j = 0; 
        
        while (j < len) {
            if (A[j] - 1 != j) {
                return j + 1; 
            }
            
            j++; 
        }
        
        return j + 1; 
    }
    
    private void swap(int[] A, int l, int r) {
        int temp = A[l]; 
        A[l] = A[r]; 
        A[r] = temp; 
    }
}
