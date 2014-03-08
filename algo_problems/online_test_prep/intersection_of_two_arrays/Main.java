import java.util.*;

public class Main {
    public static void main(String [] args) {
        Solution sln = new Solution();
        ArrayList<Integer> result = sln.intersectionArrays(new int[] {2, 1, 2, 3, 4}, new int[] {2, 2, 4, 5});
        for (int item : result) {
            System.out.println(item);
        }
    }
}
