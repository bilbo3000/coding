public class Solution {
    public boolean search(int[] A, int target) {
        int len = A.length; 
        
        if (len == 0) return false; 
        
        int i = 0; 
        
        while (i < len - 1) {
            if (A[i] > A[i + 1]) break; 
            
            i++; 
        }
        
        if (A[0] <= target) {
            return binarySearch(A, 0, i, target); 
        }
        else {
            return binarySearch(A, i + 1, len - 1, target); 
        }
    }
    
    boolean binarySearch(int[] A, int l, int r, int target) {
        if (l <= r) {
            int mid = (l + r) / 2; 
            
            if (A[mid] == target) return true; 
            if (A[mid] < target) return binarySearch(A, mid + 1, r, target); 
            return binarySearch(A, l, mid - 1, target); 
        }
        
        return false; 
    }
}
