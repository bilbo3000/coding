import java.util.Arrays;

public class EllysSubstringSorter {
    public String getMin(String S, int L) {
        int index = S.length() - L;
        String left = S.substring(0, index + 1);
        String right = S.substring(index + 1);
        char[] arr = left.toCharArray();
        Arrays.sort(arr);
        String temp = String.valueOf(arr);

        return temp + right;
    }
}
