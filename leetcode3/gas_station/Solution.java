public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0; 
        int totalCost = 0; 
        int len = gas.length; 
        
        for (int i = 0; i < len; i++) {
            totalGas += gas[i]; 
            totalCost += cost[i]; 
        }
        
        if (totalGas < totalCost) {
            return -1; 
        }
        
        int result = 0; 
        int currGas = gas[0]; 
        int currCost = cost[0]; 
        
        for (int i = 1; i < len; i++) {
            if (currGas >= currCost) {
                currGas += gas[i]; 
                currCost += cost[i]; 
            }
            else {
                result = i; 
                currGas = gas[i]; 
                currCost = cost[i]; 
            }
        }
        
        return result; 
    }
}
