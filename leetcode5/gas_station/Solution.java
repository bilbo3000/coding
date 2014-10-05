public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length; 

        if (n == 0) {
            return -1; 
        }
        
        int totalGas = 0; 
        int totalCost = 0;
        
        for (int item : gas) {
            totalGas += item; 
        }
        
        for (int item : cost) {
            totalCost += item; 
        }
        
        if (totalCost > totalGas) {
            return -1; 
        }
        
        int result = 0; 
        int currGas = 0; 
        int currCost = 0; 
        
        for (int i = 0; i < n; i++) {
            if ((currGas + gas[i]) < (currCost + cost[i])) {
                result = i + 1; 
                currGas = 0; 
                currCost = 0; 
            } else {
                currGas += gas[i]; 
                currCost += cost[i]; 
            }
        }
        
        return result; 
    }
}
