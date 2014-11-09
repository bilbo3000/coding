import java.util.Comparator;
import java.util.PriorityQueue;

public class Bonuses {
    class Employee {
        int index;
        int point;
        Employee(int index, int point) {
            this.index = index;
            this.point = point;
        }
    }
    public int[] getDivision(int[] points) {
        int len = points.length;

        if (len == 0) {
            return null;
        }

        int [] result = new int[len];
        int totalPoints = 0;
        PriorityQueue<Employee> pq = new PriorityQueue<Employee>(len, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o2.point == o1.point) {
                    return o1.index - o2.index;
                }

                return o2.point - o1.point;
            }
        });

        for (int i = 0; i < len; i++) {
            totalPoints += points[i];
            Employee e = new Employee(i, points[i]);
            pq.add(e);
        }

        int currPercent = 0;

        for (int i = 0; i < len; i++) {
            result[i] = points[i] * 100 / totalPoints;
            currPercent += result[i];
        }

        int remainPercent = 100 - currPercent;

        while (remainPercent > 0) {
            PriorityQueue<Employee> tempq = new PriorityQueue<Employee>(len, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    if (o2.point == o1.point) {
                        return o1.index - o2.index;
                    }

                    return o2.point - o1.point;
                }
            });

            while (pq.size() > 0) {
                Employee e = pq.poll();
                result[e.index]++;
                remainPercent--;
                tempq.add(e);

                if (remainPercent == 0) {
                    break;
                }
            }
        }

        return result;
    }
}
