/**
 * Merge two sorted array. 
 * The idea was to traverse the two arrays with three pointers. Note 
 * that if second array is exhausted, not need to do anything because 
 * first array already in place. However, if first array is exhausted, 
 * need to copy over element from second array to the first array. 
 */ 
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; 
        int j = n - 1; 
        int k = m + n - 1; 
        
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i]; 
                i--; 
            } else {
                nums1[k] = nums2[j]; 
                j--; 
            }
            
            k--; 
        }
        
        while (j >= 0) {
            nums1[k] = nums2[j]; 
            j--; 
            k--;
        }
    }
}
