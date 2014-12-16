import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
    
    private static long Solve(int N, int C, int M){
        
         //Write code to solve each of the test over here
        // N: money; C: cost of chocolate; M: wrapper; 
        int cnt = N / C; 
        int wrapper = cnt; 
        
        while (wrapper >= M) {
            int extra = wrapper / M; 
            wrapper -= extra * M; 
            wrapper += extra; 
            cnt += extra; 
        }
        
        return (long) cnt; 
    }
    
    
}
