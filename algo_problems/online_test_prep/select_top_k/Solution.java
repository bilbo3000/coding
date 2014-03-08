import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    ArrayList<Record> topK(ArrayList<Record> records, int k) {
        ArrayList<Record> result = new ArrayList<Record>();

        if (k <= 0) {
            return result;
        }

        PriorityQueue<Record> pqueue = new PriorityQueue<Record>(k, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.val - o2.val;
            }
        });  // Min heap

        for (int i = 0; i < records.size(); i++) {
            Record curr = records.get(i);

            if (pqueue.size() < k) {
                pqueue.offer(curr);
            }
            else {
                if (curr.val > pqueue.peek().val) {
                    pqueue.poll();
                    pqueue.offer(curr);
                }
            }
        }

        while (pqueue.size() != 0) {
            result.add(0, pqueue.poll());
        }

        return result;
    }
}
