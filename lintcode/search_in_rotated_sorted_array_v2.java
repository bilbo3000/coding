public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     * 
     * O(n)
     */
    public int search(int[] A, int target) {
        int l = 0; 
        int r = A.length - 1; 
        
        while (l <= r) {
            int mid = (l + r) / 2; 

            if (A[mid] == target) {
                return mid; 
            }
            else {
                if (A[l] <= A[mid]) {
                    // Fall into the first section 
                    if (target >= A[l] && target < A[mid]) {
                        r = mid - 1; 
                    } else {
                        l = mid + 1; 
                    }
                } else {
                    // Fall into the second section 
                    if (target > A[mid] && target <= A[r]) {
                        l = mid + 1; 
                    } else {
                        r = mid - 1; 
                    }
                }
            }
        }
        
        return -1; 
    }
}

