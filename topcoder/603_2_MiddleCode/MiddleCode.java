public class MiddleCode {
    public String encode(String s) {
        String output = "";

        while (s.length() != 0) {
            StringBuilder sb = new StringBuilder(s);
            int len = sb.length();

            if (len % 2 == 0) {  // even
                int r = len / 2;
                int l = r - 1;
                int index = r;

                if (sb.charAt(l) < sb.charAt(r)) {
                    index = l;
                }

                output += sb.charAt(index);
                sb.deleteCharAt(index);
            } else {  // odd
                int index = len / 2;
                output += sb.charAt(index);
                sb.deleteCharAt(index);
            }

            s = sb.toString();
        }

        return output;
    }
}
