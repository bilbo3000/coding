import java.util.Arrays;

/**
 * Given a matrix of characters, find the smallest path in sorted 
 * lexicographical order. 
 * 
 * The idea is to use dynamic programming. 
 * Let f(i, j) be the sorted smallest lexicographical order path to 
 * reach position [i, j]. Therefore, we have the equation below: 
 * 
 * f(i, j) = sort(mat[i][j] + smaller(f[i, j - 1], f[i - 1][j])), 
 * where + is concatenate; smaller() returns the smaller value in 
 * lexicographical order; sort() will sort the string in lexicographical 
 * order. 
 * 
 * Time: O(m * n * (m + n)log(m + n)), the log portion is due to sorting; 
 * Space: O(m * n)
 */
public class Solution {
    public String smallestLexicoPath(char[][] mat) {
    	if (mat == null || mat.length == 0 || mat[0].length == 0) {
    		return ""; 
    	}
    	
    	int m = mat.length; 
    	int n = mat[0].length; 
    	String[][] T = new String[m][n]; 
    	T[0][0] = String.valueOf(mat[0][0]); 
    	
    	// Initialize first row
    	for (int j = 1; j < n; j++) {
    		String temp = mat[0][j] + T[0][j - 1];
    		char[] arr = temp.toCharArray(); 
    		Arrays.sort(arr);
    		T[0][j] = new String(arr);
    	}
    	
    	// Initialize first column
    	for (int i = 1; i < m; i++) {
    		String temp = mat[i][0] + T[i - 1][0];
    		char[] arr = temp.toCharArray();
    		Arrays.sort(arr);
    		T[i][0] = new String(arr);
    	}
    	
    	// Fill T using dynamic programming
    	// T[i][j] = sort(mat[i][j] + smaller(T[i][j - 1], T[i - 1][j]))
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			if (T[i][j - 1].compareTo(T[i - 1][j]) < 0) {
    				// Left is smaller
    				T[i][j] = mat[i][j] + T[i][j - 1]; 
    			} else {
    				// Up is smaller
    				T[i][j] = mat[i][j] + T[i - 1][j];
    			}
    			
    			char[] arr = T[i][j].toCharArray();
    			Arrays.sort(arr);
    			T[i][j] = new String(arr);
    		}
    	}
    	
    	return T[m - 1][n - 1]; 
    }
}
