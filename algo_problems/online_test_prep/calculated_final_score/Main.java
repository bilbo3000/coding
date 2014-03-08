import java.util.*;

public class Main {
    public static void main(String [] args) {
        Solution sln = new Solution();
        List<TestResult> results = new ArrayList<TestResult>();
        TestResult r1 = new TestResult(1, 3);
        TestResult r2 = new TestResult(2, 5);
        TestResult r3 = new TestResult(1, 1);
        TestResult r4 = new TestResult(2, 6);
        TestResult r5 = new TestResult(2, 4);
        TestResult r6 = new TestResult(1, 2);

        results.add(r1);
        results.add(r2);
        results.add(r3);
        results.add(r4);
        results.add(r5);
        results.add(r6);

        Map<Integer, Double> result = sln.calculateFinalScores(results);

        Set<Integer> keySet = result.keySet();

        for (int key : keySet) {
            System.out.println(key + "=" + result.get(key));
        }
    }
}
