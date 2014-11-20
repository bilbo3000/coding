import java.util.HashSet;
import java.util.Set;

public class AlienAndPassword {
    public int getNumber(String S) {
        int result = 0;
        Set<String> set = new HashSet<String>();

        for (int i = 0; i < S.length(); i++) {
            StringBuilder sb = new StringBuilder(S);
            sb.deleteCharAt(i);
            String temp = sb.toString();

            if (!set.contains(temp)) {
                set.add(temp);
                result++;
            }
        }

        return result;
    }
}
