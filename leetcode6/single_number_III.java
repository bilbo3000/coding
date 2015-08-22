/**
 * Find the two numbers that appear once where other numbers appear exactly twice. 
 * The core idea was to split the numbers into two groups and convert the problem to two sub problem 
 * of finding one single number in each sub group. First XOR all the numbers and get the number t. Then 
 * find the right most 1 in t and use that to filter the numbers into two sub groups where the two numbers
 * must exist one per group. This is because 1 bit means the two numbers have different bit at that position.
 * Then run single number algorithm in each group to find unique number. 
 */ 
public class Solution {
    public int[] singleNumber(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return new int[0]; 
        }
        
        int x = nums[0]; 
        
        for (int i = 1; i < len; i++) {
            x = x ^ nums[i]; 
        }
        
        int temp = 1; 
        
        while (x % 2 == 0) {
            temp = temp << 1; 
            x = x / 2; 
        }
        
        List<Integer> l1 = new ArrayList<>(); 
        List<Integer> l2 = new ArrayList<>(); 
        
        for (int i = 0; i < len; i++) {
            if ((nums[i] & temp) == 0) {
                l1.add(nums[i]);
            } else {
                l2.add(nums[i]);
            }
        }
        
        int[] result = new int[2];
        
        int n1 = 0; 
        int n2 = 0; 
        
        for (int item : l1) {
            n1 = n1 ^ item; 
        }
        
        for (int item : l2) {
            n2 = n2 ^ item; 
        }
        
        result[0] = n1; 
        result[1] = n2; 
        
        return result; 
    }
}
