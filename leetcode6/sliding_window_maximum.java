/**
 * Sliding a window with fix size from left to right. 
 * Use a linked list to simulate the window to store index. For each new element, first compare its index with the 
 * left most element in the linked list to determine whether to remove the left element out of the window. Also, 
 * an optimization is that for each new element, it can clear all the elements that are not larger than it in the 
 * window to reduce the number of comparision since they can never be the largest in the winow. Track and store the 
 * maximum value for each window accordingly. 
 */ 
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[0]; 
        }
        
        List<Integer> list = new ArrayList<>(); 
        int max = nums[0]; 
        int len = nums.length; 
        int[] result = new int[len - k + 1]; 
        int index = 0; 
        
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i]; 
            }
            
            list.add(i);
        }
        
        result[index] = max; 
        index++; 
        
        for (int i = k; i < len; i++) {
            if (list.size() != 0 && i - list.get(0) >= k) {
                // Remove first element 
                list.remove(0);
            }
            
            int maxx = nums[i]; 
            
            for (int j = list.size() - 1; j >= 0; j--) {
                if (nums[list.get(j)] > maxx) {
                    maxx = nums[list.get(j)];
                } else {
                    list.remove(j);
                }
            }
            
            list.add(i);
            result[index] = maxx; 
            index++; 
        }
        
        return result; 
    }
}
