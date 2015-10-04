public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     * 
     * O(lgn)
     */
    public void heapify(int[] A) {
        // if n is child index, parent index is (n - 1) / 2
        int len = A.length; 
        for (int i = (len - 2) / 2; i >= 0; i--) {
            int min = i; 
            int k = min;
            
            do {
                k = min;
                if ((2 * k + 1 < len) && A[2 * k + 1] < A[k]) {
                    min = 2 * k + 1; 
                }
                
                if ((2 * k + 2 < len) && A[2 * k + 2] < A[min]) {
                    min = 2 * k + 2; 
                }
                
                if (k != min) {
                    swap(A, k, min);
                }
            } while(k != min);
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i]; 
        A[i] = A[j]; 
        A[j] = temp; 
    }
}
