/**
 * Given a circular array. Find the next greater element for each element. 
 * 
 * The core idea was to use a stack to track the index of descreasing sequence. 
 * Everything in the stack is pending to have next greater element, thus after 
 * walk though the first round, need to walk through the second around because 
 * of circular array and some elements left in the stack may have their next 
 * greater element in the front of the queue. 
 * 
 * Time: O(n), each element is popped at most once 
 * Space: O(n), the stack
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length; 
        int[] res = new int[len]; 
        Arrays.fill(res, -1);
        Stack<Integer> s = new Stack<>(); // Stack to track the index of descreasing index
        
        for (int i = 0; i < len * 2; i++) {
            int temp = nums[i % len];
            
            while (!s.isEmpty() && nums[s.peek()] < temp) {
                res[s.pop()] = temp; 
            }
            
            s.add(i % len);
        }
        
        return res; 
    }
}
