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
        ArrayList<Integer> arr = new ArrayList<Integer>();  
        
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt(); 
            if (temp != 0) {
                arr.add(temp); 
            }
        }
        
        Collections.sort(arr); 
        
        while (arr.size() > 0) {
            int size = arr.size();  
            int min = arr.get(0); 
            
            for (int i = 0; i < arr.size(); i++) {
                int diff = arr.get(i) - min; 
                
                if (diff <= 0) {
                    arr.remove(i); 
                    i--; 
                }
                else {
                    arr.set(i, diff); 
                }
            }
            
            System.out.println(size); 
        }
    }
}
