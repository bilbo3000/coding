import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {
    private static int min;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            String line = scanner.next();
            min = line.length();
            helper(line, 0, "");
            System.out.println(min);
            t--;
        }
    }

    private static void helper(String line, int index, String curr) {
        if (index == line.length()) {
            min = Math.min(min, line.length() - curr.length());
            return;
        }

        char c = line.charAt(index);

        if (curr.length() == 0 || c != curr.charAt(curr.length() - 1)) {
            helper(line, index + 1, curr + c);
        } else {
            helper(line, index + 1, curr);
        }
    }
}
