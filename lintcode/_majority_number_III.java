public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     * 
     * Find majority element that is more than 1/k of the size of the array. 
     * Similar approach as previous majority element problems, there are at 
     * most k - 1 candidates. An incoming element will increase its count if 
     * it is a candiate. Otherwise it will be a candiate if there are less 
     * than k - 1 candidates, otherwise, it will need to cancel every candidates
     * and remove the ones that become zero count. 
     * 
     * O(n) time and O(k) space. 
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // At most k - 1 candidates 
        Map<Integer, Integer> m = new HashMap<>(); 
        
        for (int n : nums) {
            if (!m.containsKey(n)) {
                m.put(n, 1);
            } else {
                m.put(n, m.get(n) + 1);
            }
            
            if (m.size() >= k) {
                // We do this because we can at most have k - 1 candiates
                remove(m);
            }
        }
        
        // Reset counter 
        for (int key : m.keySet()) {
            m.put(key, 0); 
        }
        
        int maxKey = 0; 
        int maxCount = 0; 
        
        for (int n : nums) {
            if (m.containsKey(n)) {
                m.put(n, m.get(n) + 1);
                
                if (m.get(n) > maxCount) {
                    maxKey = n; 
                    maxCount = m.get(n); 
                }
            }
        }
        
        return maxKey; 
    }
    
    private void remove(Map<Integer, Integer> m) {
        Set<Integer> keys = m.keySet(); 
        List<Integer> temp = new ArrayList<>(); 
        
        for (int key : keys) {
            m.put(key, m.get(key) - 1);
            
            if (m.get(key) == 0) {
                temp.add(key);
            }
        }
        
        // Remove candiate that has count zero
        for (int key : temp) {
            m.remove(key);
        }
    }
}

