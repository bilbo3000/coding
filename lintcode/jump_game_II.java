public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     * Dynamic programming. 
     * O(n^2)
     */
    public int jump(int[] A) {
        // write your code here
        int len = A.length; 
        int[] arr = new int[len]; 
        arr[0] = 0; 
        
        int i = 1; 
        
        while (i <= A[0] && i < len){
            arr[i] = 1; 
            i++; 
        }
        
        while (i < len) {
            int j = i - 1; 
            
            while (j >= 0) {
                if (arr[j] != 0 && j + A[j] >= i) {
                    if (arr[i] == 0) {
                        arr[i] = arr[j] + 1; 
                    } else {
                        arr[i] = Math.min(arr[i], arr[j] + 1);
                    }
                }
                j--; 
            }
            
            i++;
        }
        
        return arr[len - 1]; 
    }
}

