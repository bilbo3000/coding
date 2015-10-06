public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     * 
     * O(n)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0; 
        int totalCost = 0; 
        int len = gas.length; 
        
        for (int i = 0; i < len; i++) {
            totalGas += gas[i]; 
            totalCost += cost[i]; 
        }
        
        if (totalCost > totalGas) {
            // Can't go around
            return -1; 
        }
        
        int result = 0; 
        int currGas = 0; 
        int currCost = 0;
        
        for (int i = 0; i < len; i++) {
            currGas += gas[i]; 
            currCost += cost[i]; 
            
            if (currGas < currCost) {
                currGas = 0; 
                currCost = 0;
                result = i + 1; 
            }
        }
        
        return result; 
    }
}
