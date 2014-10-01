public class Solution {
    public int search(int[] A, int target) {
        int len = A.length; 
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
    
    private int binarySearch(int[] A, int l, int r, int target) {
        if (l > r) {
            return -1; 
        }
        
        int mid = (l + r) / 2; 
        
        if (A[mid] == target) {
            return mid; 
        }
        
        if (A[mid] > target) {
            return binarySearch(A, l, mid - 1, target); 
        } else {
            return binarySearch(A, mid + 1, r, target); 
        }
    }
}
