public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>(); 
        int len = numbers.length; 
        
        for (int i = 0; i < len; i++) {
            m.put(numbers[i], i); 
        }
        
        int[] result = new int[2]; 
        result[0] = -1; 
        result[1] = -1; 
        
        for (int i = 0; i < len; i++) {
            int key = target - numbers[i]; 
            
            if (m.containsKey(key) && m.get(key) != i) {
                result[0] = i + 1; 
                result[1] = m.get(key) + 1; 
                return result; 
            }
        }
        
        return result; 
    }
}
