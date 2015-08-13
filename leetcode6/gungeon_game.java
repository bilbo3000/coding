/**
 * Gungeon game. 
 * Solve it using dynamic programming. T[i][j] the minimum health in order to survive 
 * at current cell (at least 1 health). If a dungeon cell is negative, we need to have 
 * the smaller one of next step requires plus whatever we are going to lose in current 
 * cell. If current cell is zero or positive, we need to set the set to be the max between 
 * 1 and the smaller one of next step minus what we are going to gain at current step. 
 */ 
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length; 
        
        if (m == 0) {
            return 0; 
        }
        
        int n = dungeon[0].length; 
        
        if (n == 0) {
            return 0; 
        }
        
        int[][] T = new int[m][n];
        
        if (dungeon[m - 1][n - 1] < 0) {
            T[m - 1][n - 1] = 1 - dungeon[m - 1][n - 1]; 
        } else {
            T[m - 1][n - 1] = 1; 
        }
        
        int j = n - 2; 
        
        while (j >= 0) {
            if (dungeon[m - 1][j] < 0) {
                T[m - 1][j] = T[m - 1][j + 1] - dungeon[m - 1][j]; 
            } else {
                T[m - 1][j] = Math.max(1, T[m - 1][j + 1] - dungeon[m - 1][j]); 
            }
            
            j--;
        }
        
        int i = m - 2; 
        
        while (i >= 0) {
            if (dungeon[i][n - 1] < 0) {
                T[i][n - 1] = T[i + 1][n - 1] - dungeon[i][n - 1]; 
            } else {
                T[i][n - 1] = Math.max(1, T[i + 1][n - 1] - dungeon[i][n - 1]); 
            }
            
            i--; 
        }
        
        for (int a = m - 2; a >= 0; a--) {
            for (int b = n - 2; b >= 0; b--) {
                int min = Math.min(T[a + 1][b], T[a][b + 1]); 
                
                if (dungeon[a][b] < 0) {
                    T[a][b] = min - dungeon[a][b]; 
                } else {
                    T[a][b] = Math.max(1, min - dungeon[a][b]); 
                }
            }
        }
        
        return T[0][0]; 
    }
}
