/**
 * Find the majority element that appear more than n/3 times. 
 * The core idea was that there are at most two elements that appear more than n/3 times. 
 * Thus we need to have two candidates n1, n2 and two counts c1, c2. The core idea was 
 * that a candidate will increase its count. Non candidate will reduct both candidates 
 * count. An element will become a candidate if there is any empty candidate "seat". 
 * The candidate with majority number will eventually fight the way up and grap a "seat". 
 */ 
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n1 = 0; 
        int n2 = 0; 
        int c1 = 0; 
        int c2 = 0; 
        int len = nums.length; 
        
        for (int i = 0; i < len; i++) {
            if (n1 == nums[i]) {
                c1++; 
            } else if (n2 == nums[i]) {
                c2++; 
            } else if (c1 == 0) {
                n1 = nums[i]; 
                c1 = 1; 
            } else if (c2 == 0) {
                n2 = nums[i];
                c2 = 1; 
            } else {
                c1--;
                c2--; 
            }
        }
        
        c1 = 0; 
        c2 = 0; 
        
        for (int i = 0; i < len; i++) {
            if (nums[i] == n1) {
                c1++; 
            } else if (nums[i] == n2) {
                c2++;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>(); 
        
        if (c1 > len / 3) {
            result.add(n1);
        }
        
        if (c2 > len / 3) {
            result.add(n2);
        }
        
        return result; 
    }
}
