import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in); 
        int v = in.nextInt(); 
        int size = in.nextInt(); 
        int[] arr = new int[size]; 
        
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt(); 
        }
        
        for (int i = 0; i < size; i++) {
            if (arr[i] == v) {
                System.out.println(i); 
                return; 
            }
        }
        
        return; 
    }
}
