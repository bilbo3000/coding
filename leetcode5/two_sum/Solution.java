public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2]; 
        Map<Integer, Integer> m = new HashMap<Integer, Integer>(); 
        
        for (int i = 0; i < numbers.length; i++) {
            m.put(numbers[i], i); 
        }
        
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i]; 
            
            if (m.containsKey(diff) && m.get(diff) != i) {
                result[0] = i + 1; 
                result[1] = m.get(diff) + 1; 
                
                return result; 
            }
        }
        
        return result; 
    }
}
