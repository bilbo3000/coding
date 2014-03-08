public class Solution {
    public int search(int[] A, int target) {
        int len = A.length; 
        
        if (len == 0) {
            return -1; 
        }
        
        int i = 0; 
        
        while (i < len - 1 && A[i] < A[i + 1]) {
            i++; 
        }

        if (A[i] >= target && A[0] <= target) {
            return binarySearch(A, 0, i, target); 
        }
        else {
            return binarySearch(A, i + 1, len - 1, target);
        }
    }
    
    private int binarySearch(int[] A, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2; 
            if (A[mid] == target) {
                return mid; 
            }
            else if (A[mid] > target) {
                r--; 
            }
            else {
                l++; 
            }
        }
        
        return -1; 
    }
}
