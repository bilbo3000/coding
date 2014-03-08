/**
 * Created by Dongpu on 2/8/14.
 */
public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distSquare() {
        return Math.pow(x, 2) + Math.pow(y, 2);
    }
}
