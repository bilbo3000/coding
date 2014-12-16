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

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int cnt = 0;

            int j = a; 
            int temp = 0; 
            
            while (j <= b) {
                temp = (int) Math.sqrt(((double)j));
                if (temp * temp == j) {
                    break; 
                }
                j++; 
            }
            
            while (j <= b && temp * temp <= b) {
                cnt++; 
                temp++; 
            }

            System.out.println(cnt);
        }

    }
}
