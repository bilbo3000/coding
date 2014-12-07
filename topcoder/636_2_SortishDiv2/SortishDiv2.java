import java.util.*;

public class SortishDiv2 {
    private int result = 0;
    private int sortedness = 0;

    public int ways(int sorted, int[] seq) {
        this.sortedness = sorted;
        int len = seq.length;
        Set<Integer> history = new HashSet<Integer>();

        for (int item : seq) {
            if (item != 0) {
                history.add(item);
            }
        }

        List<Integer> l = new ArrayList<Integer>();

        for (int i = 1; i <= len; i++) {
            if (!history.contains(i)) {
                l.add(i);
            }
        }

        helper(seq, 0, l);

        return result;
    }

    private void helper(int[] seq, int index, List<Integer> l) {
        int i = index;
        int len = seq.length;

        while (i < len && seq[i] != 0) {
            i++;
        }

        if (i == len) {
            int temp = sortedness;

            for (int x = 0; x < len - 1; x++) {
                for (int y = x + 1; y < len; y++) {
                    if (seq[x] != 0 && seq[y] != 0 && seq[x] < seq[y]) {
                        temp--;
                    }
                }
            }

            if (temp == 0) {
                result++;
            }

            return;
        }
        else {
            for (int j = 0; j < l.size(); j++) {
                List<Integer> templ = new ArrayList<Integer>(l);
                int[] tempseq = seq.clone();
                tempseq[i] = l.get(j);
                templ.remove(j);
                helper(tempseq, index + 1, templ);
            }
        }
    }
}
