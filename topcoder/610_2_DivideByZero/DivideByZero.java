import java.util.*;

public class DivideByZero {
    public int CountNumbers(int[] numbers) {
        Set<Integer> history = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int i : numbers) {
            list.add(i);
        }

        history.addAll(list);
        int prevSize = 0;

        while (list.size() != prevSize) {
            prevSize = list.size();
            Collections.sort(list);

            for (int i = list.size() - 1; i > 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    int d1 = list.get(i);
                    int d2 = list.get(j);

                    if (d1 > d2) {
                        int n = d1 / d2;

                        if (!history.contains(n)) {
                            history.add(n);
                            list.add(n);
                        }
                    }
                }
            }
        }

        return list.size();
    }
}
