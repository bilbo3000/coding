public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0; 
        int totalGas = 0; 
        int totalCost = 0; 
        int currGas = 0; 
        int currCost = 0; 
        int n = gas.length; 
        
        for (int i = 0; i < n; i++) {
            totalGas += gas[i]; 
            totalCost += cost[i]; 
        }
        
        if (totalGas < totalCost) {
            return -1; 
        }
        
        for (int i = 0; i < n; i++) {
            currGas += gas[i]; 
            currCost += cost[i]; 
            
            if (currGas < currCost) {
                currGas = 0; 
                currCost = 0; 
                start = i + 1; 
            }
        }
        
        return start; 
    }
}
