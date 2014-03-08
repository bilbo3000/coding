import java.util.PriorityQueue;
import java.util.*;

public class Solution {
    public Map<Integer, Double> calculateFinalScores(List<TestResult> results) {
        int k = 5;
        Map<Integer, PriorityQueue<Integer>> m = new HashMap<Integer, PriorityQueue<Integer>>();

        for (TestResult result : results) {
            int id = result.studentId;
            int score = result.testScore;

            if (!m.containsKey(id)) {
                m.put(id, new PriorityQueue<Integer>(k));
            }

            PriorityQueue<Integer> queue = m.get(id);

            if (queue.size() < k) {
                queue.offer(score);
            }
            else {
                if (score > queue.peek()) {
                    queue.poll();
                    queue.offer(score);
                }
            }
        }

        Map<Integer, Double> result = new HashMap<Integer, Double>();

        Set<Integer> keySet = m.keySet();

        for (int key : keySet) {
            PriorityQueue<Integer> value = m.get(key);
            double finalScore = 0.0;

            System.out.println("size: " + value.size());

            while (value.size() != 0) {
                finalScore += value.poll();
            }

            finalScore /= k;
            result.put(key, finalScore);
        }

        return result;
    }
}
