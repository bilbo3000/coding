public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     * 
     * O(log n)
     */
    public int searchInsert(int[] A, int target) {
        int len = A.length; 
        int l = 0; 
        int r = len - 1; 
        
        while (l <= r) {
            int mid = (l + r) / 2; 
            
            if (A[mid] == target) {
                return mid; 
            }
            
            if (A[mid] > target) {
                r = mid - 1; 
            } else {
                l = mid + 1;
            }
        }
        
        return l; 
    }
}

