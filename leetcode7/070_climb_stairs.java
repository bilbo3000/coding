/*
Climb stairs -- either climb one stair at a time or climb two stairs at a time. 

To get to current stair, either from previous stair or from previous two stairs. 
Add those two to get the number to get to current stair. 

Time: O(n)
Space: O(1)
*/
class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n; 
        }
        
        int prev1 = 2; 
        int prev2 = 1; 
        int result = 0; 
        for (int i = 3; i <= n; i++) {
            result = prev1 + prev2; 
            prev2 = prev1; 
            prev1 = result;
        }
        
        return result; 
    }
}
