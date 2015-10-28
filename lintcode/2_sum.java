public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     * Store element and its index in a map. For each element, check if 
     * target - numbers[i] is in the map. If yes, store the result and break, 
     * otherwise, store the value and move on. 
     * 
     * O(n) time and O(n) space. 
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2]; 
        Map<Integer, Integer> m = new HashMap<>(); 
        
        for (int i = 0; i < numbers.length; i++) {
            if (m.containsKey(target - numbers[i])) {
                res[0] = m.get(target - numbers[i]) + 1;
                res[1] = i + 1; 
                break; 
            }
            
            m.put(numbers[i], i);
        }
        
        return res; 
    }
}
