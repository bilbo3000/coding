public class Solution {
    public int[] searchRange(int[] A, int target) {
        int index = binarySearch(A, 0, A.length - 1, target);
        
        int[] result = new int[2];
        
        if (index == -1) {
            result[0] = -1; 
            result[1] = -1; 
        } else {
            int l = index; 
            int r = index; 
            
            while (l > 0 && A[l] == A[l - 1]) {
                l--; 
            }
            
            while (r < A.length - 1 && A[r] == A[r + 1]) {
                r++; 
            }
            
            result[0] = l; 
            result[1] = r; 
        }
        
        return result; 
    }
    
    private int binarySearch(int[] A, int l, int r, int target) {
        if (l > r) {
            return -1; 
        }
        
        int mid = (l + r) / 2; 
        
        if (A[mid] == target) {
            return mid; 
        }
        
        if (A[mid] < target) {
            return binarySearch(A, mid + 1, r, target); 
        } else {
            return binarySearch(A, l, mid - 1, target); 
        }
    }
}
