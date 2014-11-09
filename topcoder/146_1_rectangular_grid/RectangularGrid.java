public class RectangularGrid {
    public long countRectangles(int width, int height) {
        long result = 0;

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (i != j) {
                    for (int a = 0; a <= height - i; a++) {
                        for (int b = 0; b <= width - j; b++) {
                            result++;
                        }
                    }
                }
            }
        }

        return result;
    }
}
