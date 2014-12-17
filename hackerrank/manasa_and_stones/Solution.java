import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in); 
        int lines = scanner.nextInt(); 
        
        for (int i = 0; i < lines; i++) {
            int n = scanner.nextInt(); 
            int a = scanner.nextInt(); 
            int b = scanner.nextInt(); 
            Set<Integer> set = new HashSet<Integer>(); 
            set.add(0);
            
            for (int j = 0; j < n - 1; j++) {
                Set<Integer> newSet = new HashSet<Integer>(); 
                
                for (int item : set) {
                    newSet.add(item + a);
                    newSet.add(item + b); 
                }
                
                set = newSet; 
            }
            
            List<Integer> l = new ArrayList<Integer>(); 
            l.addAll(set); 
            Collections.sort(l); 
            
            for (int item : l) {
                System.out.print(item);
                System.out.print(" "); 
            }
            
            System.out.println(); 
        }
    }
}
