import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        Solution sln = new Solution();
        ArrayList<Point> points = new ArrayList<Point>();
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 3);
        Point p3 = new Point(1, 0);
        Point p4 = new Point(0, 2);
        Point p5 = new Point(-1, 1);
        Point p6 = new Point(-1, 0);

        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p5);
        points.add(p6);

        ArrayList<Point> result = sln.nearestK(points, 3);

        for (Point p : result) {
            System.out.println(p.x + " " + p.y  + " " + p.distSquare());
        }
    }
}
