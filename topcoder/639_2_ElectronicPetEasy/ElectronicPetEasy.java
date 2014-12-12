import java.util.HashSet;
import java.util.Set;

public class ElectronicPetEasy {
    public String isDifficult(int st1, int p1, int t1, int st2, int p2, int t2) {
        Set<Integer> history = new HashSet<Integer>();
        int t = st1;

        while (t1 > 0) {
            if (history.contains(t)) {
                return "Difficult";
            }
            history.add(t);
            t += p1;
            t1--;
        }

        t = st2;

        while (t2 > 0) {
            if (history.contains(t)) {
                return "Difficult";
            }

            history.add(t);
            t += p2;
            t2--;
        }

        return "Easy";
    }
}
