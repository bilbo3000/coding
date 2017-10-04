/*
Find the median of two sorted arrays. Time complexity should be O(log(m + n))

See log(m + n) + sorted --> binary search type of algorithm. 
Convert the problem to find the kth element in an array for the given index. 

if m + n is odd --> the middle element
if m + n is even --> the average of middle two elements

This problem borrows idea from binary search, where it tries to discard "half" of
the candidates. --> that's the core idea behind binary search. 

The algorithm index nums1 and nums2 at k/2 respectively. 
(NEED TO ADJUST TO THE CASES WHERE EITHER ARRAY LENGTH IS LESS THAN K/2)

1) If nums1[i] == nums2[j] --> return either number; 
2) If nums1[i] > nums2[j] --> we can guarentee that nums2[j] and elements prior to it must include,
and thus can be excluded from the search; we continue the search on the same segment of nums1 and 
nums2[j + 1] and beyond for (k - discarded length)th element; 
3) If nums1[i] < nums2[j] --> we are guarentee that nums1[i] and elements prior to it must include, 
and thus can be excluded from the search; we continue the search on the same segment of nums2 and 
nums1[i + 1] and beyong for (k - discarded length) the element; 

Time complexity: O(log(m + n))
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length; 
        int len2 = nums2.length; 
        int totalLength = len1 + len2; 
        
        if (totalLength % 2 == 0) {
            // m + n is even number 
            return (findMedianHelper(nums1, nums2, 0, 0, totalLength / 2) + findMedianHelper(nums1, nums2, 0, 0, totalLength / 2 + 1)) / 2.0;
        } else {
            // m + n is odd number 
            return findMedianHelper(nums1, nums2, 0, 0, totalLength / 2 + 1);
        }
    }
    
    // i, j are starting point in the two arrays respectively
    private double findMedianHelper(int[] nums1, int[] nums2, int i, int j, int k) {
        if (k <= 0) {
            return 0.0; 
        }
        
        if (i >= nums1.length) {
            return (double)nums2[j + k - 1];
        }
        
        if (j >= nums2.length) {
            return (double)nums1[i + k - 1]; 
        }
        
        if (k == 1) {
            if (nums1[i] < nums2[j]) {
                return (double)nums1[i];
            } else {
                return (double)nums2[j]; 
            }
        }
        
        int offset1 = k / 2; 
        int offset2 = k - offset1; 
        int index1 = i + offset1 - 1; 
        int index2 = j + offset2 - 1; 
        
        if (index1 >= nums1.length) {
        	index1 = nums1.length - 1; 
        	index2 = j + k - index1 + i - 2;
        } else if (index2 >= nums2.length) {
        	index2 = nums2.length - 1; 
        	index1 = i + k - index2 +j - 2;
        }
        
        
        if (nums1[index1] == nums2[index2]) {
            return (double)nums1[index1]; 
        }
        
        if (nums1[index1] > nums2[index2]) {
            return findMedianHelper(nums1, nums2, i, index2 + 1, k - (index2 - j + 1));
        } else {
            return findMedianHelper(nums1, nums2, index1 + 1, j, k - (index1 - i + 1));
        }
    }
}
