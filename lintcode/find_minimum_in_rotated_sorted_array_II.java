public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     * 
     * Whenever need to search something in sorted array, think about binary 
     * search. 
     * Maintain two pointers l and r indicates whether the min could fall into 
     * range [l, r]. 
     * 
     * O(logn)
     */
    public int findMin(int[] num) {
        int len = num.length; 
        
        if (num[0] < num[len - 1]) {
            return num[0]; 
        }
        
        int l = 0; 
        int r = len - 1; 
        
        while (l < r) {
            int mid = (l + r) / 2; 
            
            if (num[mid] >= num[0]) {
                l = mid + 1; 
            } else {
                r = mid; 
            }
        }
        
        return num[l]; 
    }
}
