public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length; 
        
        if (n == 0) {
            return 0; 
        }
        
        int totalGas = 0;
        int totalCost = 0; 
        
        for (int i = 0; i < n; i++) {
            totalGas += gas[i]; 
            totalCost += cost[i]; 
        }
        
        if (totalCost > totalGas) {
            return -1; 
        }
        
        int currIndex = 0; 
        int currGas = 0;
        int currCost = 0; 
        
        for (int i = 0; i < n; i++) {
            currGas += gas[i]; 
            currCost += cost[i]; 
            
            if (currCost > currGas) {
                currGas = 0; 
                currCost = 0; 
                currIndex = i + 1; 
            }
        }
        
        return currIndex; 
    }
}
