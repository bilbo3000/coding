public class Solution {
    public boolean search(int[] A, int target) {
        int len = A.length; 
        
        if (len == 0) {
            return false; 
        }
        
        int index = -1; 
        
        for (int i = 0; i < len - 1; i++) {
            if (A[i] > A[i + 1]) {
                index = i; 
                break; 
            }
        }
        
        if (index == -1) {
            return binarySearch(A, 0, len - 1, target); 
        } else {
            if (A[0] <= target && A[index] >= target) {
                return binarySearch(A, 0, index, target); 
            } else {
                return binarySearch(A, index + 1, len -1, target); 
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
        } else if (A[mid] < target) {
            return binarySearch(A, mid + 1, r, target); 
        } else {
            return binarySearch(A, l, mid - 1, target); 
        }
    }
}
