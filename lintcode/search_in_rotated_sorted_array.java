public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     * 
     * O(n)
     */
    public int search(int[] A, int target) {
        // write your code here
        int index = 0; 
        int len = A.length; 
        
        for (int i = 1; i < len; i++) {
            if (A[i] < A[i - 1]) {
                index = i; 
                break; 
            }
        }
        
        if (index == 0) {
            // No rotation
            return binarySearch(A, 0, len - 1, target);
        } else {
            if (target >= A[0]) {
                return binarySearch(A, 0, index - 1, target);
            } else {
                return binarySearch(A, index, len - 1, target);
            }
        }
    }
    
    // O(logn)
    private int binarySearch(int[] A, int l, int r, int target) {
        if (l > r) {
            return -1; 
        }
        
        int mid = (l + r) / 2; 
        
        if (A[mid] == target) {
            return mid; 
        } else if (A[mid] < target) {
            return binarySearch(A, mid + 1, r, target);
        } else {
            return binarySearch(A, l, mid - 1, target);
        }
    }
}

