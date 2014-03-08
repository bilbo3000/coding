import java.util.*;

public class Solution {
    ArrayList<Integer> intersectionSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        ArrayList<Integer> result = new ArrayList<Integer>();

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (a[i] == b[j]) {
                result.add(a[i]);
                i++;
                j++;
            }
            else if (a[i] < b[j]) {
                i++;
            }
            else{
                j++;
            }
        }

        return result;
    }
}
