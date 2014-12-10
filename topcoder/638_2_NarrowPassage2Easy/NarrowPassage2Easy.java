import java.util.*;

public class NarrowPassage2Easy {
    public int count(int[] size, int maxSizeSum) {
        Set<List<Integer>> history = new HashSet<List<Integer>>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        int len = size.length;

        for (int i = 0; i < len; i++) {
            temp.add(i);
        }

        list.add(temp);
        history.add(temp);

        int l = 0;
        int r = 0;
        int prevSize = 0;

        while (list.size() != prevSize) {
            prevSize = list.size();
            for (int i = l; i <= r; i++) {
                List<Integer> curr = list.get(i);

                for (int j = 0; j < curr.size() - 1; j++) {
                    int index0 = curr.get(j);
                    int index1 = curr.get(j + 1);

                    if (size[index0] + size[index1] <= maxSizeSum) {
                        List<Integer> t = new ArrayList<Integer>(curr);
                        int save = t.get(j);
                        t.set(j, t.get(j + 1));
                        t.set(j + 1, save);

                        if (!history.contains(t)) {
                            list.add(t);
                            history.add(t);
                        }
                    }
                }
            }
            l = r + 1;
            r = list.size() - 1;
        }

        return history.size();
    }
}
