/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     * 
     * Binary search approach. 
     * O(lgn)
     */
    public int findFirstBadVersion(int n) {
        return helper(1, n);
    }
    
    private int helper(int l, int r) {
        if (l >= r) {
            // Yes, always return l
            return l; 
        }
        
        int mid = (l + r) / 2;
        
        if (!VersionControl.isBadVersion(mid)) {
            l = mid + 1;
        } else {
            r = mid;
        }
        
        return helper(l, r);
    }
}

