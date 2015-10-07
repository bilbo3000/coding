class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     * 
     * We can solve it in log n because we just need to find one peak. 
     * The idea was to use binary search (hint: log n). Maintain a section 
     * [start, end] where peak could fall into. If element at mid + 1 is larger
     * than at mid, then peak will be in [mid + 1, end]; If element at mid - 1
     * is larger than at mid, then peak will be in [start, mid - 1]. Update 
     * edge of the segment accordingly. 
     * 
     * Another tricky part is that the out condition of the while loop is at 
     * most when start and end right next to each other. Becasue we need to 
     * compare start and end after we jump out of the loop to determine which 
     * one is the peak (we can do this if start and end are the same). 
     * 
     * O(log n)
     */
    public int findPeak(int[] A) {
        // Peak cannot be at two ends, thus start in [1..len - 2]
        int start = 1; 
        int end = A.length - 2; 
        
        while (start + 1 < end) {
            int mid = (start + end) / 2; 
            
            if (A[mid] < A[mid + 1]) {
                start = mid + 1; 
            } else if (A[mid] < A[mid - 1]) {
                end = mid - 1; 
            } else {
                end = mid; 
            }
        }
        
        if (A[start] > A[end]) {
            return start; 
        } else {
            return end; 
        }
    }
}

