class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        int last = -1; // last negative 
        int len = A.length; 
        
        if (len <= 1) {
            return; 
        }
        
        boolean moreNeg = false; 
        
        for (int i = 0; i < len; i++) {
            if (A[i] < 0) {
                last++; 
                swap(A, last, i); 
            }
        }
        
        if (len % 2 != 0 && last == len / 2) {
            moreNeg = true; 
            
            int i = 0; 
            int j = len - 1; 
            
            while (i < j) {
                swap(A, i, j);
                i++; 
                j--; 
            }
        }
        
        if (moreNeg) {
            int i = 0; 
            int j = last; 
            
            while (i < j && j < len && A[i] > 0) {
                swap(A, i, j);
                i = i + 2; 
                j++; 
            }
        } else {
            int i = 0; 
            int j = last + 1; 
            
            while (i < j && j < len && A[i] < 0) {
                swap(A, i, j);
                i = i + 2; 
                j++; 
            }
        }
   }
   
   private void swap(int[] A, int l, int r) {
       int temp = A[l]; 
       A[l] = A[r]; 
       A[r] = temp; 
   }
}
