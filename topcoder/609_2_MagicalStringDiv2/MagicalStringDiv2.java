public class MagicalStringDiv2 {
    public int minimalMoves(String S) {
        int len = S.length();
        StringBuilder sb = new StringBuilder(S);
        int cnt = 0;

        for (int i = 0; i < len / 2; i++) {
            if (sb.charAt(i) == '<') {
                sb.setCharAt(i, '>');
                cnt++;
            }
        }

        for (int i = len / 2; i < len; i++) {
            if (sb.charAt(i) == '>') {
                sb.setCharAt(i, '<');
                cnt++;
            }
        }

        return cnt;
    }
}
