/**
 * Given a list stones. Value represents the stone's distance. A frog 
 * can only jump onto stones. And if frog jump k, next jump distance
 * can only be either k - 1, k, k + 1. Determine if frog can cross. 
 * 
 * This DP solution. The idea is that T[i][j] is true if frog
 * can jump to index i stone with jump distance as j. Therefore, T[i][j]
 * is true if T[k][j] or T[k][j - 1] or T[k][j + 1] is true where 
 * num[k] + j == num[i]. 
 * 
 * Use hashmap to reverse map from each element to its index for quick access. 
 * Only T[0][0] is initialized to true. Rest of first role cannot be true 
 * cause it could produce invalid next jump distance.
 * 
 * Time: O(n^2)
 * Space: O(n^2)
 */ 
public class Solution {
	public boolean canCross(int[] stones) {
        int l = stones.length; 
        
        if (l == 0 || l == 1) {
        	return true; 
        }
        
        // Build a hash map to reverse map value to its index
        Map<Integer, Integer> m = new HashMap<Integer, Integer>(); 
        
        for (int i = 0; i < l; i++) {
            m.put(stones[i], i);
        }
        
        boolean[][] T = new boolean[l][l]; 
        T[0][0] = true; 

        
        for (int i = 1; i < l; i++) {
        	for (int j = 1; j < l; j++) {
        		// When calculate T[i][j], need to check T[0..i-1][j - 1, j, j + 1]
                int temp = stones[i] - j; 
        		if (m.containsKey(temp)) {
                    int k = m.get(temp);

                    // Can jump from k stone to i stone with j leap length
                    T[i][j] = T[i][j] | T[k][j];

                    if (j - 1 >= 0) {
                        T[i][j] = T[i][j] | T[k][j - 1];
                    }

                    if (j + 1 < l) {
                        T[i][j] = T[i][j] | T[k][j + 1]; 
                    }

                }
        	}
        }
        
        // Check if last stone is reachable
        for (int j = 0; j < l; j++) {
        	if (T[l - 1][j]) {
        		return true; 
        	}
        }
        
        return false; 
    }
}
