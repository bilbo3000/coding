/*
Document your assumptions
-- The assumption made here is that the sum of top 5 scores for each student does
    not exceeds the integer max limit.
-- Each student has as least 5 scores.

Explain your approach and how you intend to solve the problem
-- The core idea here is to map each student id to a priority queue.
-- When walk through all the results, we hash each score to its corresponding student. The
    score is directly added to corresponding queue if queue size is less than 5. When the queue
    size is 5, we replace the queue head with current score only if current score is higher.
-- As a result, each queue would end up having the 5 highest scores for a student id.
-- Find the average of the 5 scores for each queue would lead to the solution.

Provide code comments where applicable
Explain the big-O run time complexity of your solution. Justify your answer.
-- Walk through the test results requires O(n)
-- Maintain each priority queue would be constant since the queue size is 5.
-- Hash table hashing requires O(1)
-- Overall, the run time complexity is O(n). This is a linear algorithm. 

Identify any additional data structures you used and justify why you used them.
-- The priority queue is used to serve as min-heap with size 5 that keeps track of the
    highest 5 test scores.
-- A hash table is use to provide fast access to student id.

Only provide your best answer to each part of the question.
 */

class TestResult {
      int studentId;
      String testDate;
      int testScore;
   }
 
public class FinalScoreQuestion {

    Map <Integer, Double> calculateFinalScores (List<TestResult> results) {
        int k = 5;  // Top 5 scores

        // Map student id to a priority queue with top 5 test scores
        // The priority queue simulates a min-heap
        Map<Integer, PriorityQueue<Integer>> m = new HashMap<Integer, PriorityQueue<Integer>>();

        for (TestResult result : results) {
            int id = result.studentId;
            int score = result.testScore;

            // If a new student, add corresponding entry in the map
            if (!m.containsKey(id)) {
                m.put(id, new PriorityQueue<Integer>(k));
            }

            PriorityQueue<Integer> queue = m.get(id);

            if (queue.size() < k) {
                // Add score to queue directly if not full
                queue.offer(score);
            }
            else {
                // Full, remove lowest score from top of queue and then add the new score
                if (score > queue.peek()) {
                    queue.poll();
                    queue.offer(score);
                }
            }
        }

        // Map that collects the results
        Map<Integer, Double> result = new HashMap<Integer, Double>();
        Set<Integer> keySet = m.keySet();

        for (int key : keySet) {
            PriorityQueue<Integer> value = m.get(key);
            double finalScore = 0.0;

            while (value.size() != 0) {
                finalScore += value.poll();
            }

            // Calculate the average of top five
            finalScore /= k;
            result.put(key, finalScore);  // Collect the result
        }

        return result;
    }
}
