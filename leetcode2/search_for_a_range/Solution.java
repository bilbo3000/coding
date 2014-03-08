public class Solution {
    public int[] searchRange(int[] A, int target) {
        int len = A.length; 
        
        int index = binarySearch(A, 0, len - 1, target); 
        
        if (index == -1) {
            int[] temp = new int[2]; 
            temp[0] = -1; 
            temp[1] = -1; 
            return temp;
        }
        
        int l = index; 
        int r = index; 
        while (l > 0 && A[l - 1] == A[l]) l--; 
        while (r < len - 1 && A[r] == A[r + 1]) r++; 
        
        int[] result = new int[2]; 
        result[0] = l; 
        result[1] = r; 
        return result; 
    }
    
    public int binarySearch(int[] A, int l, int r, int target) {
        if (l <= r) {
            int mid = (l + r) / 2; 
            
            if (A[mid] == target) return mid; 
            if (A[mid] < target) return binarySearch(A, mid + 1, r, target); 
            return binarySearch(A, l, mid - 1, target); 
        }
        
        return -1; 
    }
}
