/*
Search for range of the given element in a sorted array -- O(logn). 

The idea was to binary search twice. One to search for left bondary and one 
for search for the right boundary. 

The tricky part is: 
1) when search for the left, use mid = (i + j) / 2, where mid is bias towards left, 
so j will always move --> move towards left when nums[mid] == target; 
2) when search for the right, use mid = (i + j) / 2 + 1, where mid is bias towards right, 
so i will always move --> move towards right when nums[mid] == target; 

Bottom line is we don't want to get stuck when nums[mid] == target; 

Time: O(logn)
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        
        int i = 0; 
        int j = nums.length - 1; 
        
        // Find the left bounary
        while (i < j) {
            int mid = (i + j) / 2; 
            
            if (nums[mid] < target) {
                i = mid + 1; 
            } else if (nums[mid] > target) {
                j = mid - 1; 
            } else {
                j = mid; // Mid will not equal to j --> the range won't stuck
            }
        }
        
        if (nums[i] != target) {
            return new int[] {-1, -1}; 
        }
        int left = i; 
        
        j = nums.length - 1; 
        
        // Find the right boundary
        while (i < j) {
            int mid = (i + j) / 2 + 1; 
            
            if (nums[mid] < target) {
                i = mid + 1; 
            } else if (nums[mid] > target) {
                j = mid - 1; 
            } else {
                i = mid; // Mid will not equal to i --> the range won't stuck
            }
        }
        
        return new int[] {left, j};
    }
    
}
