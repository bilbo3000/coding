public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2]; 
        int len = A.length; 
        
        int index = binarySearch(A, 0, len - 1, target);
        
        if (index == -1) {
            result[0] = -1; 
            result[1] = -1; 
            return result; 
        }
        
        int l = index - 1; 
        int r = index + 1; 
        
        while (l >= 0 && A[l] == A[index]) {
            l--;
        }
        
        while (r < len && A[r] == A[index]) {
            r++; 
        }
        
        result[0] = l + 1; 
        result[1] = r - 1; 
        return result; 
    }
    
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
