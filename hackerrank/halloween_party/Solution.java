import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner in = new Scanner(System.in);
    long n = in.nextLong(); 
    
    for (long i = 0; i < n; i++) {
        long c = in.nextLong(); 
        long a = c / 2; 
        long b = c - a; 
        System.out.println(a * b); 
    }
    }
}
