/**
 * Given two arrays num1 and num2 where num1 is a subset of num2. 
 * For each element in num1, find the next greater element in num2.
 * 
 * Put all elements in num2 into a hash map, so it's fast to search 
 * num1 elements. For each element in num1, get its corresponding 
 * index in num2 from the map, then search the remainder of num2
 * for a first larger element. 
 * 
 * Time: O(n^2)
 * Space: O(n)
 */ 
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length; 
        int n = nums2.length; 
        
        // A map for nums2 from value to index
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }
        
        int[] res = new int[m];
        
        int i = 0; 
        while (i < m) {
            int n1 = nums1[i]; 
            int index = map.get(n1);
            int j = index + 1; 
            
            while (j < n) {
                if (nums2[j] > n1) {
                    res[i] = nums2[j]; 
                    break; 
                }
                j++; 
            }
            
            if (j == n) {
                res[i] = -1; 
            }
            
            i++; 
        }
        
        return res; 
    }
}
