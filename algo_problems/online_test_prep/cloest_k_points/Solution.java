import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ArrayList<Point> nearestK(ArrayList<Point> points, int k) {
        ArrayList<Point> result = new ArrayList<Point>();

        if (points.size() == 0 || k == 0) {
            return result;
        }

        PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                double temp1 = p1.distSquare();
                double temp2 = p2.distSquare();

                if (temp2 < temp1) {
                    return -1;
                }
                else if (temp2 > temp1) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });  // Max heap

        for (Point p : points) {
            if (queue.size() < k) {
                queue.offer(p);
            }
            else {
                if (p.distSquare() < queue.peek().distSquare()) {
                    queue.poll();
                    queue.offer(p);
                }
            }
        }

        while (queue.size() != 0) {
            result.add(0, queue.poll());
        }

        return result;
    }
}
