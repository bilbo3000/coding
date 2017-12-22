/**
 * Given a knapsack of a fix capacity and a list of items with value and weight. 
 * Find the optimal list of items that can fit into the knapsack with maximum value.
 * 
 * Solve it using DP. T[i][j] represents the maximum value considering first ith items
 * and capacity j. 
 * 
 * During iteration, if ith item cannot even fit into capacity j
 * --> T[i][j] = T[i - 1][j] (Do not use ith item, capacity unchanged); 
 * Otherwise choose the max of choosing and not choosing ith item: 
 * --> T[i][j] = max(T[i - 1][j - capacity_of_i] + value_of_i, T[i - 1][j]);
 */ 
public class Solution {
	
    public int knapsack(List<Item> items, int capacity) {
    	int length = items.size(); 
    	
    	// Solve it using DP. 
    	// T[i][j], the optimal value with first i items and j capacity
    	// Normally DP will have an extra column and row, and normally
    	// initialized to zero
    	int[][] T = new int[length + 1][capacity + 1];
    	
    	for (int i = 1; i <= length; i++) {
    		for (int c = 1; c <= capacity; c++) {
    			if (items.get(i - 1).weight > c) {
    				// ith item cannot fit
    				T[i][c] = T[i][c]; 
    			} else {
    				// Choose current item
    				Item curr = items.get(i - 1);
    				int val1 = T[i - 1][c - curr.weight] + curr.value;
    				
    				// Not choose current item
    				int val2 = T[i - 1][c]; 
    				
    				// The max goes into T[i][c]
    				T[i][c] = Math.max(val1, val2);
    			}
    		}
    	}
    	
    	return T[length][capacity]; 
    }
}
