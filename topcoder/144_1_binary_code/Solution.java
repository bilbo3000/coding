public class BinaryCode {
    public String[] decode(String message) {
        String[] result = new String[] {"NONE", "NONE"};
        int len = message.length();

        if (len == 0 || len == 1) {
            return result;
        }
        char[] e = message.toCharArray();
        char[] d0 = new char[len];
        char[] d1 = new char[len];

        // Assume 0
        d0[0] = '0';
        int i = 1;
        while (i < len) {
            if (i == 1) {
                int digit1 = (int) (e[0] - '0');

                if (digit1 > 1) {
                    break;
                }

                d0[1] = (char) (digit1 + '0');
            } else if (i == len - 1) {
                int digit1 = (int) (e[len - 1] - '0');
                int digit2 = digit1 -  (int) (d0[i - 1] - '0');
                if (digit2 > 1) break;
                if (digit2 + (int) (d0[i - 1] - '0') != e[len - 1]) break;
                d0[i] = (char) (digit2 + '0');
            } else {
                int digit1 = (int) (e[i - 1] - '0');
                int digit2 = (int) (d0[i - 2] - '0');
                int digit3 = (int) (d0[i - 1] - '0');
                int digit4 = digit1 - digit2 - digit3;
                if (digit4 > 1) break;
                d0[i] = (char) (digit4 + '0');
            }
            i++;
        }

        if (i == len) {
            result[0] = String.valueOf(d0);
        }

        // Assume 1
        d1[0] = '1';
        int j = 1;
        while (j < len){
            if (j == 1) {
                int digit1 = (int) (e[0] - '1');

                if (digit1 > 1) {
                    break;
                }

                d1[1] = (char) (digit1 + '0');
            } else if (j == len - 1) {
                int digit1 = (int) (e[len - 1] - '0');
                int digit2 = digit1 -  (int) (d1[j - 1] - '0');
                if (digit2 > 1) break;
                if (digit2 + (int) (d1[i - 1] - '0') != e[len - 1]) break;
                d1[j] = (char) (digit2 + '0');
            } else {
                int digit1 = (int) (e[j - 1] - '0');
                int digit2 = (int) (d1[j - 2] - '0');
                int digit3 = (int) (d1[j - 1] - '0');
                int digit4 = digit1 - digit2 - digit3;
                if (digit4 > 1) break;
                d1[j] = (char) (digit4 + '0');
            }
            j++;
        }

        if (j == len) {
            result[1] = String.valueOf(d1);
        }

        return result;
    }
}
