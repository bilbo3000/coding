public class Solution {
    public int searchInsert(int[] A, int target) {
        return binarySearch(A, 0, A.length - 1, target); 
    }
    
    private int binarySearch(int[] A, int left, int right, int target) {
        if (left > right) {
            return right + 1; 
        }
        
        int mid = (left + right) / 2; 
        
        if (A[mid] == target) {
            return mid; 
        }
        else if (A[mid] < target) {
            return binarySearch(A, mid + 1, right, target); 
        }
        
        else {
            return binarySearch(A, left, mid - 1, target); 
        }
    }
}
