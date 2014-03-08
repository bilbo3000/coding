public class Solution {
    public int searchInsert(int[] A, int target) {
        int left = 0; 
        int right = A.length - 1; 
        
        while (left <= right) {
            int mid = (left + right) / 2; 
            
            if (A[mid] == target) {
                return mid; 
            }
            else if (A[mid] < target) {
                left = mid + 1; 
            }
            else {
                right = mid - 1; 
            }
        }
        
        return right + 1; 
    }
}
