import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            int n = scanner.nextInt();

            List<Integer> list = new ArrayList<Integer>();

            while (n > 0) {
                list.add(scanner.nextInt());
                n--;
            }

            Set<List<Integer>> subset = new HashSet<List<Integer>>();
            List<Integer> first = new ArrayList<Integer>();
            first.add(list.get(0));
            subset.add(first);

            for (int i = 1; i < list.size(); i++) {
                Set<List<Integer>> tempSet = new HashSet<List<Integer>>();

                for (List<Integer> item : subset) {
                    List<Integer> tempList = new ArrayList<Integer>(item);
                    tempList.add(list.get(i));
                    Collections.sort(tempList);
                    tempSet.add(tempList);
                }

                subset.addAll(tempSet);
            }

            boolean fail = false;

            for (List<Integer> item : subset) {
                int g = gcdM(item);

                if (g <= 1) {
                    System.out.println("YES");
                    fail = true;
                    break;
                }
            }

            if (!fail) {
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
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
