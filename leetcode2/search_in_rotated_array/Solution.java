public class Solution {
    public int search(int[] A, int target) {
        int len = A.length; 
        
        if (len == 0) return -1; 
        
        int index = 0; 
        
        while (index < len - 1) {
            if (A[index] > A[index + 1]) {
                break; 
            }
            
            index++; 
        }
        
        if (A[0] <= target) {
            return binarySearch(A, 0, index, target); 
        } 
        else {
            return binarySearch(A, index + 1, len - 1, target); 
        }
    }
    
    int binarySearch(int[] A, int l, int r, int target) {
        if (l <= r) {
            int mid = (l + r) / 2; 
            
            if (A[mid] == target) return mid; 
            if (A[mid] < target) return binarySearch(A, mid + 1, r, target); 
            return binarySearch(A, l, mid - 1, target); 
        }
        
        return -1; 
    }
}
