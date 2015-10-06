public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     * 
     * O(log n)
     */
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2]; 
        result[0] = -1; 
        result[1] = -1; 
        
        int l = 0; 
        int r = A.length - 1; 
        
        while (l <= r) {
            int mid = (l + r) / 2; 
            
            if (A[mid] == target) {
                int a = mid; 
                
                while (a > 0 && A[a] == A[a - 1]) {
                    a--; 
                }
                
                int b = mid; 
                
                while (b < A.length - 1 && A[b] == A[b + 1]) {
                    b++; 
                }
                
                result[0] = a; 
                result[1] = b; 
                
                return result; 
            } 
            
            if (A[mid] < target) {
                l = mid + 1; 
            } else {
                r = mid - 1; 
            }
        }
        
        return result; 
    }
}

