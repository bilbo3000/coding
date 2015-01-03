import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt(); 
        String[] input = new String[n]; 
        
        for (int i = 0; i < n; i++) {
            input[i] = in.next(); 
        }
        
        char[][] board = new char[n][n]; 
        
        for (int i = 0; i < n; i++) {
            String s = input[i]; 
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j); 
            }
        }
        
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] > board[i - 1][j] && board[i][j] > board[i][j + 1] && board[i][j] > board[i + 1][j] && board[i][j] > board[i][j - 1]) {
                    board[i][j] = 'X'; 
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(String.valueOf(board[i])); 
        }
    }
}
