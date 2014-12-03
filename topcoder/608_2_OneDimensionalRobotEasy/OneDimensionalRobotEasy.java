public class OneDimensionalRobotEasy {
    public int finalPosition(String commands, int A, int B) {
        int pos = 0;

        for (int i = 0; i < commands.length(); i++) {
            char c = commands.charAt(i);

            if (c == 'R' && pos < B) {
                pos++;
            }

            if (c == 'L' && pos > -A) {
                pos--;
            }
        }

        return pos;
    }
}
