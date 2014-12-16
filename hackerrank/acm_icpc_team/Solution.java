import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Number of people 
        int m = in.nextInt(); // Number of topics 
        int[] arr = new int[m + 1];
        String[] lines = new String[n];

        for (int i = 0; i < n; i++) {
            lines[i] = in.next();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String line1 = lines[i];
                String line2 = lines[j];
                int cnt = 0;

                for (int k = 0; k < m; k++) {
                    if (line1.charAt(k) == '1' || line2.charAt(k) == '1') {
                        cnt++;
                    }
                }

                arr[cnt]++;
            }
        }

        int maxTopics = 0;
        int maxTeam = 0;

        for (int i = m; i >= 0; i--) {
            if (arr[i] != 0) {
                maxTeam = arr[i];
                maxTopics = i;
                break;
            }
        }

        System.out.println(maxTopics);
        System.out.println(maxTeam);
    }
}
