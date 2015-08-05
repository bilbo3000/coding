/**
 * Find the starting point where the car can go around the circle. 
 * The idea was to find the last end point of a segment where the total gas 
 * of that segment is less than the total cost of that segment. 
 */ 
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
        
        int currGas = 0; 
        int currCost = 0; 
        int result = 0; 
        
        for (int i = 0; i < len; i++) {
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
