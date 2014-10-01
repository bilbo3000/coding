public class Solution {
    public boolean search(int[] A, int target) {
        int len = A.length; 
        
        if (len == 0) {
            return false; 
        }
        
        int index = 0; 
        
        for (int i = 1; i < len; i++) {
            if (A[i] < A[i - 1]) {
                index = i; 
                break; 
            }
        }
        
        if (index == 0) {
            return binarySearch(A, 0, len - 1, target); 
        } else {
            if (target >= A[0]) {
                return binarySearch(A, 0, index - 1, target); 
            } else {
                return binarySearch(A, index, len - 1, target); 
            }
        }
    }
    
    private boolean binarySearch(int[] A, int l, int r, int target) {
        if (l > r) {
            return false; 
        }
        
        int mid = (l + r) / 2; 
        
        if (A[mid] == target) {
            return true; 
        } else if (A[mid] > target) {
            return binarySearch(A, l, mid - 1, target); 
        } else {
            return binarySearch(A, mid + 1, r, target); 
        }
    }
}
