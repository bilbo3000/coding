public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        Arrays.sort(numbers);
        int len = numbers.length; 
        int result = Integer.MAX_VALUE; 
        int diff = Integer.MAX_VALUE; 
        
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1; 
            int r = len - 1; 
            
            while (l < r) {
                int sum = numbers[i] + numbers[l] + numbers[r]; 
                int temp = Math.abs(sum - target);
                
                if (temp < diff) {
                    result = sum; 
                    diff = temp; 
                }
                
                if (sum == target) {
                    break; 
                } else if (sum > target) {
                    r--; 
                } else {
                    l++; 
                }
            }
        }
        
        return result; 

    }
}

