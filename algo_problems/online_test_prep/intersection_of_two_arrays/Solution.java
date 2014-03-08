import java.util.*;

public class Solution {
    ArrayList<Integer> intersectionArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < m; i++) {
            map.put(a[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(b[i])) {
                result.add(b[i]);
            }
        }

        return result;
    }
}
