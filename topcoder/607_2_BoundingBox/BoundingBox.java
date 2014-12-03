public class BoundingBox {
    public int smallestArea(int[] X, int[] Y) {
        int minX = X[0];
        int maxX = X[0];
        int minY = Y[0];
        int maxY = Y[0];
        int len = X.length;

        for (int i = 1; i < len; i++) {
            minX = Math.min(minX, X[i]);
            maxX = Math.max(maxX, X[i]);
            minY = Math.min(minY, Y[i]);
            maxY = Math.max(maxY, Y[i]);
        }

        int lenx = Math.abs(maxX - minX);
        int leny = Math.abs(maxY - minY);

        return lenx * leny;
    }
}
