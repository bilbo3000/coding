/*
Determine if possible to jump to last position. 

Keep track of the current left-most reachable position.
If i + nums[i] >= pos, then i becomes the new pos. 

In the end, if final left most reachable position is 0, then 
it is reachable to the end. 

Time: O(n)
Space: O(1)
*/
public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
