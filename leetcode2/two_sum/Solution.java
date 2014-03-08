public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> mapping = new HashMap<Integer, Integer>(); 
        int[] result = new int[2]; 
        
        for (int i = 0; i < numbers.length; i++) {
            mapping.put(numbers[i], i); 
        }
        
        for (int i = 0; i < numbers.length; i++) {
            int remain = target - numbers[i]; 
            
            if (mapping.get(remain) != null) {
                int j = mapping.get(remain); 
                
                if (j < i) {
                    result[0] = j + 1; 
                    result[1] = i + 1; 
                }
                else {
                    result[0] = i + 1;
                    result[1] = j + 1; 
                }
                
                break; 
            }
        }
        
        return result; 
    }
}
