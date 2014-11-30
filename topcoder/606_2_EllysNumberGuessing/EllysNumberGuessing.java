import java.util.*;

public class EllysNumberGuessing {
    private static final int MIN = 1;
    private static final int MAX = 1000000000;

    public int getNumber(int[] guesses, int[] answers) {
        int len = guesses.length;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int i = 0; i < len; i++) {
            int low = guesses[i] - answers[i];
            int high = guesses[i] + answers[i];

            if (low == high) {
                if (!m.containsKey(guesses[i])) {
                    m.put(guesses[i], 1);
                } else {
                    m.put(guesses[i], m.get(guesses[i]) + 1);
                }
            } else {
                if (low >= MIN) {
                    if (!m.containsKey(low)) {
                        m.put(low, 1);
                    } else {
                        m.put(low, m.get(low) + 1);
                    }
                }

                if (high <= MAX) {
                    if (!m.containsKey(high)) {
                        m.put(high, 1);
                    } else {
                        m.put(high, m.get(high) + 1);
                    }
                }
            }
        }

        List<Integer> keys = new ArrayList<Integer>();
        Set<Integer> keySet = m.keySet();

        for (int key : keySet) {
            if (m.get(key) == len) {
                keys.add(key);
            }
        }

        if (keys.size() == 0) {
            return -2;
        }

        if (keys.size() > 1) {
            return -1;
        }

        return keys.get(0);
    }
}
