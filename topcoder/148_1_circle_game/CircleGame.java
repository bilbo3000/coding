import java.util.ArrayList;
import java.util.List;

public class CircleGame {
    public int cardsLeft(String deck) {
        char[] arr = deck.toCharArray();
        List<Integer> l = new ArrayList<Integer>();

        for (char c : arr) {
            if (c == 'K') {
                continue;
            }
            else if (c == 'T') {
                l.add(10);
            }
            else if (c == 'J') {
                l.add(11);
            }
            else if (c == 'Q') {
                l.add(12);
            }
            else if (c == 'A') {
                l.add(1);
            }
            else {
                l.add((int) (c - '0'));
            }
        }

        int prevLen = 0;
        int currLen = l.size();

        while (currLen != prevLen) {
            int i = 0;
            prevLen = currLen;

            while (i < l.size()) {
                int sum = 0;

                if (i < l.size() - 1) {
                    sum = l.get(i) + l.get(i + 1);

                    if (sum == 13) {
                        l.remove(i + 1);
                        l.remove(i);
                    } else {
                        i++;
                    }
                } else if (i == l.size() - 1 && l.size() > 1) {
                    sum = l.get(i) + l.get(0);

                    if (sum == 13) {
                        l.remove(i);
                        l.remove(0);
                        i = l.size();
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }
            }

            currLen = l.size();
        }

        return l.size();
    }
}
