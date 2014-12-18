import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            int n = scanner.nextInt();

            List<Integer> list = new ArrayList<Integer>();
            int gc = scanner.nextInt(); 
            n--; 
            
            while (n > 0) {
                gc = gcd(gc, scanner.nextInt()); 
                n--;
            }

            if (gc == 1) {
                System.out.println("YES"); 
            } else {
                System.out.println("NO"); 
            }

            t--;
        }
    }

    private static int gcdM(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }

        if (list.size() == 1) {
            return list.get(0);
        }

        int a = list.get(0);
        int b = list.get(1);
        list.remove(1);
        list.remove(0);
        int g = gcd(a, b);
        list.add(0, g);

        if (g == 1) {
            return 1;
        }

        return gcdM(list);
    }

    private static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            int temp = b; 
            b = a % b; 
            a = temp; 
        }
        
        if (a == 0) {
            return b;
        }
        else {
            return a;
        }
    }
}
